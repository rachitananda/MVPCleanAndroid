package com.mvp.expediademo.di.module;

import com.mvp.expediademo.di.scope.ThingsToDoScope;
import com.mvp.expediademo.ui.thingstodo.ThingsToDoMVP;
import com.mvp.expediademo.ui.thingstodo.ThingsToDoPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ThingsToDoModule {

    @Provides
    @ThingsToDoScope
    public ThingsToDoMVP.Presenter providesMoviePresenter(){
        return  new ThingsToDoPresenter();
    }


}
