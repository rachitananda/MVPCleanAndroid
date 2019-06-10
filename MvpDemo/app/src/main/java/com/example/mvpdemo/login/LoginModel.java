package com.example.mvpdemo.login;

public class LoginModel implements LoginMVP.Model {
    private User user;

    public LoginModel() {
        this.user = getUser();
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getUser() {
        if (user == null) {
            return new User("dummy", "user");
        } else {
            return user;
        }
    }
}
