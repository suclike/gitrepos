package de.sample.gitrepos.ui;

import android.view.View;

/**
 * Listener interface to handle long click on list items, {@link View} is passed to attach
 * {@link android.support.v7.widget.PopupMenu} to a specific clicked item.
 */
public interface OnRepoLongClickListener {
    void onRepoLongClicked(int position, View itemView);
}
