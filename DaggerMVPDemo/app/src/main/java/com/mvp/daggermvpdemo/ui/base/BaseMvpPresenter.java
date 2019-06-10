package com.mvp.daggermvpdemo.ui.base;

import android.view.View;

public interface BaseMvpPresenter {


    void onAttachView();

    void onDetachView();

    void onClick();

}
