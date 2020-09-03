package com.pm.requestdemo.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pm.requestdemo.api.RequestApi
import com.pm.requestdemo.api.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "Repository"

class Repository {

    private val requestApi: RequestApi
    private lateinit var request: Call<MovieResponse>

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/discover/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        requestApi = retrofit.create(RequestApi::class.java)
    }

    fun fetchContents(): LiveData<List<Movie>> {

        val responseLiveData: MutableLiveData<List<Movie>> = MutableLiveData()
        val request: Call<MovieResponse> = requestApi.fetchData()

        request.enqueue(object : Callback<MovieResponse> {

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e(TAG, "Failed to fetch data", t)
            }

            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {
                Log.d(TAG, "Response received")
                val requestResponse: MovieResponse? = response.body()
                val movies: List<Movie> = requestResponse?.movies ?: mutableListOf()
                responseLiveData.value = movies
            }
        })
        return responseLiveData
    }

    fun cancelRequest() {
        if (::request.isInitialized) {
            request.cancel()
        }
    }
}