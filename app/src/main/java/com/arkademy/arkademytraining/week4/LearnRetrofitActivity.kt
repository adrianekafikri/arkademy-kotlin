package com.arkademy.arkademytraining.week4

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arkademy.arkademytraining.R
import com.arkademy.arkademytraining.databinding.ActivityLearnRetrofitBinding
import com.google.gson.Gson
import kotlinx.coroutines.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by adrianfikri on 2020-02-13.
 */
class LearnRetrofitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLearnRetrofitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_learn_retrofit)

        binding.recyclerView.adapter = EmployeeAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        useCoroutineToCallApi()
    }

    private fun useRetrofitToCallApi() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummy.restapiexample.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(EmployeeApiService::class.java)

        binding.progressBar.visibility = View.VISIBLE
        service.getAllEmployee().enqueue(object : Callback<EmployeeListResponse> {
            override fun onFailure(call: Call<EmployeeListResponse>, t: Throwable) {
                binding.progressBar.visibility = View.GONE
                Log.d("adri", "onFailure : ${Thread.currentThread().name}")
                Log.d("adri", t.message ?: "Error")
            }

            override fun onResponse(call: Call<EmployeeListResponse>, response: Response<EmployeeListResponse>) {
                Log.d("adri", "onResponse : ${Thread.currentThread().name}")
                binding.progressBar.visibility = View.GONE
                val list = response.body()?.data?.map {
                    EmployeeModel(it.id.orEmpty(), it.name.orEmpty(), it.salary.orEmpty(), it.age.orEmpty())
                } ?: listOf()
                (binding.recyclerView.adapter as EmployeeAdapter).addList(list)
            }
        })
    }

    private fun useCoroutineToCallApi() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummy.restapiexample.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(EmployeeApiService::class.java)

        val coroutineScope = CoroutineScope(Job() + Dispatchers.Main)

        coroutineScope.launch {
            Log.d("adri", "start : ${Thread.currentThread().name}")
            binding.progressBar.visibility = View.VISIBLE

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

                (binding.recyclerView.adapter as EmployeeAdapter).addList(list)
            } else if (response is Throwable) {
                Log.d("adri", response.message ?: "Error")
            }

            binding.progressBar.visibility = View.GONE
            Log.d("adri", "finish : ${Thread.currentThread().name}")
        }
    }
}