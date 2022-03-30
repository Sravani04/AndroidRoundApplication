package com.example.androidsystemroundapplication

import com.example.androidsystemroundapplication.Model.response.EmployeesDataArray
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

 interface ApiInterface {
//    var BASE_URL: String
//        get() = "http://203.112.132.70:8013/api/"
//        set(value) = TODO()
    @GET("AndroidSystemTest/GetEmployeeData")
    fun getEmployeesList(): Call<ArrayList<EmployeesDataArray?>?>?

}