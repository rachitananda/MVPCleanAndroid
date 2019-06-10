package com.mvp.daggermvpdemo.di.component;

import android.support.v4.database.DatabaseUtilsCompat;

import com.mvp.daggermvpdemo.di.module.LoginModule;
import com.mvp.daggermvpdemo.di.scope.ActivityScope;
import com.mvp.daggermvpdemo.di.scope.LoginScope;
import com.mvp.daggermvpdemo.ui.login.LoginActivity;
import com.mvp.daggermvpdemo.ui.login.LoginMVP;

import dagger.Component;
import dagger.Subcomponent;

@LoginScope
@Subcomponent(modules = LoginModule.class)
//@Component(dependencies = ApplicationComponent.class,modules = LoginModule.class)
public interface LoginComponent {

    void inject(LoginActivity loginActivity);

    LoginMVP.Presenter getPresenter();
}
