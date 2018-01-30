package de.sample.gitrepos.domain.source;

import static org.mockito.Mockito.when;

import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import de.sample.gitrepos.client.service.RepoApi;
import de.sample.gitrepos.domain.model.Repo;
import de.sample.gitrepos.model.RepoBlock;

import rx.Observable;

import rx.functions.Func0;

import rx.observers.TestSubscriber;

import rx.schedulers.TestScheduler;

public class RepoDataSourceTest {

    @Mock
    RepoApi repoApi;

    @InjectMocks
    RepoDataSource repoDataSource;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void should_returnEmptyList() {

        when(repoApi.requestRepo("xing", new HashMap<String, String>())).thenReturn(Observable.defer(
                new Func0<Observable<List<Repo>>>() {
                    @Override
                    public Observable<List<Repo>> call() {
                        return Observable.just(Collections.<Repo>emptyList());
                    }
                }).toSingle());

        TestSubscriber<List<RepoBlock>> testSubscriber = new TestSubscriber<>();
        TestScheduler scheduler = new TestScheduler();
        repoDataSource.getRepo("xing", new HashMap<String, String>()).observeOn(scheduler).subscribeOn(scheduler)
                      .subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        testSubscriber.assertReceivedOnNext(Collections.<List<RepoBlock>>emptyList());
    }
}
