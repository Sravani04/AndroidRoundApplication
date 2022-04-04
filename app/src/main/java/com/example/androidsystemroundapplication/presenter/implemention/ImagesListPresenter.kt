package com.example.androidsystemroundapplication.presenter.implemention

import android.util.Log
import com.example.androidsystemroundapplication.helpers.ApiClient
import com.example.androidsystemroundapplication.network.ApiInterface
import com.example.androidsystemroundapplication.Model.response.ImagesList
import com.example.androidsystemroundapplication.presenter.interfaces.IImagesList
import com.example.androidsystemroundapplication.presenter.interfaces.ImagesMainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class ImagesListPresenter(var imagesMainView: ImagesMainView):IImagesList {
    var apiInterface: ApiInterface = ApiClient().getClient()!!.create(ApiInterface::class.java)
    override fun getImagesList() {
        val call: Call<ArrayList<ImagesList?>?>? = apiInterface.getImagesList()
        call?.enqueue(object : Callback<ArrayList<ImagesList?>?> {
            override fun onResponse(
                call: Call<ArrayList<ImagesList?>?>,
                response: Response<ArrayList<ImagesList?>?>
            ) {
                Log.e("llll", apiInterface.getImagesList().toString())
                if (response.isSuccessful) {

                    try {
                        imagesMainView.getImagesList(response.body())
                        Log.e("TAG", "Employees list response: " + response.body())
                    }catch (e: Exception){
                        e.printStackTrace()
                    }

                }
            }

            override fun onFailure(call: Call<ArrayList<ImagesList?>?>, t: Throwable) {

            }

        })
    }
}