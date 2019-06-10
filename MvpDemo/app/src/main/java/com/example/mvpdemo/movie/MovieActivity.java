package com.example.mvpdemo.movie;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.mvpdemo.R;
import com.example.mvpdemo.http.MovieAPIService;
import com.example.mvpdemo.root.App;

import javax.inject.Inject;

public class MovieActivity extends Activity {

    @Inject
    Application context;

    @Inject
    MovieAPIService movieAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        ((App) getApplication()).getComponent().inject(this);
        Log.d("dagger", "onCreate:movieAPIService " + movieAPIService);
    }
}
