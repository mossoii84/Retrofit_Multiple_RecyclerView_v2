package com.example.retrofit_multiple_recyclerview_v2;


import com.example.retrofit_multiple_recyclerview_v2.Model.News;
import com.example.retrofit_multiple_recyclerview_v2.Model.Pub;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonUrlPost {

    @GET("news")
    Call<List<News>> getNews();

    @GET("advertisment")
    Call<List<Pub>> getPub();



}
