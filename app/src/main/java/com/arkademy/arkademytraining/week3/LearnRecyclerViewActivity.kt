package com.arkademy.arkademytraining.week3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arkademy.arkademytraining.R
import com.arkademy.arkademytraining.databinding.ActivityLearnRecyclerviewBinding

/**
 * Created by adrianfikri on 2020-02-06.
 */
class LearnRecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLearnRecyclerviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_learn_recyclerview)

        binding.recyclerView.adapter = LearnRecyclerAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }
}