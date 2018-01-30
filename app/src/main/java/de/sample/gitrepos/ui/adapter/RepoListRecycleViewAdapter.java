package de.sample.gitrepos.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;

import android.view.ViewGroup;

import de.sample.gitrepos.model.RepoUIModel;
import de.sample.gitrepos.ui.OnRepoLongClickListener;
import de.sample.gitrepos.ui.adapter.viewholder.RepoListViewHolder;

public class RepoListRecycleViewAdapter extends RecyclerView.Adapter<RepoListViewHolder> {

    private List<RepoUIModel> adapterRepoList = new ArrayList<>();
    private OnRepoLongClickListener onRepoLongClickListener;

    public static RepoListRecycleViewAdapter create(final List<RepoUIModel> repoList,
            @NonNull final OnRepoLongClickListener onRepoLongClickListener) {
        return new RepoListRecycleViewAdapter(repoList, onRepoLongClickListener);
    }

    private RepoListRecycleViewAdapter(final List<RepoUIModel> repoList,
            final OnRepoLongClickListener onRepoLongClickListener) {
        this.adapterRepoList = repoList;
        this.onRepoLongClickListener = onRepoLongClickListener;
    }

    @Override
    public RepoListViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return RepoListViewHolder.create(parent, onRepoLongClickListener);
    }

    @Override
    public void onBindViewHolder(final RepoListViewHolder holder, final int position) {
        holder.bind(adapterRepoList.get(position));
    }

    @Override
    public int getItemCount() {
        return adapterRepoList.size();
    }
}
