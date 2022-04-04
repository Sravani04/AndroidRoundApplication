package com.example.androidsystemroundapplication.Model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ImagesList : Serializable {
    @SerializedName("albumId")
    var albumId:Int?=null
    @SerializedName("id")
    var id:Int?=null
    @SerializedName("title")
    var title:String?=null
    @SerializedName("url")
    var url:String?=null
    @SerializedName("thumbnailUrl")
    var thumbnailUrl:String?=null
}