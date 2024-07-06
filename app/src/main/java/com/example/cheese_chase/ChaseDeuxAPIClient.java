package com.example.cheese_chase;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChaseDeuxAPIClient {
    private static ApiService api;

    public static ApiService getClient() {
        if (api == null) {
            api = new Retrofit.Builder()
                    .baseUrl("https://chasedeux.vercel.app/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService.class);
        }
        return api;
    }
}
