package de.sample.gitrepos.di;

import dagger.Subcomponent;

import de.sample.gitrepos.di.module.ActivityModule;
import de.sample.gitrepos.di.qualifier.ActivityInstanceScope;
import de.sample.gitrepos.ui.RepoListActivity;

@ActivityInstanceScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(RepoListActivity activity);
}
