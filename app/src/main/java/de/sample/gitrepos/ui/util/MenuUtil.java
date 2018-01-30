package de.sample.gitrepos.ui.util;

import static android.view.Menu.NONE;

import java.util.List;

import android.support.annotation.NonNull;

import android.support.v7.widget.PopupMenu;

import android.view.View;

public final class MenuUtil {

    public static PopupMenu browserPopupMenu(@NonNull final View view, final List<String> menuItems) {
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view);

        for (int i = 0; i < menuItems.size(); i++) {
            if (!menuItems.get(i).isEmpty()) {
                popupMenu.getMenu().add(NONE, i, NONE, menuItems.get(i));
            }
        }

        return popupMenu;
    }
}
