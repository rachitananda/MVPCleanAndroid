package com.mvp.daggermvpdemo;

import android.app.Application;

import com.mvp.daggermvpdemo.di.component.ApplicationComponent;
import com.mvp.daggermvpdemo.di.component.DaggerApplicationComponent;
import com.mvp.daggermvpdemo.di.component.LoginComponent;
import com.mvp.daggermvpdemo.di.component.MovieComponent;
import com.mvp.daggermvpdemo.di.module.ApplicationModule;
import com.mvp.daggermvpdemo.di.module.LoginModule;
import com.mvp.daggermvpdemo.di.module.MovieModule;
import com.mvp.daggermvpdemo.di.module.SharedPrefModule;

public class App extends Application {

    ApplicationComponent applicationComponent;
    MovieComponent movieComponent;
    LoginComponent loginComponent;

    @Override
    public void onCreate() {
        super.onCreate();

       applicationComponent = DaggerApplicationComponent.builder()
               .applicationModule(new ApplicationModule(this))
               .sharedPrefModule(new SharedPrefModule(this))
               .build();

    }
    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public LoginComponent createLoginComponent(){
        loginComponent= applicationComponent.plus(new LoginModule());
        return loginComponent;
    }

    public void releaseLoginComponent(){
        loginComponent =null;
    }

    public MovieComponent createMovieComponent(){
        movieComponent= applicationComponent.plus(new MovieModule());
        return movieComponent;
    }

    public void releaseMovieComponent(){
        movieComponent =null;
    }

}
