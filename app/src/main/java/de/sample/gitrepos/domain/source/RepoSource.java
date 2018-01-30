package de.sample.gitrepos.domain.source;

import java.util.List;
import java.util.Map;

import de.sample.gitrepos.model.RepoBlock;

import rx.Observable;

public interface RepoSource {

    Observable<List<RepoBlock>> getRepo(final String user, Map<String, String> params);
}
