package de.sample.gitrepos.domain.source;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import de.sample.gitrepos.client.service.RepoApi;
import de.sample.gitrepos.domain.model.Repo;
import de.sample.gitrepos.domain.util.RepoToBlockTransformer;
import de.sample.gitrepos.model.RepoBlock;

import rx.Observable;

import rx.functions.Func1;

/**
 * Intermediate level to filter out content and transform to 'block' {@link RepoBlock}.
 */
public class RepoDataSource implements RepoSource {

    private RepoApi repoApi;
    private RepoToBlockTransformer repoToBlockTransformer;

    @Inject
    RepoDataSource(final RepoApi repoApi, final RepoToBlockTransformer repoToBlockTransformer) {
        this.repoApi = repoApi;
        this.repoToBlockTransformer = repoToBlockTransformer;
    }

    @Override
    public Observable<List<RepoBlock>> getRepo(final String user, final Map<String, String> params) {
        return
            repoApi.requestRepo(user, params) //
                   .toObservable()            //
                   .flatMap(new Func1<List<Repo>, Observable<Repo>>() {
                           @Override
                           public Observable<Repo> call(final List<Repo> repos) {
                               return Observable.from(repos);
                           }
                       })                     //
                   .filter(new Func1<Repo, Boolean>() {
                           @Override
                           public Boolean call(final Repo repo) {
                               final String repoName = repo.name;
                               final String repoOwner = repo.owner.login;
                               final String repoDescription = repo.description;

                               return repoName != null && !repoName.isEmpty() && repoOwner != null
                                       && !repoOwner.isEmpty() && repoDescription != null && !repoDescription.isEmpty();
                           }
                       }) //
                   .map(new Func1<Repo, RepoBlock>() {
                           @Override
                           public RepoBlock call(final Repo repo) {
                               return repoToBlockTransformer.transform(repo);
                           }
                       }) //
                   .toList();
    }
}
