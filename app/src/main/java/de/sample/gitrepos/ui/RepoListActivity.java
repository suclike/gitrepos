package de.sample.gitrepos.ui;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import android.support.v4.content.ContextCompat;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ProgressBar;

import butterknife.Bind;
import butterknife.ButterKnife;

import de.sample.gitrepos.BaseApplication;
import de.sample.gitrepos.R;
import de.sample.gitrepos.di.ActivityComponent;
import de.sample.gitrepos.di.ApplicationComponent;
import de.sample.gitrepos.di.module.ActivityModule;
import de.sample.gitrepos.model.RepoUIModel;
import de.sample.gitrepos.ui.adapter.RepoListRecycleViewAdapter;
import de.sample.gitrepos.ui.model.RepoListView;
import de.sample.gitrepos.ui.model.presenter.RepoListPresenter;
import de.sample.gitrepos.ui.util.IntentUtil;
import de.sample.gitrepos.ui.util.MenuUtil;

import rx.Subscription;

import rx.subscriptions.CompositeSubscription;

public class RepoListActivity extends AppCompatActivity implements RepoListView, OnRepoLongClickListener {

    @Bind(R.id.repo_list_recycler_view_toolbar)
    Toolbar toolbar;

    @Bind(R.id.repo_list_recycler_view)
    RecyclerView recyclerView;

    @Bind(R.id.progress_bar)
    ProgressBar progressBar;

    @Bind(R.id.repo_list_recycler_view_empty_layout)
    ViewGroup emptyLayout;

    @Inject
    CompositeSubscription compositeSubscription;

    @Inject
    RepoListPresenter presenter;

    private RepoListRecycleViewAdapter repoListRecycleViewAdapter;
    private LinearLayoutManager recyclerViewLayoutManager;
    private List<RepoUIModel> currentRepoLists;

    // RecycleView scroll listener, implementation is on presenter level
    private final RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {

        @Override
        public void onScrolled(final RecyclerView recyclerView, final int dx, final int dy) {
            onScrollChanged();
        }
    };

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        // handling injection
        ActivityComponent activityComponent = createActivityComponent();
        activityComponent.inject(this);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.repo_list_activity_layout);

        presenter.attachView(this);

        // init butterknife
        ButterKnife.bind(this);

        currentRepoLists = presenter.getCurrentRepoList();

        if (currentRepoLists.isEmpty()) {
            showProgress();

            final int currentPageToRequest = presenter.getCurrentPage();
            final Subscription repoListSubscription = presenter.getListOfRepo(currentPageToRequest);
            compositeSubscription.add(repoListSubscription);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        setupActionBar(toolbar, R.string.app_name);

        initRecycleView(recyclerView, currentRepoLists);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.detachView();
        currentRepoLists.clear();
        compositeSubscription.clear();
    }

    private ActivityComponent createActivityComponent() {
        ApplicationComponent applicationComponent = ((BaseApplication) getApplication()).applicationComponent;
        ActivityModule activityInstanceModule = new ActivityModule(this);
        return applicationComponent.plus(activityInstanceModule);
    }

    protected void setupActionBar(final Toolbar toolbar, @StringRes final int actionBarTitle) {
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(actionBarTitle);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(ContextCompat.getDrawable(this, R.drawable.ic_info_black_48px));
        }
    }

    protected void initRecycleView(final RecyclerView recyclerView, final List<RepoUIModel> currentRepoLists) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(5);

        recyclerViewLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),
                recyclerViewLayoutManager.getOrientation()));

        repoListRecycleViewAdapter = createAdapter(currentRepoLists, this);
        recyclerView.setAdapter(repoListRecycleViewAdapter);

        recyclerView.addOnScrollListener(onScrollListener);
    }

    private void onScrollChanged() {
        int firstVisible = recyclerViewLayoutManager.findFirstVisibleItemPosition();
        int visibleItemCount = recyclerViewLayoutManager.getChildCount();
        int totalItemCount = recyclerViewLayoutManager.getItemCount();

        presenter.scrollChanged(firstVisible, visibleItemCount, totalItemCount);
    }

    @NonNull
    private RepoListRecycleViewAdapter createAdapter(final List<RepoUIModel> transactionLists,
            final OnRepoLongClickListener onRepoLongClickListener) {
        return RepoListRecycleViewAdapter.create(transactionLists, onRepoLongClickListener);
    }

    @Override
    public void showEmptyLayout() {
        emptyLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void notifyDataChanged(final List<RepoUIModel> transactionLists) {
        for (RepoUIModel transactionList : transactionLists) {
            currentRepoLists.add(transactionList);
        }

        repoListRecycleViewAdapter.notifyItemInserted(currentRepoLists.size() - 1);
    }

    @Override
    public void onRepoLongClicked(final int position, final View itemView) {
        final String repoUrl = currentRepoLists.get(position).repoUrl.repoUrl;
        final String repoOwnerUrl = currentRepoLists.get(position).repoUrl.repoOwnerUrl;

        final List<String> menuItems = new ArrayList<>();
        menuItems.add(repoUrl);
        menuItems.add(repoOwnerUrl);

        PopupMenu popupMenu = MenuUtil.browserPopupMenu(itemView, menuItems);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(final MenuItem item) {
                    switch (item.getItemId()) {

                        case 0 :
                            if (IntentUtil.canHandleUrl(repoUrl)) {
                                startActivity(IntentUtil.browserIntent(repoUrl));
                            }

                            return true;

                        case 1 :
                            if (IntentUtil.canHandleUrl(repoOwnerUrl)) {
                                startActivity(IntentUtil.browserIntent(repoOwnerUrl));
                            }

                            return true;
                    }

                    return true;
                }
            });

        popupMenu.show();
    }
}
