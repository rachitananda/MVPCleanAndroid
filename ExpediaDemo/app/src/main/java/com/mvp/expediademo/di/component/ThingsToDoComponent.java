package com.mvp.expediademo.di.component;

import com.mvp.expediademo.di.module.ThingsToDoModule;
import com.mvp.expediademo.di.scope.ThingsToDoScope;
import com.mvp.expediademo.ui.thingstodo.ThingsToDoActivity;

import dagger.Subcomponent;

@ThingsToDoScope
@Subcomponent(modules = ThingsToDoModule.class)
public interface ThingsToDoComponent {

    void inject(ThingsToDoActivity activity);

}
