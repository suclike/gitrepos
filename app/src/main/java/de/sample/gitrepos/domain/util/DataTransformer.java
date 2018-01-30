package de.sample.gitrepos.domain.util;

import android.support.annotation.NonNull;

interface DataTransformer<From, To> {

    @NonNull
    To transform(@NonNull From from);
}
