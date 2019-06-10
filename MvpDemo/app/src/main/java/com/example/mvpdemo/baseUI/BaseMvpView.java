package com.example.mvpdemo.baseUI;



import butterknife.Unbinder;

public interface BaseMvpView {

    void setUnbinder(Unbinder unbinder);
    //show stop progress
    //on attach on detach
     void showToast(String msg);
//     ActivityComponent getActivityComponent();
}
