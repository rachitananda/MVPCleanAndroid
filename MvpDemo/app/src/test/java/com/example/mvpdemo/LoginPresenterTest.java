package com.example.mvpdemo;

import com.example.mvpdemo.login.LoginMVP;
import com.example.mvpdemo.login.LoginPresenter;
import com.example.mvpdemo.login.User;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class LoginPresenterTest {

    LoginMVP.Model mockModel;
    LoginMVP.View mockView;
    LoginMVP.Presenter presenter;
    User user;



    //this before method runs each time before running an individual test case
    @Before
    public void init(){

        mockModel= mock(LoginMVP.Model.class);
        mockView= mock(LoginMVP.View.class);
        user = new User("Test","user");
        presenter = new LoginPresenter(mockModel);
        presenter.setView(mockView);

    }


    @Test
    public void shouldShowErrorWhenLastNameFieldIsEmpty(){


        // Now tell mockView to return a value for first name and an empty last name
        when(mockView.getFirstName()).thenReturn("Dana");
        when(mockView.getLastName()).thenReturn("");

        presenter.doLogin();

        //verify for dologin()
        verify(mockView, times(1)).getFirstName(); // Called two times now, once before, and once now
        verify(mockView, times(1)).getLastName();  // Only called once
        verify(mockView, times(1)).showInvalidInputError(); // Called two times now, once before and once now
        verify(mockView,never()).showUserSaved();
    }


    @Test
    public void showErrorWhenFirstNameFiledIsEmpty(){

        when(mockView.getFirstName()).thenReturn("");

        presenter.doLogin();

        verify(mockView,times(1)).getFirstName();
        verify(mockView,never()).getLastName();
        verify(mockView,times(1)).showInvalidInputError();
        verify(mockView,never()).showUserSaved();

    }



}
