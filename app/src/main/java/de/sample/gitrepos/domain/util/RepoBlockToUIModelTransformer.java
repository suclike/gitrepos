package de.sample.gitrepos.domain.util;

import javax.inject.Inject;

import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;

import de.sample.gitrepos.R;
import de.sample.gitrepos.domain.model.RepoUrl;
import de.sample.gitrepos.model.RepoBlock;
import de.sample.gitrepos.model.RepoUIModel;

public class RepoBlockToUIModelTransformer implements DataTransformer<RepoBlock, RepoUIModel> {

    @Inject
    RepoBlockToUIModelTransformer() { }

    @NonNull
    @Override
    public RepoUIModel transform(@NonNull final RepoBlock repoBlock) {

        final String repoName = repoBlock.repoName;
        final String description = repoBlock.description;
        final String owner = repoBlock.owner;
        final RepoUrl htmlUrl = repoBlock.repoUrl;

        @ColorRes
        int cellColor = repoBlock.fork ? R.color.cell_green_color : R.color.cell_white_color;

        return new RepoUIModel(repoName, description, owner, cellColor, htmlUrl);
    }
}
