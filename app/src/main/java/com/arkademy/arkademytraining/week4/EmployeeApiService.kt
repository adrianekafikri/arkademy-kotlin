package com.arkademy.arkademytraining.week4

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by adrianfikri on 2020-02-13.
 */
interface EmployeeApiService {

    @GET("api/v1/employees")
    fun getAllEmployee(): Call<EmployeeListResponse>

    @GET("api/v1/employees")
    suspend fun getEmployees(): EmployeeListResponse

    @GET("api/v1/employee/{id}")
    fun getEmployee(@Path("id") id: String): Call<EmployeeDetailResponse>

    @POST("api/v1/create")
    fun addEmployee(requestBody: EmployeeRequestBody): BaseApiResponse
}