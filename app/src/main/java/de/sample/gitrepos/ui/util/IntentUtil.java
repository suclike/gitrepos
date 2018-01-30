package de.sample.gitrepos.ui.util;

import android.content.Intent;

import android.net.Uri;

import android.support.annotation.NonNull;

public final class IntentUtil {

    public static Intent browserIntent(@NonNull final String url) {
        return new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url));
    }

    public static boolean canHandleUrl(final String url) {
        return !url.isEmpty() && url.startsWith("http://") || url.startsWith("https://");
    }
}
