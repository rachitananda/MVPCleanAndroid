package com.example.mvpdemo.login;

import android.support.annotation.Nullable;


public class LoginPresenter implements LoginMVP.Presenter {


    LoginMVP.Model model;

    @Nullable
    LoginMVP.View view;

    public LoginPresenter(LoginMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(LoginMVP.View view) {
        this.view=view;

    }

    @Override
    public void doLogin() {

        if(view  !=null) {
            if (view.getFirstName().trim().equals("") || view.getLastName().trim().equals("")) {
                view.showInvalidInputError();
            } else {
                //api call
                saveUser(view.getFirstName(), view.getLastName());
                view.showUserSaved();
                view.showNameEntered(view.getFirstName()+" "+view.getLastName());
                view.navigateToMovieActivity();
            }

        }



    }

    @Override
    public void getUser() {
//       User user= model.getUser();
//        if (user != null) {
//            if (view != null) {
//                view.se(user.getFirstName());
//                view.setLastName(user.getLastName());
//            }
//        }else {
//            view.showUserNotAvailable();
//        }

    }

    @Override
    public void saveUser(String firstName, String lastName) {
        model.setUser(new User(firstName,lastName));
    }


}
