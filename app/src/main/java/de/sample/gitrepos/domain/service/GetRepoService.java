package de.sample.gitrepos.domain.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import de.sample.gitrepos.domain.source.RepoDataSource;
import de.sample.gitrepos.domain.util.RepoBlockToUIModelTransformer;
import de.sample.gitrepos.model.RepoBlock;
import de.sample.gitrepos.model.RepoUIModel;

import rx.Observable;

import rx.functions.Func1;

/**
 * Service to transform {@link RepoBlock} to {@link RepoUIModel} before passing it to UI.
 */
public class GetRepoService implements RepoService {

    private RepoDataSource dataSource;
    private RepoBlockToUIModelTransformer repoBlockToUIModelTransformer;

    @Inject
    GetRepoService(final RepoDataSource dataSource, final RepoBlockToUIModelTransformer repoBlockToUIModelTransformer) {
        this.dataSource = dataSource;
        this.repoBlockToUIModelTransformer = repoBlockToUIModelTransformer;
    }

    @Override
    public Observable<List<RepoUIModel>> getListOfUIModels(final String userName, final Map<String, String> params) {
        return
            dataSource.getRepo(userName, params) //
                      .flatMap(new Func1<List<RepoBlock>, Observable<RepoBlock>>() {
                              @Override
                              public Observable<RepoBlock> call(final List<RepoBlock> repoBlocks) {
                                  return Observable.from(repoBlocks);
                              }
                          })                     //
                      .map(new Func1<RepoBlock, RepoUIModel>() {
                              @Override
                              public RepoUIModel call(final RepoBlock repoBlock) {
                                  return repoBlockToUIModelTransformer.transform(repoBlock);
                              }
                          })                     //
                      .toList();
    }
}
