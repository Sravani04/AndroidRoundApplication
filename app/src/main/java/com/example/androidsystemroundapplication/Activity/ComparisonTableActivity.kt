package com.example.androidsystemroundapplication.Activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidsystemroundapplication.Adapter.ComparisonTableAdapter
import com.example.androidsystemroundapplication.Model.response.ComparisonImageList
import com.example.androidsystemroundapplication.Model.response.ImagesList
import com.example.androidsystemroundapplication.R


class ComparisonTableActivity: AppCompatActivity() {
    var recyclerview:RecyclerView?=null
    var imageList:ImagesList?=null
    var compareImagesList:ArrayList<ComparisonImageList>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("imageslist", "mainactivity is called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.comparison_table_layout)
        recyclerview = findViewById(R.id.comparison_recyclerview)
        val loadInfo = intent.extras
        imageList = loadInfo!!.getSerializable("imagelistpostion") as ImagesList?

        //compareImagesList?.add(value)
        compareImagesList = ArrayList<ComparisonImageList>()
        compareImagesList?.add(
                ComparisonImageList(
                    imageList?.id,
                    imageList?.title,
                    imageList?.url
                )
            )


        var `val` = 0
        while (compareImagesList!!.size > `val`) {
                Log.e("image", compareImagesList!!.get(`val`).toString())
            System.out.println(compareImagesList!!.get(`val`))
            `val`++
        }




        recyclerview?.layoutManager = LinearLayoutManager(this)
        val comparisonTableAdapter = ComparisonTableAdapter(this,compareImagesList)
        recyclerview?.adapter = comparisonTableAdapter
    }



}