package com.arkademy.arkademytraining.week4

import com.google.gson.annotations.SerializedName

/**
 * Created by adrianfikri on 2020-02-13.
 */
data class EmployeeListResponse(val data: List<Employee>?) : BaseApiResponse() {

    data class Employee(val id: String?,
                        @SerializedName("employee_name") val name: String?,
                        @SerializedName("employee_salary") val salary: String?,
                        @SerializedName("employee_age") val age: String?,
                        @SerializedName("profile_image") val profileImage: String?)
}