package com.arkademy.arkademytraining.week3

import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.arkademy.arkademytraining.R
import com.arkademy.arkademytraining.databinding.ActivityLearnWebviewBinding

/**
 * Created by adrianfikri on 2020-02-06.
 */
class LearnWebViewActivity : AppCompatActivity(), WebViewListener {

    private lateinit var binding: ActivityLearnWebviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_learn_webview)

        binding.webview.loadUrl("https://www.arkademy.com/")

        binding.webview.webChromeClient = ArkademyChromeClient(this)
        binding.webview.webViewClient = ArkademyWebClient(this)
    }

    override fun onPageStarted() {
        binding.progressBar.visibility = View.VISIBLE
        Toast.makeText(this, "Page started", Toast.LENGTH_SHORT).show()
    }

    override fun onPageFinished() {
        binding.progressBar.visibility = View.GONE
    }

    override fun onShouldOverrideUrl(redirectUrl: String) {
        Toast.makeText(this, "redirectUrl : $redirectUrl", Toast.LENGTH_SHORT).show()
    }

    override fun onProgressChanged(progress: Int) {
        binding.progressBar.progress = progress
    }

    class ArkademyChromeClient(private val listener: WebViewListener) : WebChromeClient() {

        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            listener.onProgressChanged(newProgress)
            super.onProgressChanged(view, newProgress)
        }
    }

    class ArkademyWebClient(private val listener: WebViewListener) : WebViewClient() {

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            listener.onPageStarted()
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            listener.onPageFinished()
        }

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            listener.onShouldOverrideUrl(url.orEmpty())
            return super.shouldOverrideUrlLoading(view, url)
        }

        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                listener.onShouldOverrideUrl(request?.url?.toString().orEmpty())
            }
            return super.shouldOverrideUrlLoading(view, request)
        }
    }
}