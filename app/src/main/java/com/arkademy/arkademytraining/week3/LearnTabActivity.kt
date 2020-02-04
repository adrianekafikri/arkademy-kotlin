package com.arkademy.arkademytraining.week3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.arkademy.arkademytraining.R
import com.arkademy.arkademytraining.databinding.ActivityLearnTabBinding
import com.google.android.material.tabs.TabLayout

/**
 * Created by adrianfikri on 2020-02-04.
 */
class LearnTabActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLearnTabBinding
    private lateinit var pagerAdapter: LearnTabPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_learn_tab)

        pagerAdapter = LearnTabPagerAdapter(supportFragmentManager)
        binding.viewPager.adapter = pagerAdapter

        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}