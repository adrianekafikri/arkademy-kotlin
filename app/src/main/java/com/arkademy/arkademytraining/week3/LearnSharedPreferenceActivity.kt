package com.arkademy.arkademytraining.week3

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.preference.PreferenceManager
import com.arkademy.arkademytraining.R
import com.arkademy.arkademytraining.databinding.ActivityLearnSharedPreferenceBinding

/**
 * Created by adrianfikri on 2020-02-06.
 */
class LearnSharedPreferenceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLearnSharedPreferenceBinding

    companion object {
        const val KEY_EMAIL = "key_email"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_learn_shared_preference)

        val defaultSharedPref = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        binding.tvEmail.text = defaultSharedPref.getString(KEY_EMAIL, ". . . . .")

        binding.btnUpdateEmail.setOnClickListener {
            defaultSharedPref.edit().putString(KEY_EMAIL, "arkademy@mail.com").apply()
        }
    }
}