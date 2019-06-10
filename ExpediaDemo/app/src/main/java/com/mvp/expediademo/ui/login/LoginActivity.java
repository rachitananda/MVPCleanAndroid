package com.mvp.expediademo.ui.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.mvp.expediademo.BaseApplication;
import com.mvp.expediademo.R;
import com.mvp.expediademo.ui.base.BaseActivity;
import com.mvp.expediademo.ui.thingstodo.ThingsToDoActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements  LoginMVP.View{

    @Inject
    LoginMVP.Presenter presenter;

    @Inject
    SharedPreferences sharedPreferences;

    @BindView(R.id.next_btn)
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((BaseApplication)getApplication()).createLoginComponent().inject(this);

        setUnbinder(ButterKnife.bind(this));

        presenter.setView(this);//onresume

        Log.d("dagger", "onCreate: presenter"+presenter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((BaseApplication)getApplication()).releaseLoginComponent();//release sub module
    }

    @OnClick(R.id.next_btn)
    public void navigateToNextScreen(){
      presenter.onClick();
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void stopProgress() {

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void navigateToNextActivity() {
        startActivity(new Intent(this, ThingsToDoActivity.class));
    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }
}
