package com.example.androidsystemroundapplication.Activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidsystemroundapplication.Adapter.ImagesListAdapter
import com.example.androidsystemroundapplication.Model.response.ImagesList
import com.example.androidsystemroundapplication.R
import com.example.androidsystemroundapplication.presenter.implemention.ImagesListPresenter
import com.example.androidsystemroundapplication.presenter.interfaces.ImagesMainView

class MainActivity : AppCompatActivity(),ImagesMainView {
    var recyclerview:RecyclerView?=null
    var imagesList: ArrayList<ImagesList>?=null
    var imagesListPresenter:ImagesListPresenter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("imageslist","mainactivity is called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview = findViewById(R.id.images_list)
        imagesListPresenter = ImagesListPresenter(this)
        imagesListPresenter!!.getImagesList()


    }


    override fun getImagesList(imagesList: ArrayList<ImagesList?>?) {
        Log.e("imageslist",imagesList.toString())
        recyclerview?.layoutManager = GridLayoutManager(this, 3)
        val imagesListAdapter = ImagesListAdapter(this,imagesList)
        recyclerview?.adapter = imagesListAdapter
    }

}
