package com.pm.requestdemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pm.requestdemo.api.RequestApi
import com.pm.requestdemo.api.EmployeeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "Repository"

class Repository {

    private val requestApi: RequestApi
    private lateinit var request: Call<EmployeeResponse>

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            //.baseUrl("https://navneet7k.github.io/")
            .baseUrl("http://dummy.restapiexample.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        requestApi = retrofit.create(RequestApi::class.java)
    }

    fun fetchContents(): LiveData<List<Employee>> {

        val responseLiveData: MutableLiveData<List<Employee>> = MutableLiveData()
        val request: Call<EmployeeResponse> = requestApi.fetchData()

        request.enqueue(object : Callback<EmployeeResponse> {

            override fun onFailure(call: Call<EmployeeResponse>, t: Throwable) {
                Log.e(TAG, "Failed to fetch data", t)
            }

            override fun onResponse(
                call: Call<EmployeeResponse>,
                response: Response<EmployeeResponse>
            ) {
                Log.d(TAG, "Response received")
                val requestResponse: EmployeeResponse? = response.body()
                val employees: List<Employee> = requestResponse?.employees ?: mutableListOf()
                responseLiveData.value = employees
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