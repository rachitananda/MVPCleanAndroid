package com.mvp.expediademo.ui.login;


public class LoginPresenter implements LoginMVP.Presenter {

    private LoginMVP.View view;

    @Override
    public void onAttachView() {
    }

    @Override
    public void onDetachView() {
        view=null;

    }

    @Override
    public void onClick() {
        view.navigateToNextActivity();
        view.showMessage("presenter");
    }


    @Override
    public void validateInput() {
        //validate name
    }

    @Override
    public void setView(LoginMVP.View view) {
     this.view=view;
    }
}
