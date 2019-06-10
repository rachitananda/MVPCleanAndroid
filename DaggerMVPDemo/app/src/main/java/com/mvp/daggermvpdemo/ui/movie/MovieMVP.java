package com.mvp.daggermvpdemo.ui.movie;

import com.mvp.daggermvpdemo.http.MovieAPIService;
import com.mvp.daggermvpdemo.ui.base.BaseMvpPresenter;
import com.mvp.daggermvpdemo.ui.base.BaseMvpView;

import io.reactivex.Observable;

public interface MovieMVP {


    interface  Presenter extends BaseMvpPresenter{

          void onMovieSelected();
          void setView(MovieMVP.View view);
          void getLoadFromAPI(MovieAPIService movieAPIService);
          void rxUnbind();

    }

    interface View extends BaseMvpView{

        String getMovieName();

    }

    interface Model {
        Observable<ViewModel> result();
    }

}
