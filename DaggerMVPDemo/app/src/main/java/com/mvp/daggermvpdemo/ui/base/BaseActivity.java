package com.mvp.daggermvpdemo.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.Unbinder;

public abstract  class BaseActivity extends AppCompatActivity implements BaseMvpView {

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    protected void onDestroy() {
        if(unbinder!=null) {
            unbinder.unbind();
        }

        super.onDestroy();
    }

    @Override
    public void setUnbinder(Unbinder binder) {
        this.unbinder=unbinder;
    }
}
