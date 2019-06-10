package com.mvp.expediademo;

import android.app.Application;

import com.mvp.expediademo.di.component.ApplicationComponent;
import com.mvp.expediademo.di.component.DaggerApplicationComponent;
import com.mvp.expediademo.di.component.LoginComponent;
import com.mvp.expediademo.di.component.ThingsToDoComponent;
import com.mvp.expediademo.di.module.ApplicationModule;
import com.mvp.expediademo.di.module.LoginModule;
import com.mvp.expediademo.di.module.SharedPrefModule;
import com.mvp.expediademo.di.module.ThingsToDoModule;

public class BaseApplication extends Application {

    ApplicationComponent applicationComponent;
    ThingsToDoComponent thingsToDoComponent;
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

    public ThingsToDoComponent createThingsToDoComponent(){
        thingsToDoComponent = applicationComponent.plus(new ThingsToDoModule());
        return thingsToDoComponent;
    }

    public void releaseMovieComponent(){
        thingsToDoComponent =null;
    }
}
