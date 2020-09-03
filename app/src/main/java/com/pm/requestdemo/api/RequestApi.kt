package com.pm.requestdemo.api

import retrofit2.Call
import retrofit2.http.GET

interface RequestApi {

    @GET("movie?api_key=5680c63c995f784e60bf474f1aec61c0") //TODO improve
    fun fetchData(): Call<MovieResponse>;

}