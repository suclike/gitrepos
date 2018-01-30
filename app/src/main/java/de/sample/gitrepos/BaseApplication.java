package de.sample.gitrepos;

import android.app.Application;

import de.sample.gitrepos.di.ApplicationComponent;
import de.sample.gitrepos.di.DaggerApplicationComponent;
import de.sample.gitrepos.di.module.ApplicationModule;
import de.sample.gitrepos.di.module.NetworkModule;

public class BaseApplication extends Application {

    // Dagger injection
    public ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // Creating component
        applicationComponent = createComponent();

        // Injecting application itself
        applicationComponent.injectApplication(this);
    }

    // Building DaggerApplicationComponent generated within the Dagger2 lib.
    private ApplicationComponent createComponent() {
        return
            DaggerApplicationComponent.builder()                                      //
                                      .applicationModule(new ApplicationModule(this)) //
                                      .networkModule(new NetworkModule())             //
                                      .build();
    }
}
