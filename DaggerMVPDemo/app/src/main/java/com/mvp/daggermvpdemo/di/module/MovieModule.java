package com.mvp.daggermvpdemo.di.module;

import com.mvp.daggermvpdemo.di.scope.ActivityScope;
import com.mvp.daggermvpdemo.di.scope.MovieScope;
import com.mvp.daggermvpdemo.ui.movie.MovieMVP;
import com.mvp.daggermvpdemo.ui.movie.MoviePresenter;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

@Module
public class MovieModule {

//    MovieMVP.View view;
//
//    public MovieModule(MovieMVP.View view) {
//        this.view = view;
//    }
//    @Provides
//    @@MovieScope
//    public MovieMVP.View providesMovieView(){
//        return  view;
//    }


    @Provides
    @MovieScope
    public MovieMVP.Presenter providesMoviePresenter(){
        return  new MoviePresenter();
    }


}
