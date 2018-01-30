package de.sample.gitrepos.ui.model;

import java.util.List;

import de.sample.gitrepos.model.RepoUIModel;

public interface RepoListView {
    void showEmptyLayout();

    void showProgress();

    void hideProgress();

    void notifyDataChanged(List<RepoUIModel> transactionLists);
}
