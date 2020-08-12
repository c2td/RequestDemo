package com.pm.requestdemo.api

import com.google.gson.annotations.SerializedName
import com.pm.requestdemo.Employee

class EmployeeResponse {

    @SerializedName("status")
    private val status: String? = null

    @SerializedName("data")
    lateinit var employees: List<Employee>
}