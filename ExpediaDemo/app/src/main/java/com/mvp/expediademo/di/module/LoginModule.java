package com.mvp.expediademo.di.module;


import com.mvp.expediademo.di.scope.LoginScope;
import com.mvp.expediademo.ui.login.LoginMVP;
import com.mvp.expediademo.ui.login.LoginPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {


    @Provides
    @LoginScope
    public LoginMVP.Presenter providesPresenter() {//todo model
        return new LoginPresenter();
    }

}
