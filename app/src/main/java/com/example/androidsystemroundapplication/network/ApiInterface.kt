package com.example.androidsystemroundapplication.network

import com.example.androidsystemroundapplication.Model.response.EmployeesDataArray
import com.example.androidsystemroundapplication.Model.response.ImagesList
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

 interface ApiInterface {
//    var BASE_URL: String
//        get() = "http://203.112.132.70:8013/api/"
//        set(value) = TODO()
    @GET("photos")
    fun getImagesList(): Call<ArrayList<ImagesList?>?>?

}