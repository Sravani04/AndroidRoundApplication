package com.example.androidsystemroundapplication.presenter.interfaces

import com.example.androidsystemroundapplication.Model.response.EmployeesDataArray

interface EmployeesMainView {
    fun getEmployeesList(employeesDataArray: ArrayList<EmployeesDataArray?>?)
}