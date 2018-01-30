package de.sample.gitrepos.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;

import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;

import de.sample.gitrepos.domain.model.RepoUrl;
import de.sample.gitrepos.model.RepoUIModel;

import rx.Observable;

import rx.functions.Func0;

import rx.observers.AssertableSubscriber;

public class GetRepoServiceTest {

    @Mock
    RepoService repoService;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void getPageByPageKey_Should_PassCorrectArguments() {
        when(repoService.getListOfUIModels("ping", new HashMap<String, String>())).thenReturn(Observable.defer(
                new Func0<Observable<List<RepoUIModel>>>() {
                    @Override
                    public Observable<List<RepoUIModel>> call() {
                        return Observable.just(repoRepoUIModel());
                    }
                }));

        AssertableSubscriber<List<RepoUIModel>> assertableSubscriber = repoService.getListOfUIModels("ping",
                new HashMap<String, String>()).test();
        List<RepoUIModel> repoUIModelList = assertableSubscriber.getOnNextEvents().get(0);

        assertThat(repoUIModelList.size()).isEqualTo(1);

        assertThat(repoUIModelList.get(0).cellColor).isEqualTo(0);
        assertThat(repoUIModelList.get(0).repoName).isEqualTo("test");
        assertThat(repoUIModelList.get(0).description).isEqualTo("basic");
        assertThat(repoUIModelList.get(0).owner).isEqualTo("observable");

        assertThat(repoUIModelList.get(0).repoUrl.repoUrl).isEqualTo("google.de");
        assertThat(repoUIModelList.get(0).repoUrl.repoOwnerUrl).isEmpty();
    }

    private List<RepoUIModel> repoRepoUIModel() {
        List<RepoUIModel> repoBlocks = new ArrayList<>();
        repoBlocks.add(new RepoUIModel("test", "basic", "observable", 0, new RepoUrl("google.de", "")));
        return repoBlocks;
    }
}
