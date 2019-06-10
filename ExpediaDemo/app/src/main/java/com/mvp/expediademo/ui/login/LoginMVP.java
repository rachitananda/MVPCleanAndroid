package com.mvp.expediademo.ui.login;


import com.mvp.expediademo.ui.base.BaseMvpPresenter;
import com.mvp.expediademo.ui.base.BaseMvpView;

public interface LoginMVP {


    interface  Presenter extends BaseMvpPresenter {

        //extra methods apart from base presenter methods
        void validateInput();
        void setView(LoginMVP.View view);

    }


    interface  View extends BaseMvpView {

        //extra login methods apart from base presenter methods
        void navigateToNextActivity();
        String getFirstName();
        String getLastName();

    }

   // interface  Mode
}
