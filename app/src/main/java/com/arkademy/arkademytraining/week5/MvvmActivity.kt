package com.arkademy.arkademytraining.week5

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arkademy.arkademytraining.R
import com.arkademy.arkademytraining.databinding.ActivityLearnMvvmBinding
import com.arkademy.arkademytraining.week4.EmployeeAdapter
import com.arkademy.arkademytraining.week4.EmployeeApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by adrianfikri on 2020-02-20.
 */
class MvvmActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLearnMvvmBinding
    private lateinit var viewModel: MvvmViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_learn_mvvm)
        viewModel = ViewModelProvider(this).get(MvvmViewModel::class.java)
        binding.recyclerView.adapter = EmployeeAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        subscribeLiveData()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummy.restapiexample.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(EmployeeApiService::class.java)
        viewModel.setEmployeeService(service)
        viewModel.getEmployee()
    }

    private fun subscribeLiveData() {
        viewModel.isLoadingLiveData.observe(this, Observer {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        })
        viewModel.employeesLiveData.observe(this, Observer {
            (binding.recyclerView.adapter as EmployeeAdapter).addList(it)
        })
    }
}