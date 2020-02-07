package com.arkademy.arkademytraining.week3

/**
 * Created by adrianfikri on 2020-02-06.
 */
interface WebViewListener {
    fun onPageStarted()
    fun onPageFinished()
    fun onShouldOverrideUrl(redirectUrl: String)
    fun onProgressChanged(progress: Int)
}