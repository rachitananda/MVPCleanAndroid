package com.example.mvpdemo.root;


import com.example.mvpdemo.login.LoginModule;
import com.example.mvpdemo.movie.MovieActivity;
import com.example.mvpdemo.http.ApiModule;
import com.example.mvpdemo.login.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class, LoginModule.class})
public interface ApplicationComponent {


    void inject(MainActivity activity);
    void inject (MovieActivity activity);
}
