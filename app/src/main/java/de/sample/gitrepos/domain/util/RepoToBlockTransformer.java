package de.sample.gitrepos.domain.util;

import javax.inject.Inject;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import de.sample.gitrepos.domain.model.Repo;
import de.sample.gitrepos.domain.model.RepoUrl;
import de.sample.gitrepos.model.RepoBlock;

public class RepoToBlockTransformer implements DataTransformer<Repo, RepoBlock> {

    @Inject
    RepoToBlockTransformer() { }

    @NonNull
    @Override
    public RepoBlock transform(@NonNull final Repo repo) {

        final String repoName = repo.name;
        final String description = repo.description;
        final String owner = repo.owner.login;
        final RepoUrl htmlUrl = getRepoUrl(repo);
        final boolean fork = repo.fork;

        return new RepoBlock(repoName, description, owner, fork, htmlUrl);
    }

    @VisibleForTesting
    RepoUrl getRepoUrl(final Repo repo) {
        String repoUrl = "";
        String repoOwnerUrl = "";
        if (repo.htmlUrl != null && !repo.htmlUrl.isEmpty() && repo.owner.htmlUrl != null
                && !repo.owner.htmlUrl.isEmpty()) {
            repoUrl = repo.htmlUrl;
            repoOwnerUrl = repo.owner.htmlUrl;
        }

        return new RepoUrl(repoUrl, repoOwnerUrl);
    }
}
