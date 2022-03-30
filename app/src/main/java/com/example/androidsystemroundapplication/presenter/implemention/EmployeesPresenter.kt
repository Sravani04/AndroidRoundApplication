package com.example.androidsystemroundapplication.presenter.implemention

import android.util.Log
import com.example.androidsystemroundapplication.ApiClient
import com.example.androidsystemroundapplication.ApiInterface
import com.example.androidsystemroundapplication.Model.response.EmployeesDataArray
import com.example.androidsystemroundapplication.presenter.interfaces.EmployeesMainView
import com.example.androidsystemroundapplication.presenter.interfaces.IEmployees
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class EmployeesPresenter(var employeesMainView: EmployeesMainView):IEmployees {
    var apiInterface: ApiInterface = ApiClient().getClient()!!.create(ApiInterface::class.java)
    override fun getEmployeesList() {
        val call: Call<ArrayList<EmployeesDataArray?>?>? = apiInterface.getEmployeesList()
        call?.enqueue(object : Callback<ArrayList<EmployeesDataArray?>?> {
            override fun onResponse(
                call: Call<ArrayList<EmployeesDataArray?>?>,
                response: Response<ArrayList<EmployeesDataArray?>?>
            ) {
                Log.e("llll", apiInterface.getEmployeesList().toString())
                if (response.isSuccessful) {

                    try {
                        employeesMainView.getEmployeesList(response.body())
                        Log.e("TAG", "Employees list response: " + response.body())
                    }catch (e: Exception){
                        e.printStackTrace()
                    }

                }
            }

            override fun onFailure(call: Call<ArrayList<EmployeesDataArray?>?>, t: Throwable) {

            }

        })
    }
}