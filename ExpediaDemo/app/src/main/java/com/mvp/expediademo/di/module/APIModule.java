package com.mvp.expediademo.di.module;

import com.mvp.expediademo.constants.APIConstants;
import com.mvp.expediademo.di.scope.ApplicationScope;
import com.mvp.expediademo.http.thingstodo.SearchAPIService;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class APIModule {

    @Provides
    @ApplicationScope
    public OkHttpClient providesClient(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .build();

        return okHttpClient;
    }

    @Provides
    @ApplicationScope
    public Retrofit provideRetrofit(OkHttpClient client,String baseUrl){
        return  new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .client(client)
                .build();

    }

    @Provides
    @ApplicationScope
    public SearchAPIService getMovieService(){
        return provideRetrofit(providesClient(), APIConstants.SEARCH_BASE_URL).create(SearchAPIService.class);
    }


}
