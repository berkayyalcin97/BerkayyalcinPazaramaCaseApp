package com.example.berkayyalcinpazaramacase.feature.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.berkayyalcinpazaramacase.data.local.DataStoreManager
import com.example.berkayyalcinpazaramacase.feature.login.LoginUiState
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager,
    private val firebaseAuth: FirebaseAuth
) : ViewModel() {


    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Empty)
    val uiState: StateFlow<LoginUiState> = _uiState

    private val _uiEvent = MutableSharedFlow<RegisterViewEvent>(replay = 0)
    val uiEvent: SharedFlow<RegisterViewEvent> = _uiEvent
init {
  //  register("tofiyalcin@gmail.com","123456","123456","tofi")
}

    fun register(email: String, password: String,confirmPassword: String, userName: String) {
        viewModelScope.launch {
            if (isValidFields(email, password,confirmPassword ,userName)) {
                firebaseAuth.createUserWithEmailAndPassword(
                    email,
                    password
                ).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        viewModelScope.launch {
                            _uiEvent.emit(RegisterViewEvent.NavigateToMain)
                        }

                    } else {
                        viewModelScope.launch {
                            _uiEvent.emit(RegisterViewEvent.ShowError(task.exception?.message.toString()))
                        }
                    }
                }
            } else {
                _uiEvent.emit(RegisterViewEvent.ShowError("Please fill all fields"))
            }
        }
    }

    private fun isValidFields
                (email: String,
                 password: String,
                 confirmPassword: String,
                 userName: String): Boolean {
        return email.isNotEmpty()
                && password.isNotEmpty()
                && userName.isNotEmpty()
                && confirmPassword.isNotEmpty()
                && password == confirmPassword
    }
}

sealed class RegisterViewEvent {
    object NavigateToMain : RegisterViewEvent()
    class ShowError(val error: String) : RegisterViewEvent()
}