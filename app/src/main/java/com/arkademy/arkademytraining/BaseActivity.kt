package com.arkademy.arkademytraining

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by adrianfikri on 2020-01-28.
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }
}