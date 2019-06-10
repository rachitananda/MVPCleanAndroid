package com.mvp.expediademo.ui.thingstodo;

import com.mvp.expediademo.constants.APIConstants;
import com.mvp.expediademo.http.thingstodo.SearchAPIService;
import com.mvp.expediademo.http.thingstodo.model.SearchResult;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ThingsToDoPresenter implements ThingsToDoMVP.Presenter {
    private ThingsToDoMVP.View view;
    private DisposableObserver<SearchResult> subscription;

    @Override
    public void setView(ThingsToDoMVP.View view) {
        this.view = view;

    }

    @Override
    public void getLoadFromAPI(SearchAPIService movieApiService) {

        subscription = new DisposableObserver<SearchResult>() {
            @Override
            public void onNext(SearchResult result) {

                view.populateList(result.getActivities());
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
            }
        };

        Observable<SearchResult> searchResultObservable;
        searchResultObservable = movieApiService.getSearchResults(APIConstants.SEARCH_MOCK_LOCATION,
                APIConstants.SEARCH_MOCK_START_DATE);

        searchResultObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscription);

    }


    @Override
    public void rxUnbind() {
        if (subscription != null)
            subscription.dispose();
    }

    @Override
    public void onAttachView() {
    }

    @Override
    public void onDetachView() {

    }

    @Override
    public void onClick() {

    }
}
