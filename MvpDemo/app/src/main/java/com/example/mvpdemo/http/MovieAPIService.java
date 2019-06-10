package com.example.mvpdemo.http;

import com.example.mvpdemo.http.model.TopRated;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieAPIService {


    @GET("top_rated")
    public TopRated getTopRatedMovies(@Query("page") Integer page);

}
