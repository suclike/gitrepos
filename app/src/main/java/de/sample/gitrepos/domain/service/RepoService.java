package de.sample.gitrepos.domain.service;

import java.util.List;
import java.util.Map;

import de.sample.gitrepos.model.RepoUIModel;

import rx.Observable;

interface RepoService {
    Observable<List<RepoUIModel>> getListOfUIModels(final String userName, Map<String, String> params);
}
