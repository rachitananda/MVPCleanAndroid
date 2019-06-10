package com.mvp.expediademo.di.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.mvp.expediademo.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPrefModule {

        private Context context;

        public SharedPrefModule(Context context) {
            this.context = context;
        }

        @Provides
        @ApplicationScope
        SharedPreferences provideSharedPreferences() {
            return context.getSharedPreferences("PrefName",Context.MODE_PRIVATE);
        }

}
