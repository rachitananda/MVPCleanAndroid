package com.mvp.expediademo.http.thingstodo;


import com.mvp.expediademo.constants.APIConstants;
import com.mvp.expediademo.http.thingstodo.model.SearchResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface SearchAPIService {


    @Headers("User-Agent: expedia")
    @GET("search")
    Observable<SearchResult> getSearchResults(@Query(APIConstants.SEARCH_KEY_LOCATION) String mockLocation,
                                              @Query(APIConstants.SEARCH_MOCK_START_DATE) String startDate
