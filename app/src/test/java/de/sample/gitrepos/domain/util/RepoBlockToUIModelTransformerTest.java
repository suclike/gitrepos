package de.sample.gitrepos.domain.util;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.mock;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import org.mockito.MockitoAnnotations;

import de.sample.gitrepos.domain.model.RepoUrl;
import de.sample.gitrepos.model.RepoBlock;

public class RepoBlockToUIModelTransformerTest {

    private static final String DESCRIPTION = "description";
    private static final String REPO_NAME = "repoName";
    private static final String OWNER = "owner";

    private RepoBlockToUIModelTransformer transformer;

    private RepoBlock repoBlock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        transformer = new RepoBlockToUIModelTransformer();

        repoBlock = mockRepoBlock();
    }

    @Test(expected = NullPointerException.class)
    public void should_ThrowsNPE_When_TransformingNull() {
        transformer.transform(null);
    }

    @Test
    public void should_ThrowsNPE_When_FieldsMissing() {
        assertNull(transformer.transform(repoBlock).description);
        assertNull(transformer.transform(repoBlock).owner);
        assertNull(transformer.transform(repoBlock).repoName);
        assertNull(transformer.transform(repoBlock).repoUrl);
        assertNotNull(transformer.transform(repoBlock).cellColor);
    }

    @Test
    public void should_Transform_When_EmptyField() {
        repoBlock.repoName = REPO_NAME;
        repoBlock.description = DESCRIPTION;
        repoBlock.owner = OWNER;

        repoBlock.repoUrl = mockRepoUrl();
        repoBlock.repoUrl.repoUrl = "google.de";
        repoBlock.repoUrl.repoOwnerUrl = "xing.de";

        assertThat(transformer.transform(repoBlock).repoName).isEqualToIgnoringCase(REPO_NAME);
        assertThat(transformer.transform(repoBlock).description).isEqualToIgnoringCase(DESCRIPTION);
        assertThat(transformer.transform(repoBlock).owner).isEqualToIgnoringCase(OWNER);
        assertThat(transformer.transform(repoBlock).repoUrl.repoOwnerUrl).isEqualToIgnoringCase("xing.de");
        assertThat(transformer.transform(repoBlock).repoUrl.repoUrl).isEqualToIgnoringCase("google.de");
    }

    private RepoBlock mockRepoBlock() {
        return mock(RepoBlock.class);
    }

    private RepoUrl mockRepoUrl() {
        return mock(RepoUrl.class);
    }
}
