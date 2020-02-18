package com.arkademy.arkademytraining.week5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.preference.PreferenceManager
import com.arkademy.arkademytraining.R
import com.arkademy.arkademytraining.databinding.ActivityLearnMvpBinding

/**
 * Created by adrianfikri on 2020-02-18.
 */
class MvpActivity : AppCompatActivity(), MvpContract.View {

    private lateinit var binding: ActivityLearnMvpBinding
    private var presenter: MvpPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_learn_mvp)
        presenter = MvpPresenter(this, PreferenceManager.getDefaultSharedPreferences(this))

        binding.btnSave.setOnClickListener {
            presenter?.saveName(binding.etName.text.toString())
        }
    }

    override fun updateName(name: String) {
        binding.tvName.text = name
    }

    override fun onDestroy() {
        presenter = null
        super.onDestroy()
    }
}