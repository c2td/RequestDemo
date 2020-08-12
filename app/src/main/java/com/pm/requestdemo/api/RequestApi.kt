package com.pm.requestdemo.api

import retrofit2.Call
import retrofit2.http.GET

interface RequestApi {

    @GET("employees")
    fun fetchData(): Call<EmployeeResponse>
    //fun fetchData(): Call<RequestResponse>
}