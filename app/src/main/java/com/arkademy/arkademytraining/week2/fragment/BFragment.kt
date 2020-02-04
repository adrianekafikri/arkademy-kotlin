package com.arkademy.arkademytraining.week2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.arkademy.arkademytraining.R

/**
 * Created by adrianfikri on 2020-01-30.
 */
class BFragment(private val listener: BListener?) : Fragment() {

    private lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_b, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnChangeB = rootView.findViewById<Button>(R.id.btn_change_info_b)
        btnChangeB.setOnClickListener {
            listener?.onChangeBClicked("B")
        }
    }

    interface BListener {
        fun onChangeBClicked(info: String)
    }
}