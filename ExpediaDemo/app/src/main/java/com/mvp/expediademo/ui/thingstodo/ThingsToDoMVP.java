package com.mvp.expediademo.ui.thingstodo;


import com.mvp.expediademo.http.thingstodo.SearchAPIService;
import com.mvp.expediademo.http.thingstodo.model.ThingItem;
import com.mvp.expediademo.ui.base.BaseMvpPresenter;
import com.mvp.expediademo.ui.base.BaseMvpView;

import java.util.List;

import io.reactivex.Observable;

public interface ThingsToDoMVP {


    interface  Presenter extends BaseMvpPresenter {

          void setView(ThingsToDoMVP.View view);
          void getLoadFromAPI(SearchAPIService searchAPIService);
          void rxUnbind();

    }

    interface View extends BaseMvpView {

       void populateList(List<ThingItem> things);

    }

    interface Model {
        Observable<ViewModel> result();
    }

}
