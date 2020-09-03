package com.pm.requestdemo.api

import com.google.gson.annotations.SerializedName
import com.pm.requestdemo.data.Movie

class MovieResponse {

    @SerializedName("results")
    lateinit var movies: List<Movie>
}