package com.mvp.daggermvpdemo.ui.login;


import com.mvp.daggermvpdemo.di.component.LoginComponent;
import com.mvp.daggermvpdemo.ui.base.BaseMvpPresenter;
import com.mvp.daggermvpdemo.ui.base.BaseMvpView;

public interface LoginMVP {


    interface  Presenter extends BaseMvpPresenter{

        //extra methods apart from base presenter methods
        void validateInput();
        void setView(LoginMVP.View view);

    }


    interface  View extends BaseMvpView{

        //extra login methods apart from base presenter methods
        void navigateToNextActivity();
        String getFirstName();
        String getLastName();

    }

   // interface  Mode
}
