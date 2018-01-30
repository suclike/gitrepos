package de.sample.gitrepos.model;

import de.sample.gitrepos.domain.model.RepoUrl;

public class RepoBlock {

    public String repoName;
    public String description;
    public String owner;
    public RepoUrl repoUrl;
    public boolean fork;

    public RepoBlock(final String repoName, final String description, final String owner, final boolean fork,
            final RepoUrl repoUrl) {
        this.repoName = repoName;
        this.description = description;
        this.owner = owner;
        this.fork = fork;
        this.repoUrl = repoUrl;
    }
}
