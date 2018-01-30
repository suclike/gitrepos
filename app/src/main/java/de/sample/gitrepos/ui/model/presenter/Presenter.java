package de.sample.gitrepos.ui.model.presenter;

interface Presenter<V> {
    void attachView(V view);

    void detachView();
}
