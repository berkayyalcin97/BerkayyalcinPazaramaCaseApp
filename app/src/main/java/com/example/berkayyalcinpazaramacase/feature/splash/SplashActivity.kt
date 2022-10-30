package com.example.berkayyalcinpazaramacase.feature.splash

import android.content.Intent
import android.content.Intent.getIntent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.berkayyalcinpazaramacase.MainActivity
import com.example.berkayyalcinpazaramacase.R
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import dagger.internal.DaggerGenerated
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        navigateToMain()
    }

    private fun navigateToMain() {
       lifecycleScope.launch {
           delay(4000)
           val intent = Intent(this@SplashActivity,MainActivity::class.java)
           startActivity(intent)
       }
    }
}