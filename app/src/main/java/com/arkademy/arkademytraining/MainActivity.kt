package com.arkademy.arkademytraining

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.arkademy.arkademytraining.week2.oop.Iphone
import com.arkademy.arkademytraining.week2.oop.Person
import com.arkademy.arkademytraining.week2.oop.Samsung
import com.arkademy.arkademytraining.week2.toolbar.ToolbarTestActivity

class MainActivity : BaseActivity() {

    lateinit var tvReceiveResult: TextView

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tvReceiveResult = findViewById(R.id.tv_receive_result)
        val vRed = findViewById<View>(R.id.v_red)
        vRed.setOnClickListener {
            /*val dataString = "Arkademy Training"

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(SecondActivity.EXTRA_STRING, dataString)
            startActivityForResult(intent, 123)*/

            val intent = Intent(this, ToolbarTestActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 123 && resultCode == Activity.RESULT_OK) {
            tvReceiveResult.text = data?.getStringExtra(SecondActivity.EXTRA_BACK) ?: "Arkademy"
        }

    }
}
