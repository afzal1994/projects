package com.example.practise.base;

import com.example.practise.models.UserEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/photos")
    Call<List<UserEntity>> getMoviesList();
}