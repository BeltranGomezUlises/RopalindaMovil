package com.ropalinda.ropalindamovil.Utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class SingletonRetrofit {
    private static Retrofit instance;

    private SingletonRetrofit() {
    }

    public static Retrofit getInstance() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl("http://74.208.178.83:8080/Ropalinda/api/")
                    .client(new OkHttpClient().newBuilder()
                            .connectTimeout(15, TimeUnit.SECONDS)
                            .writeTimeout(15, TimeUnit.SECONDS)
                            .readTimeout(15, TimeUnit.SECONDS)
                            .build()
                    )
                    .addConverterFactory(JacksonConverterFactory.create()).build();
        }


        return instance;
    }

    public static RetrofitInterface WSClient() {
        return getInstance().create(RetrofitInterface.class);
    }

}
