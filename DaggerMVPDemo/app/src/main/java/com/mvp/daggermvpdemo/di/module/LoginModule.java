package com.mvp.daggermvpdemo.di.module;


import com.mvp.daggermvpdemo.di.scope.ActivityScope;
import com.mvp.daggermvpdemo.di.scope.LoginScope;
import com.mvp.daggermvpdemo.ui.login.LoginMVP;
import com.mvp.daggermvpdemo.ui.login.LoginPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

//    LoginMVP.View view;

//    public LoginModule(LoginMVP.View view) {
//        this.view = view;
//    }
//
//    @Provides
//    @ActivityScope
//    public LoginMVP.View providesView() {
//        return view;
//    }

//    @Provides
//    @ActivityScope
//    public LoginMVP.Presenter providesPresenter(LoginMVP.View  view) {//todo model
//        return new LoginPresenter(view);
//    }

    @Provides
    @LoginScope
    public LoginMVP.Presenter providesPresenter() {//todo model
        return new LoginPresenter();
    }

}
