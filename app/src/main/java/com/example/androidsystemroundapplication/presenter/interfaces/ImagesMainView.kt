package com.example.androidsystemroundapplication.presenter.interfaces

import com.example.androidsystemroundapplication.Model.response.ImagesList

interface ImagesMainView {
    fun getImagesList(imagesList: ArrayList<ImagesList?>?)
}