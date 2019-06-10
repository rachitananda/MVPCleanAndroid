package com.mvp.expediademo.ui.base;


import butterknife.Unbinder;

public interface BaseMvpView {

       void showError(String message);
       void showProgress();
       void stopProgress();
       void showMessage(String message);
       void setUnbinder(Unbinder binder);

}