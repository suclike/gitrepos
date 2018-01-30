package de.sample.gitrepos.ui.adapter.viewholder;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.sample.gitrepos.R;
import de.sample.gitrepos.model.RepoUIModel;
import de.sample.gitrepos.ui.OnRepoLongClickListener;

public class RepoListViewHolder extends RecyclerView.ViewHolder {

    public static RepoListViewHolder create(@NonNull final ViewGroup viewGroup,
                                            @NonNull final OnRepoLongClickListener onRepoLongClickListener) {
        return new RepoListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_layout,
                viewGroup, false), onRepoLongClickListener);
    }

    @Bind(R.id.list_item_repo_layout)
    ViewGroup itemLayout;

    @Bind(R.id.list_item_repo_name_textview)
    TextView repoName;

    @Bind(R.id.list_item_repo_owner_textview)
    TextView repoOwner;

    @Bind(R.id.list_item_description_textview)
    TextView repoDescription;

    private RepoListViewHolder(final View itemView, final OnRepoLongClickListener onRepoLongClickListener) {
        super(itemView);

        // init butterknife
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Toast.makeText(itemView.getContext(), "Please long press", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {
                onRepoLongClickListener.onRepoLongClicked(getAdapterPosition(), itemView);
                return true;
            }
        });
    }

    public void bind(@NonNull final RepoUIModel repoUIModel) {
        itemLayout.setBackgroundColor(ContextCompat.getColor(itemView.getContext(), repoUIModel.cellColor));
        repoName.setText(repoUIModel.repoName);
        repoOwner.setText(repoUIModel.owner);
        repoDescription.setText(repoUIModel.description);
    }
}
