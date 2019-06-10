package com.mvp.daggermvpdemo.di.component;

import com.mvp.daggermvpdemo.di.module.MovieModule;
import com.mvp.daggermvpdemo.di.scope.ActivityScope;
import com.mvp.daggermvpdemo.di.scope.MovieScope;
import com.mvp.daggermvpdemo.ui.movie.MovieActivity;

import dagger.Component;
import dagger.Module;
import dagger.Subcomponent;

@MovieScope
//@Component(dependencies = ApplicationComponent.class , modules = MovieModule.class)
@Subcomponent(modules = MovieModule.class)
public interface MovieComponent {

    void inject(MovieActivity activity);

}
