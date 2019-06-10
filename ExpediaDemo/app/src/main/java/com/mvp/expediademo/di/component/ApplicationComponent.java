package com.mvp.expediademo.di.component;


import android.app.Application;

import com.mvp.expediademo.BaseApplication;
import com.mvp.expediademo.di.module.APIModule;
import com.mvp.expediademo.di.module.ApplicationModule;
import com.mvp.expediademo.di.module.LoginModule;
import com.mvp.expediademo.di.module.SharedPrefModule;
import com.mvp.expediademo.di.module.ThingsToDoModule;
import com.mvp.expediademo.di.scope.ApplicationScope;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@ApplicationScope
@Component(modules = {ApplicationModule.class, SharedPrefModule.class, APIModule.class})
public interface ApplicationComponent {

    void inject(BaseApplication app);

    Application getApplication();

    LoginComponent plus(LoginModule loginModule);

    ThingsToDoComponent plus(ThingsToDoModule thingsToDoModule);

}
