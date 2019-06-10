package com.example.mvpdemo.root;

import android.app.Application;

import com.example.mvpdemo.http.ApiModule;
import com.example.mvpdemo.login.LoginModule;


public class App extends Application {


    private ApplicationComponent component;

    public ApplicationComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModule(new ApiModule())
                .loginModule(new LoginModule())
                .build();

    }
}
