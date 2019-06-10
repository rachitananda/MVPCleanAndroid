package com.mvp.expediademo.di.component;


import com.mvp.expediademo.di.module.LoginModule;
import com.mvp.expediademo.di.scope.LoginScope;
import com.mvp.expediademo.ui.login.LoginActivity;

import dagger.Subcomponent;

@LoginScope
@Subcomponent(modules = LoginModule.class)
public interface LoginComponent {

    void inject(LoginActivity loginActivity);

}
