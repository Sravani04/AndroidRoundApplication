package com.example.androidsystemroundapplication.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidsystemroundapplication.Model.response.ComparisonImageList
import com.example.androidsystemroundapplication.R
import com.squareup.picasso.Picasso

class ComparisonTableAdapter(
    val context: Context,
    private val imagesList: ArrayList<ComparisonImageList>?
) :
    RecyclerView.Adapter<ComparisonTableAdapter.MyViewHolder?>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnLongClickListener, View.OnClickListener {
        var image: ImageView?=null
        var photoId: TextView?=null
        var photoUrl: TextView?=null
        var photoTitle: TextView?=null


        override fun onClick(view: View) {

        }

        init {
            image = view.findViewById(R.id.photo)
            photoTitle = view.findViewById(R.id.photo_title)
            photoId = view.findViewById(R.id.photo_id)
            photoUrl = view.findViewById(R.id.photo_url)
            view.setOnClickListener(this)
        }

        override fun onLongClick(p0: View?): Boolean {
            TODO("Not yet implemented")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.comparison_table_layout_items, parent, false)

        return MyViewHolder(itemView)
    }

    @SuppressLint("RestrictedApi")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        try {

            val imagesListResponse = imagesList?.get(position)
            Picasso.get().load(imagesListResponse?.url).into(holder.image)
            holder.photoTitle?.text = "Title:" + imagesListResponse?.title
            holder.photoId?.text = "ID:" + imagesListResponse?.id.toString()
            holder.photoUrl?.text = "URL:" + imagesListResponse?.url.toString()

        }catch (e:Exception){
            e.printStackTrace()
        }

    }




    override fun getItemCount(): Int {
        return imagesList?.size!!
    }




}