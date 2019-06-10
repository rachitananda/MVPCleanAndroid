package com.mvp.daggermvpdemo.di.component;


import android.app.Application;
import android.util.Log;

import com.mvp.daggermvpdemo.App;
import com.mvp.daggermvpdemo.di.module.APIModule;
import com.mvp.daggermvpdemo.di.module.ApplicationModule;
import com.mvp.daggermvpdemo.di.module.LoginModule;
import com.mvp.daggermvpdemo.di.module.MovieModule;
import com.mvp.daggermvpdemo.di.module.SharedPrefModule;
import com.mvp.daggermvpdemo.di.scope.ApplicationScope;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@ApplicationScope
@Component(modules = {ApplicationModule.class, SharedPrefModule.class,APIModule.class})
public interface ApplicationComponent {

    void inject(App app);

    Application getApplication();

    LoginComponent plus(LoginModule loginModule);

    MovieComponent plus(MovieModule movieModule);

}
//https://medium.com/@kashwin95kumar/custom-scoping-in-dagger-2-for-android-9cf6030c2f8a