package com.example.androidsystemroundapplication

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidsystemroundapplication.Model.response.EmployeeList

class MainActivity : AppCompatActivity() {
    var recyclerview:RecyclerView?=null
    var employeeList: ArrayList<EmployeeList>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("employeeslist","mainactivity is called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview = findViewById(R.id.employees_list)

        employeeList = ArrayList<EmployeeList>()
        employeeList?.add(0, EmployeeList(1,"Praveen","https://i.pinimg.com/236x/34/25/9d/34259d8b6b60a94f5e43bde242ecc26e.jpg"))
        employeeList?.add(1, EmployeeList(2,"Swetha","https://i.pinimg.com/736x/3a/e6/62/3ae6620e91e2a72f900dd1d67e981281.jpg"))
        employeeList?.add(2,
            EmployeeList(3,"Siva","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAoOanyuL7OTh7g-U0tB3tk6Z4KwXHxoqu-xjKFwfxUQxdVViU-2-66B0XcJcyV4aVPR0&usqp=CAU")
        )
        employeeList?.add(3,
            EmployeeList(4,"Bala","https://as2.ftcdn.net/jpg/02/35/50/89/500_F_235508902_03gewLthliinMOVJmE2JR0mvhPPrJJO9.jpg")
        )
        employeeList?.add(4,
            EmployeeList(5,"Jones","https://image.shutterstock.com/image-vector/cartoon-boy-giving-you-thumbs-260nw-143614309.jpg")
        )
        employeeList?.add(5,
            EmployeeList(6,"Navdeep","https://previews.123rf.com/images/tigatelu/tigatelu1307/tigatelu130700004/20754296-cute-boy-cartoon-standing.jpg")
        )
        employeeList?.add(6,
            EmployeeList(7,"Harsha Priya","https://images.statusfacebook.com/profile_pictures/cartoon_girls/cartoon_girls_profile_picture41.jpg")
        )
        employeeList?.add(7,
            EmployeeList(8,"Anil Kumar","https://cdn1.vectorstock.com/i/1000x1000/25/95/cute-boy-cartoon-good-posing-vector-16702595.jpg")
        )
        employeeList?.add(8,
            EmployeeList(9,"Lokesh Babu","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTunKLgHTH-M6uovLXnIUMbyjkpjFrSbteQ_oFqU1lwu5kI2Px8n5Rzd_DsBJSjCGMqhrU&usqp=CAU")
        )
        employeeList?.add(9,EmployeeList(10,"Raghu","https://i.pinimg.com/originals/20/87/4c/20874c8a1454326184d46b053f6597ff.jpg"))


        recyclerview?.layoutManager = GridLayoutManager(this, 3)
        val employeesListAdapter = EmployeesListAdapter(this,employeeList)
        recyclerview?.adapter = employeesListAdapter

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        // Checks the orientation of the screen
        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show()
        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show()
        }
    }

}
