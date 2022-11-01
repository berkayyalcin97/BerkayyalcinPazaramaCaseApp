package com.example.berkayyalcinpazaramacase.feature.splash

import android.content.Intent
import android.content.Intent.getIntent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.berkayyalcinpazaramacase.MainActivity
import com.example.berkayyalcinpazaramacase.R
import com.example.berkayyalcinpazaramacase.feature.onboarding.OnBoardingActivity
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import dagger.internal.DaggerGenerated
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private val viewModel by viewModels<SplashViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        navigateToMain()

        lifecycleScope.launchWhenResumed {
            launch {
                viewModel.uiEvent.collect {
                    when (it) {
                        is SplashViewEvent.NavigateToOnBoarding -> {
                            navigateToOnBoarding()
                        }
                        is SplashViewEvent.NavigateToMain -> {
                            navigateToMain()


                        }
                        is SplashViewEvent.NavigateToLogin -> {

                        }
                    }
                }
            }
        }
    }

    private fun navigateToMain() {
        lifecycleScope.launch {
            delay(2000)
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    private fun navigateToOnBoarding() {
        lifecycleScope.launch {
            delay(2000)
            val intent = Intent(this@SplashActivity, OnBoardingActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}