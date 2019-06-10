package com.mvp.daggermvpdemo.di.module;

import com.mvp.daggermvpdemo.di.scope.ApplicationScope;
import com.mvp.daggermvpdemo.http.MovieAPIService;

import java.io.IOException;

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
public class APIModule {

    public final String BASE_URL = "http://api.themoviedb.org/3/movie/";
    public final String API_PARAM = "api";
    public final String API_KEY = "8551c026bbf22a4a386ebb5b87a5296b";


    @Provides
    @ApplicationScope
    public OkHttpClient providesClient(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                                    .addInterceptor(new Interceptor() {
                                        @Override
                                        public Response intercept(Chain chain) throws IOException {
                                            Request request = chain.request();
                                            HttpUrl url= request.url().newBuilder()
                                                    .addQueryParameter(API_PARAM,API_KEY)
                                                    .build();
                                            request = request.newBuilder().url(url).build();
                                            return chain.proceed(request);
                                        }
                                    }).build();

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
    public MovieAPIService getMovieService(){
        return provideRetrofit(providesClient(),BASE_URL).create(MovieAPIService.class);
    }


}
