package com.pm.requestdemo

import com.google.gson.annotations.SerializedName

data class Employee(
    @SerializedName("employee_salary")
    val salary: String = "",

    @SerializedName("employee_age")
    val age: Int,

    @SerializedName("employee_name")
    val name: String = ""
)

