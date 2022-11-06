package com.example.berkayyalcinpazaramacase.feature.register

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.berkayyalcinpazaramacase.R
import com.example.berkayyalcinpazaramacase.databinding.FragmentRegisterBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private val viewModel by viewModels<RegisterViewModel>()
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenResumed {
            launch {
                viewModel.uiEvent.collect {
                    when (it) {
                        is RegisterViewEvent.NavigateToMain -> {
                            Snackbar.make(requireView(), "Register Success", Snackbar.LENGTH_SHORT)
                                .show()

                        }
                        is RegisterViewEvent.ShowError -> {
                            Snackbar.make(requireView(), it.error, Snackbar.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
        }
        initViews()

    }

    private fun initViews() {
        with(binding) {
            btnRegister.setOnClickListener {
                viewModel.register(
                    etMailLogin.text.trim().toString(),
                    etPasswordLogin.text.trim().toString(),
                    etConfirmPasswordLogin.text.trim().toString(),
                    etUserName.text.trim().toString()
                )
            }
        }
    }
}