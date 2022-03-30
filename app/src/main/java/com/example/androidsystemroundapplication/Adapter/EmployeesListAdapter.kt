package com.example.androidsystemroundapplication

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.AdapterViewFlipper
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidsystemroundapplication.Model.response.EmployeeList
import com.squareup.picasso.Picasso


class EmployeesListAdapter(
    val context: Context,
    private val employeeList: ArrayList<EmployeeList>?
) :
    RecyclerView.Adapter<EmployeesListAdapter.MyViewHolder?>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnLongClickListener, View.OnClickListener {
        var employeeImage:ImageView?=null
        var employeeName:TextView?=null
        var gridItem:RelativeLayout?=null
        var employeeId:TextView?=null

        override fun onClick(view: View) {

        }

        init {
            employeeImage = view.findViewById(R.id.im_lang)
            employeeName = view.findViewById(R.id.tv_lang)
            gridItem = view.findViewById(R.id.grid_item)
            employeeId = view.findViewById(R.id.tv_number)

            view.setOnClickListener(this)
        }

        override fun onLongClick(p0: View?): Boolean {
            TODO("Not yet implemented")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.gridview_items_activity, parent, false)

        return MyViewHolder(itemView)
    }

    @SuppressLint("RestrictedApi")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        try {

            val employeesResponse = employeeList?.get(position)
            Picasso.get().load(employeesResponse?.img_icon).into(holder.employeeImage)
            holder.employeeName?.text = employeesResponse?.name
            holder.employeeId?.text = employeesResponse?.id.toString()
            holder.gridItem?.setOnClickListener(View.OnClickListener {
               deleteItem(holder.itemView,position)
            })




        }catch (e:Exception){
            e.printStackTrace()
        }

    }

    private fun deleteItem(rowView: View, position: Int) {
        val anim: Animation = AnimationUtils.loadAnimation(
            context,
            android.R.anim.slide_out_right
        )
        anim.duration = 300
        rowView.startAnimation(anim)
        Handler().postDelayed(Runnable {
            if (employeeList?.size === 0) {
                return@Runnable
            }
            employeeList?.removeAt(position) //Remove the current content from the array
            notifyDataSetChanged() //Refresh list
        }, anim.duration)
    }


    override fun getItemCount(): Int {
        return employeeList?.size!!
    }




}