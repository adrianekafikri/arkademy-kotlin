package com.arkademy.arkademytraining

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.preference.PreferenceManager
import com.arkademy.arkademytraining.week2.databinding.DataBindingTestActivity
import com.arkademy.arkademytraining.week2.fragment.AFragment
import com.arkademy.arkademytraining.week2.fragment.BFragment
import com.arkademy.arkademytraining.week2.oop.Iphone
import com.arkademy.arkademytraining.week2.oop.Person
import com.arkademy.arkademytraining.week2.oop.Samsung
import com.arkademy.arkademytraining.week2.toolbar.ToolbarTestActivity
import com.arkademy.arkademytraining.week3.*

class MainActivity : BaseActivity(), AFragment.AListener {

    private lateinit var tvInfoFragment: TextView

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val btnSwitchA = findViewById<Button>(R.id.btn_switch_a)
        val btnSwitchB = findViewById<Button>(R.id.btn_switch_b)
        tvInfoFragment = findViewById(R.id.tv_info_fragment)

        btnSwitchA.setOnClickListener {
            val aFragment = AFragment(this)
            val bundle = Bundle()
            bundle.putString(AFragment.EXTRA_INFO, "ARGUMENT A")
            aFragment.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.fl_container, aFragment).commit()
        }

        btnSwitchB.setOnClickListener {
            /*val bFragment = BFragment(object : BFragment.BListener {
                override fun onChangeBClicked(info: String) {
                    tvInfoFragment.text = info
                }
            })
            supportFragmentManager.beginTransaction().replace(R.id.fl_container, bFragment).commit()*/
            val intent = Intent(this, LearnRecyclerViewActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onChangeAClicked() {
        tvInfoFragment.text = "A"
    }
}
