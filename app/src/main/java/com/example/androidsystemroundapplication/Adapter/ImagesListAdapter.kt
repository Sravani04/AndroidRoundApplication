package com.example.androidsystemroundapplication.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidsystemroundapplication.Activity.ComparisonTableActivity
import com.example.androidsystemroundapplication.Model.response.ComparisonImageList
import com.example.androidsystemroundapplication.Model.response.ImagesList
import com.example.androidsystemroundapplication.R
import com.squareup.picasso.Picasso


class ImagesListAdapter(
    val context: Context,
    private val imagesList: ArrayList<ImagesList?>?
) :
    RecyclerView.Adapter<ImagesListAdapter.MyViewHolder?>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnLongClickListener, View.OnClickListener {
        var image:ImageView?=null
        var imageTitle:TextView?=null
        var imageId:TextView?=null
        var imageUrl:TextView?=null
        var compareBtn:TextView?=null


        override fun onClick(view: View) {

        }

        init {
            image = view.findViewById(R.id.image)
            imageTitle = view.findViewById(R.id.image_title)
            imageId = view.findViewById(R.id.image_id)
            imageUrl = view.findViewById(R.id.image_url)
            compareBtn = view.findViewById(R.id.compare_btn)
            view.setOnClickListener(this)
        }

        override fun onLongClick(p0: View?): Boolean {
            TODO("Not yet implemented")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.images_list_item, parent, false)

        return MyViewHolder(itemView)
    }

    @SuppressLint("RestrictedApi")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        try {

            val imagesListResponse = imagesList?.get(position)
            Picasso.get().load(imagesListResponse?.url).into(holder.image)
            holder.imageTitle?.text = "Title:" + imagesListResponse?.title
            holder.imageId?.text = "ID:" + imagesListResponse?.id.toString()
            holder.compareBtn?.setOnClickListener(View.OnClickListener {
                Log.e("imagelistadapter",
                    imagesList?.get(position).toString()
                )
                val intent = Intent(context,ComparisonTableActivity::class.java)
                val mBundle = Bundle()
                mBundle.putSerializable("imagelistpostion", imagesList?.get(position))
                intent.putExtras(mBundle)
                context.startActivity(intent)
                holder.compareBtn!!.text = context.getString(R.string.remove)
               //deleteItem(holder.itemView,position)
            })






        }catch (e:Exception){
            e.printStackTrace()
        }

    }

//    private fun deleteItem(rowView: View, position: Int) {
//        val anim: Animation = AnimationUtils.loadAnimation(
//            context,
//            android.R.anim.slide_out_right
//        )
//        anim.duration = 300
//        rowView.startAnimation(anim)
//        Handler().postDelayed(Runnable {
//            if (employeeList?.size === 0) {
//                return@Runnable
//            }
//            employeeList?.removeAt(position) //Remove the current content from the array
//            notifyDataSetChanged() //Refresh list
//        }, anim.duration)
//    }


    override fun getItemCount(): Int {
        return imagesList?.size!!
    }




}





