package com.example.mvpdemo.login;

public class LoginMVP {


    public interface View{
        void showInvalidInputError();
        void showUserSaved();
        String getFirstName();
        String getLastName();
        void showNameEntered(String name);
        void navigateToMovieActivity();
    }
   public interface Model{
        void setUser(User user);
        User getUser();
    }
    public interface  Presenter{
        void setView(LoginMVP.View view);
        void doLogin();
        void getUser();
        void saveUser(String firstName, String lastName);
    }

}
