package de.sample.gitrepos.di;

import javax.inject.Singleton;

import dagger.Component;

import de.sample.gitrepos.BaseApplication;
import de.sample.gitrepos.di.module.ActivityModule;
import de.sample.gitrepos.di.module.ApplicationModule;
import de.sample.gitrepos.di.module.NetworkModule;
import de.sample.gitrepos.di.qualifier.AppScope;

@Singleton
@AppScope
@Component(
    modules = {
        ApplicationModule.class, //
        NetworkModule.class
    }
)
public interface ApplicationComponent {

    ActivityComponent plus(ActivityModule activityModule);

    void injectApplication(BaseApplication application);
}
