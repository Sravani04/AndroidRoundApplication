package com.example.androidsystemroundapplication.Model.response

import com.google.gson.annotations.SerializedName

data class EmployeesDataArray (@SerializedName("EmpId") var EmpId:Int?=null,
    @SerializedName("EmpName")
    var EmpName:String?=null,
    @SerializedName("Email")
    var Email:String?=null,
    @SerializedName("Designation")
    var Designation:String?=null,
    @SerializedName("Salary")
    var Salary:String?=null,
    @SerializedName("PhotoUrl")
    var PhotoUrl:String?=null
)
