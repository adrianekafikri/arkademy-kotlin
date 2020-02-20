package com.arkademy.arkademytraining.week5

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arkademy.arkademytraining.week4.EmployeeAdapter
import com.arkademy.arkademytraining.week4.EmployeeApiService
import com.arkademy.arkademytraining.week4.EmployeeListResponse
import com.arkademy.arkademytraining.week4.EmployeeModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * Created by adrianfikri on 2020-02-20.
 */
class MvvmViewModel : ViewModel(), CoroutineScope {

    val isLoadingLiveData = MutableLiveData<Boolean>()
    val employeesLiveData = MutableLiveData<List<EmployeeModel>>()
    private lateinit var service: EmployeeApiService

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Main

    fun setEmployeeService(service: EmployeeApiService) {
        this.service = service
    }

    fun getEmployee() {
        launch {
            isLoadingLiveData.value = true

            val response = withContext(Dispatchers.IO) {
                Log.d("adri", "callApi : ${Thread.currentThread().name}")
                try {
                    service.getEmployees()
                } catch (e: Throwable) {
                    e.printStackTrace()
                }
            }

            if (response is EmployeeListResponse) {
                val list = response.data?.map {
                    EmployeeModel(it.id.orEmpty(), it.name.orEmpty(), it.salary.orEmpty(), it.age.orEmpty())
                } ?: listOf()

                employeesLiveData.value = list
            } else if (response is Throwable) {
                Log.d("adri", response.message ?: "Error")
            }

            isLoadingLiveData.value = false
        }
    }
}