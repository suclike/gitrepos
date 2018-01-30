package de.sample.gitrepos.ui.model.presenter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import de.sample.gitrepos.client.ApiConstants;
import de.sample.gitrepos.domain.service.GetRepoService;
import de.sample.gitrepos.model.RepoUIModel;
import de.sample.gitrepos.storage.SharedPreferencesLocalStorage;
import de.sample.gitrepos.ui.model.RepoListView;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RepoListPresenter extends BasePresenter<RepoListView> {

    private static final String REPO_LIST = "repoList";
    private static final String REPO_LIST_PAGE = "repoListPage";

    private static final int DEFAULT_REPO_PER_PAGE_AMOUNT = 10;
    private static final String OAUTH_ACCESS_TOKEN = "0cc2f1a70f2fc2072fa1dd5e4383e003438e861a";

    private GetRepoService repoService;
    private SharedPreferencesLocalStorage sharedPreferencesLocalStorage;

    private static final Type type = new TypeToken<List<RepoUIModel>>() { }.getType();
    private Gson gson;

    private List<RepoUIModel> currentRepoList = new ArrayList<>();

    private int currentPage;

    @Inject
    RepoListPresenter(final GetRepoService repoService,
            final SharedPreferencesLocalStorage sharedPreferencesLocalStorage, final Gson gson) {
        this.repoService = repoService;
        this.sharedPreferencesLocalStorage = sharedPreferencesLocalStorage;
        this.gson = gson;
        this.currentPage = getCurrentPage();
    }

    public Subscription getListOfRepo(final int fromPage) {
        return
            repoService.getListOfUIModels(ApiConstants.BASE_REPO_USER, queryParams(fromPage)) //
                       .observeOn(AndroidSchedulers.mainThread())                             //
                       .subscribeOn(Schedulers.io())                                          //
                       .subscribe(new Subscriber<List<RepoUIModel>>() {
                               @Override
                               public void onCompleted() {
                                   getAttachedView().hideProgress();
                                   currentPage++;
                                   sharedPreferencesLocalStorage.putInt(REPO_LIST_PAGE, currentPage);
                               }

                               @Override
                               public void onError(final Throwable e) {
                                   getAttachedView().showEmptyLayout();
                               }

                               @Override
                               public void onNext(final List<RepoUIModel> repo) {
                                   if (!repo.isEmpty()) {
                                       getAttachedView().notifyDataChanged(repo);
                                       saveRepoList(repo);
                                   }
                               }
                           });
    }

    private void saveRepoList(final List<RepoUIModel> repo) {
        currentRepoList.addAll(repo);

        final String jsonList = gson.toJson(currentRepoList, type);

        sharedPreferencesLocalStorage.putString(REPO_LIST, jsonList);
    }

    public List<RepoUIModel> getCurrentRepoList() {
        final String jsonList = sharedPreferencesLocalStorage.getString(REPO_LIST, "");

        if (jsonList.isEmpty()) {
            return new ArrayList<>();
        }

        return gson.fromJson(jsonList, type);
    }

    public int getCurrentPage() {
        return sharedPreferencesLocalStorage.getInt(REPO_LIST_PAGE, 1);
    }

    private Map<String, String> queryParams(final int fromPage) {
        Map<String, String> params = new HashMap<>();
        params.put("page", String.valueOf(fromPage));
        params.put("per_page", String.valueOf(DEFAULT_REPO_PER_PAGE_AMOUNT));
        params.put("access_token", OAUTH_ACCESS_TOKEN);

        return params;
    }

    public void scrollChanged(final int firstVisible, final int visibleItemCount, final int totalItemCount) {
        if ((visibleItemCount + firstVisible) >= totalItemCount && firstVisible >= 0) {
            getListOfRepo(currentPage);
        }
    }
}
