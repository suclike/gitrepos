package de.sample.gitrepos.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import android.support.annotation.NonNull;

public class RepoUrl {

    @SerializedName("repo_url")
    @Expose
    public String repoUrl;

    @SerializedName("repo_owner_url")
    @Expose
    public String repoOwnerUrl;

    public RepoUrl(@NonNull final String repoUrl, @NonNull final String repoOwnerUrl) {
        this.repoUrl = repoUrl;
        this.repoOwnerUrl = repoOwnerUrl;
    }
}
