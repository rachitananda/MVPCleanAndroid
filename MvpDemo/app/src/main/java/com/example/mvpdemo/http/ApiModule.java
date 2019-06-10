package com.example.mvpdemo.http;


import com.example.mvpdemo.http.model.TopRated;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    public final String BASE_URL = "http://api.themoviedb.org/3/movie/";
    public final String API_PARAM = "api";
    public final String API_KEY = "8551c026bbf22a4a386ebb5b87a5296b";


    @Provides
    public OkHttpClient providesClient() {
        //used when logging needed or need to add a static query param to api request
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        //to add Query param to each api call
                        Request request= chain.request();
                        HttpUrl url = request.url().newBuilder()
                                .addQueryParameter(API_PARAM,API_KEY)
                                .build();

                        request= request.newBuilder().url(url).build();
                        return chain.proceed(request);
                    }
                })
                .build();

        return okHttpClient;

    }


    @Provides
    public Retrofit provideRetrofit(OkHttpClient client,String baseUrl){

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }


    @Provides
    public MovieAPIService provideTopMovieAPIService(){

        return  provideRetrofit(providesClient(),BASE_URL).create(MovieAPIService.class);

    }



}
