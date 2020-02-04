package com.arkademy.arkademytraining.week2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.arkademy.arkademytraining.R

/**
 * Created by adrianfikri on 2020-01-30.
 */
class AFragment(private val listener: AListener?) : Fragment() {

    private lateinit var rootView: View

    companion object {
        const val EXTRA_INFO = "EXTRA_INFO"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_a, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val infoA = arguments?.getString(EXTRA_INFO) ?: ""
        rootView.findViewById<Button>(R.id.btn_change_info_a).setOnClickListener {
            listener?.onChangeAClicked()
            rootView.findViewById<TextView>(R.id.tv_fragment_a).text = infoA
        }
    }

    interface AListener {
        fun onChangeAClicked()
    }
}