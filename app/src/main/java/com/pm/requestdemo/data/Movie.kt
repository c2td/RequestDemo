package com.pm.requestdemo.data

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("poster_path")
    val posterUrl: String = "",

    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String = "",

    @SerializedName("overview")
    val description: String = ""
)

