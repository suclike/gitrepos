package de.sample.gitrepos.domain.util;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.mock;

import static junit.framework.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import org.mockito.MockitoAnnotations;

import de.sample.gitrepos.domain.model.Owner;
import de.sample.gitrepos.domain.model.Repo;
import de.sample.gitrepos.domain.model.RepoUrl;

public class RepoToBlockTransformerTest {

    private static final String EMPTY = "";

    private RepoToBlockTransformer transformer;

    private Owner owner;
    private Repo repo;
    private RepoUrl repoUrl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        transformer = new RepoToBlockTransformer();

        owner = mockOwner();
        repo = mockRepo();
        repoUrl = mockRepoUrl();
    }

    @Test(expected = NullPointerException.class)
    public void should_ThrowsNPE_When_TransformingNull() {
        transformer.transform(null);
    }

    @Test(expected = NullPointerException.class)
    public void should_ThrowsNPE_When_FieldsMissing() {
        transformer.transform(repo);
    }

    @Test
    public void should_Transform_When_EmptyField() {
        owner.login = EMPTY;

        repo.name = EMPTY;
        repo.owner = owner;
        repo.description = EMPTY;
        repo.fork = false;

        assertThat(transformer.transform(repo).repoName).isEmpty();
        assertThat(transformer.transform(repo).description).isEmpty();
        assertThat(transformer.transform(repo).owner).isEmpty();
        assertFalse(transformer.transform(repo).fork);
    }

    @Test
    public void should_ComposeEmptyUrlsOnbject_when_EmptyUrlField() {
        assertThat(transformer.getRepoUrl(repo).repoOwnerUrl).isEmpty();
        assertThat(transformer.getRepoUrl(repo).repoUrl).isEmpty();
    }

    @Test
    public void should_ComposeCorrectUrl() {
        repoUrl.repoOwnerUrl = "google.com";
        repoUrl.repoUrl = "yahoo.de";

        repo.htmlUrl = "yahoo.de";
        repo.owner = owner;
        repo.owner.htmlUrl = "google.com";

        assertThat(transformer.getRepoUrl(repo).repoOwnerUrl).isEqualToIgnoringCase("google.com");
        assertThat(transformer.getRepoUrl(repo).repoUrl).isEqualToIgnoringCase("yahoo.de");
    }

    private Owner mockOwner() {
        return mock(Owner.class);
    }

    private Repo mockRepo() {
        return mock(Repo.class);
    }

    private RepoUrl mockRepoUrl() {
        return mock(RepoUrl.class);
    }
}
