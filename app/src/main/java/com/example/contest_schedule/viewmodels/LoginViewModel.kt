package com.example.contest_schedule.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: Repository) : ViewModel() {

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = repository.login(email, password)
                if (response.isSuccessful) {
                    val token = response.body()?.token
                    if (token != null) {
                        _loginResult.value = LoginResult.Success(token)
                    } else {
                        _loginResult.value = LoginResult.Error("Invalid response")
                    }
                } else {
                    _loginResult.value = LoginResult.Error(response.message())
                }
            } catch (e: Exception) {
                _loginResult.value = LoginResult.Error(e.message ?: "An error occurred")
            }
        }
    }
}