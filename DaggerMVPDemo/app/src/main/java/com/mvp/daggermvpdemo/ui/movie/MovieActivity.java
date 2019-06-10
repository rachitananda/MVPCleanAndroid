package com.mvp.daggermvpdemo.ui.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.mvp.daggermvpdemo.App;
import com.mvp.daggermvpdemo.R;
import com.mvp.daggermvpdemo.http.MovieAPIService;
import com.mvp.daggermvpdemo.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MovieActivity extends BaseActivity implements MovieMVP.View {

    @Inject
    MovieMVP.Presenter presenter;

    @BindView(R.id.fetch_btn)
    Button fetchButton;

    @Inject
    MovieAPIService movieAPIService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_layout);

        setUnbinder(ButterKnife.bind(this));

        ((App) getApplication()).createMovieComponent().inject(this);
        presenter.setView(this);
        Log.d("dagger", "onCreate: MovieActivity presenter" + presenter);
        presenter.onClick();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((App) getApplication()).releaseMovieComponent();
        presenter.rxUnbind();
    }

    @OnClick(R.id.fetch_btn)
    public  void fetchFromAPI(){
        presenter.getLoadFromAPI(movieAPIService);
    }

    @Override
    public String getMovieName() {
        return null;
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

    }
}
