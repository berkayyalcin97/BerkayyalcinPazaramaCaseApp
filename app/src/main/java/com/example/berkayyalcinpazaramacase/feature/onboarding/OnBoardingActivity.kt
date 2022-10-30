package com.example.berkayyalcinpazaramacase.feature.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.berkayyalcinpazaramacase.R
import com.example.berkayyalcinpazaramacase.databinding.ActivityOnBoardingBinding


import com.example.berkayyalcinpazaramacase.feature.onboarding.adapter.OnBoardingAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = OnBoardingAdapter(this,prepareOnBoardingItems())

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
        }.attach()
    }

    private  fun prepareOnBoardingItems(): List<Int>{
        return listOf(R.layout.item_onboarding,R.layout.item_onboarding_two,R.layout.item_onboarding_three)
    }
}