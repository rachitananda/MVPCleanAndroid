package com.mvp.daggermvpdemo.http;


import com.mvp.daggermvpdemo.http.model.TopRated;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieAPIService {


//    @GET("top_rated")
//    Observable<TopRated> getTopRatedMovies(@Query("page") Integer page);

    @GET("top_rated")
    Call<TopRated> getTopRatedMovies(@Query("page") Integer page);
}
