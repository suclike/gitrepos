package de.sample.gitrepos.model;

import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import de.sample.gitrepos.domain.model.RepoUrl;

public class RepoUIModel {

    @SerializedName("repo_name")
    @Expose
    public String repoName;

    @SerializedName("description")
    @Expose
    public String description;

    @SerializedName("owner")
    @Expose
    public String owner;

    @SerializedName("repo_url")
    @Expose
    public RepoUrl repoUrl;

    @SerializedName("cell_color")
    @Expose
    @ColorRes
    public int cellColor;

    public RepoUIModel(@NonNull final String repoName, @NonNull final String description, @NonNull final String owner,
            final int cellColor, @NonNull final RepoUrl repoUrl) {
        this.repoName = repoName;
        this.description = description;
        this.owner = owner;
        this.repoUrl = repoUrl;
        this.cellColor = cellColor;
    }
}
