package com.arkademy.arkademytraining.week3

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.arkademy.arkademytraining.R
import com.arkademy.arkademytraining.databinding.ActivityLearnDialogBinding
import com.arkademy.arkademytraining.databinding.DialogAlertTestBinding
import kotlinx.android.synthetic.main.activity_learn_dialog.*

/**
 * Created by adrianfikri on 2020-02-02.
 */
class LearnDialogActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLearnDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_learn_dialog)

        binding.btnShowDialogOne.setOnClickListener(this)
        binding.btnShowDialogTwo.setOnClickListener(this)
        binding.btnShowDialogThree.setOnClickListener(this)
        binding.btnShowDialogFour.setOnClickListener(this)
        binding.btnShowDialogFive.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_show_dialog_one -> {
                showDialogOne()
            }
            R.id.btn_show_dialog_two -> {
                showDialogTwo()
            }
            R.id.btn_show_dialog_three -> {
                showDialogThree()
            }
            R.id.btn_show_dialog_four -> {
                showDialogFour()
            }
            R.id.btn_show_dialog_five -> {
                showDialogFive()
            }
        }
    }

    private fun showDialogOne() {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Test Dialog One")
            .setMessage("This is dialog one test")
            .create()
        dialog.show()
    }

    private fun showDialogTwo() {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Test Dialog Two")
            .setPositiveButton("Show Toast") { dialogInterface, i ->
                Toast.makeText(this, "This is dialog two toast", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Dismiss") { dialogInterface, i ->
                dialogInterface.dismiss()
            }
        dialog.show()
    }

    private fun showDialogThree() {
        val rootView = DataBindingUtil.inflate<DialogAlertTestBinding>(layoutInflater, R.layout.dialog_alert_test, null, false)

        val dialog = AlertDialog.Builder(this)
            .setView(rootView.root)
            .setCancelable(false)
            .create()
        dialog.show()
        rootView.btnOk.setOnClickListener { dialog.dismiss() }
    }

    private fun showDialogFour() {
        try {
            val dialogFragment = supportFragmentManager.findFragmentByTag(TestDialogFragment.TAG)
            if (dialogFragment != null) {
                supportFragmentManager.beginTransaction().remove(dialogFragment).commit()
            }

            TestDialogFragment().show(supportFragmentManager, TestDialogFragment.TAG)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    private fun showDialogFive() {
        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDay ->

            }, 2020, 1, 4
        ).show()
    }
}