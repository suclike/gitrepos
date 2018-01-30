package de.sample.gitrepos.di.module;

import javax.inject.Singleton;

import android.app.Application;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

import de.sample.gitrepos.di.qualifier.AppScope;

@Module
public class ApplicationModule {

    private final Context context;

    public ApplicationModule(final Context context) {

        // keeps you from leaking
        this.context = context.getApplicationContext();
    }

    @Provides
    @AppScope
    @Singleton
    Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return ((Application) context.getApplicationContext());
    }
}
