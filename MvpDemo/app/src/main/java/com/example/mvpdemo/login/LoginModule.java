package com.example.mvpdemo.login;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

   private LoginMVP.Model model;

    public LoginModule() {
        model = new LoginModel();
    }

    @Provides
    @Singleton
    public LoginMVP.Presenter providesPresenter(){
        return new LoginPresenter(model);
    }

    @Provides
    @Singleton
    public LoginMVP.Model providesModel(){
        return model;
    }

}
