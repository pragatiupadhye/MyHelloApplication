package com.example.myhelloapplication.Retrofit;


import com.example.myhelloapplication.Model.LaunchDetail;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {
    //curl --location 'https://api.spacexdata.com/v3/launches'
    @GET("launches")
    Call<ArrayList<LaunchDetail>> getAllLaunches();
}
