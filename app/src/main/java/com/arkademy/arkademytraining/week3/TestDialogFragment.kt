package com.arkademy.arkademytraining.week3

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.arkademy.arkademytraining.R
import com.arkademy.arkademytraining.databinding.FragmentDialogTestBinding

/**
 * Created by adrianfikri on 2020-02-02.
 */
class TestDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentDialogTestBinding

    companion object {
        val TAG = TestDialogFragment::class.java.simpleName
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dialog_test, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isCancelable = false
        binding.btnDismiss.setOnClickListener {
            dismiss()
        }
    }
}