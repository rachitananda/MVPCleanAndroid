package com.mvp.daggermvpdemo.ui.movie;

import android.util.Log;

import com.mvp.daggermvpdemo.http.MovieAPIService;
import com.mvp.daggermvpdemo.http.model.Result;
import com.mvp.daggermvpdemo.http.model.TopRated;
import com.mvp.daggermvpdemo.ui.login.LoginMVP;

import java.util.List;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviePresenter implements MovieMVP.Presenter {
    private MovieMVP.View view;
    Disposable disposable;
    private List<Result> results;

    @Override
    public void onMovieSelected() {

    }

    @Override
    public void setView(MovieMVP.View view) {
        this.view = view;

    }

    @Override
    public void getLoadFromAPI(MovieAPIService movieApiService) {

        DisposableObserver<TopRated> subscription = new DisposableObserver<TopRated>() {
            @Override
            public void onNext(TopRated topRated) {
                results.add(topRated.results.get(0));
                Log.d("retrofit", "ONNExt: " + results.size());
            }

            @Override
            public void onError(Throwable e) {
                Log.d("retrofit", "error: ");
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                Log.d("retrofit", "onComplete: ");
            }
        };

        Observable<TopRated> topRatedObservable;
        topRatedObservable = movieApiService.getTopRatedMovies(1);

        topRatedObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscription);


    }

    private void loadDataByRetrofit(MovieAPIService movieApiService) {

        /*Call<TopRated> call = movieApiService.getTopRatedMovies(1);
        call.enqueue(new Callback<TopRated>() {
                         @Override
                         public void onResponse(Call<TopRated> call, Response<TopRated> response) {

                         }

                         @Override
                         public void onFailure(Call<TopRated> call, Throwable t) {

                         }
                     }
        );*/

    }

    @Override
    public void rxUnbind() {
        if (disposable != null)
            disposable.dispose();
    }

    @Override
    public void onAttachView() {
    }

    @Override
    public void onDetachView() {

    }

    @Override
    public void onClick() {
        view.showMessage("Movie presenter");
    }
}
