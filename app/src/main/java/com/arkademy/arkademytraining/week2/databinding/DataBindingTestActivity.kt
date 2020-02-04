package com.arkademy.arkademytraining.week2.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.arkademy.arkademytraining.R
import com.arkademy.arkademytraining.databinding.ActivityDataBindingTestBinding

/**
 * Created by adrianfikri on 2020-01-30.
 */
class DataBindingTestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataBindingTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_test)
        binding.model = ArkademyModel("Erdin", "erdin@mail.com", "Karawang")

        binding.btnChange.setOnClickListener {
            binding.model = ArkademyModel("Kiki", "kiki@mail.com", "Bogor")
        }
    }
}