package com.example.mvpdemo.login;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpdemo.baseUI.BaseActivity;
import com.example.mvpdemo.movie.MovieActivity;
import com.example.mvpdemo.R;
import com.example.mvpdemo.root.App;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements LoginMVP.View {

    @BindView(R.id.first_name_tv)
    EditText firstNameTextView;

    @BindView(R.id.last_name_tv)
    EditText lastNameTextView;

    @BindView(R.id.name_tv)
    TextView nameTv;

    @Inject
    Application application;

    @Inject
    LoginMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        ((App)getApplication()).getComponent().inject(this);

//        getActivityComponent().inject(this);
        Log.d("dagger", "onCreate: ");
    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);

    }

    @OnClick(R.id.login_button)
    public void onClick(){
        //todo
        presenter.doLogin();
    }

    @Override
    public void showInvalidInputError() {
        Toast.makeText(application,"Invalid Input",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserSaved() {
        Toast.makeText(application,"User saved",Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getFirstName() {
        return firstNameTextView.getText().toString();
    }

    @Override
    public String getLastName() {
        return lastNameTextView.getText().toString();
    }

    @Override
    public void showNameEntered(String name) {

        nameTv.setText(name);

    }

    @Override
    public void navigateToMovieActivity() {
        startActivity(new Intent(this, MovieActivity.class));
    }
}
