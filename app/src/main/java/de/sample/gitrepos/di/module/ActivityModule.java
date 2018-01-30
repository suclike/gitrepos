package de.sample.gitrepos.di.module;

import javax.inject.Singleton;

import android.app.Activity;
import android.app.Application;

import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;

import de.sample.gitrepos.di.qualifier.ActivityInstanceScope;

import rx.subscriptions.CompositeSubscription;

@Module
public class ActivityModule {

    public static final String SHARED_PREFERENCE_FILE_NAME = "com.magz.adzukimobile.rebuild.shared_preference";

    private final Activity activity;

    public ActivityModule(final Activity activity) {
        this.activity = activity;
    }

    @Provides
    @Singleton
    Activity provideActivity() {
        return activity;
    }

    @Provides
    @ActivityInstanceScope
    CompositeSubscription provideCompositeSubscription() {
        return new CompositeSubscription();
    }

    @Provides
    @ActivityInstanceScope
    SharedPreferences provideSharedPreferences(final Application app) {
        return app.getSharedPreferences(SHARED_PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
    }
}
