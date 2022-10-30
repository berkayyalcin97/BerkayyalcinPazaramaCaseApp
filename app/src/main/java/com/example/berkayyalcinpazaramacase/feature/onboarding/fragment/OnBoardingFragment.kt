package com.example.berkayyalcinpazaramacase.feature.onboarding.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.berkayyalcinpazaramacase.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OnBoardingFragment : Fragment() {
    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            position = it.getInt("position")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(position, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(position: Int) =
            OnBoardingFragment().apply {
                arguments = Bundle().apply {
                    putInt("position", position)

                }
            }
    }
}