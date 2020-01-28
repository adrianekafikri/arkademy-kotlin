package com.arkademy.arkademytraining.week2.toolbar

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.arkademy.arkademytraining.R
import com.arkademy.arkademytraining.SecondActivity

/**
 * Created by adrianfikri on 2020-01-28.
 */
class ToolbarTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar_test)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_to_second_activity -> {
                val dataString = "Arkademy Training"

                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra(SecondActivity.EXTRA_STRING, dataString)
                startActivityForResult(intent, 123)
                return true
            }
            R.id.action_toast -> {
                Toast.makeText(this, "Menu toast", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}