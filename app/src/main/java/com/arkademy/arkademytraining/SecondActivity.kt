package com.arkademy.arkademytraining

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by adrianfikri on 2020-01-21.
 */
class SecondActivity : BaseActivity() {

    companion object {
        const val EXTRA_STRING = "extraString"
        const val EXTRA_BACK = "extraBack"
    }

    override fun getLayoutId(): Int = R.layout.activity_second

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data = intent.getStringExtra(EXTRA_STRING)
        val btnShowData = findViewById<Button>(R.id.bt_show_data)
        val tvShowData = findViewById<TextView>(R.id.tv_show_data)
        val tvBack = findViewById<TextView>(R.id.tv_back)

        btnShowData.setOnClickListener {
            tvShowData.text = data
        }

        tvBack.setOnClickListener {
            val backIntent = Intent()
            backIntent.putExtra(EXTRA_BACK, tvBack.text)
            setResult(Activity.RESULT_OK, backIntent)
            finish()
        }

    }
}