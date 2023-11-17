package com.example.myhelloapplication.Retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    retrofit2.Retrofit retrofit;

    String base_url ="https://api.spacexdata.com/v3/";

    public Retrofit getInstance(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        retrofit=new retrofit2.Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        return  retrofit;
    }

}
