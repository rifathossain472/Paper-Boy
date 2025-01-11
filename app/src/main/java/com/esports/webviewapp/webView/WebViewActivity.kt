package com.esports.webviewapp.webView

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.esports.webviewapp.databinding.ActivityWebViewBinding
import com.esports.webviewapp.starter.MainActivity

@Suppress("DEPRECATION")
class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent.getStringExtra("name")

        binding.apply {
            webView.loadUrl(intent.toString())
            webView.settings.javaScriptEnabled = true
            webView.webViewClient = WebViewClient()
        }
        binding.homeIv.setOnClickListener {
            val homeIntent = Intent(this@WebViewActivity, MainActivity::class.java)
            startActivity(homeIntent)
        }

        binding.backIV.setOnClickListener {
            onBackPressed()
        }

        binding.forwardIv.setOnClickListener {
            goForward()
        }

        binding.refreshIv.setOnClickListener {
            Toast.makeText(this, "Reloading...", Toast.LENGTH_SHORT).show()
            binding.webView.reload()
        }

    }

    private fun goForward() {
        if (binding.webView.canGoForward()) {
            binding.webView.goForward()
        } else {
            Toast.makeText(this, "No Forward History", Toast.LENGTH_SHORT).show()
        }
    }

    @Deprecated("This method has been deprecated in favor of using the\n      {@link OnBackPressedDispatcher} via {@link #getOnBackPressedDispatcher()}.\n      The OnBackPressedDispatcher controls how back button events are dispatched\n      to one or more {@link OnBackPressedCallback} objects.")
    override fun onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}