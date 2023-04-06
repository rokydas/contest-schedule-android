package com.example.contest_schedule.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RegistrationViewModel(private val repository: Repository) : ViewModel() {

    private val _registrationResult = MutableLiveData<RegistrationResult>()
    val registrationResult: LiveData<RegistrationResult> = _registrationResult

    fun register(name: String, email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = repository.register(name, email, password)
                if (response.isSuccessful) {
                    val token = response.body()?.token
                    if (token != null) {
                        _registrationResult.value = RegistrationResult.Success(token)
                    } else {
                        _registrationResult.value = RegistrationResult.Error("Invalid response")
                    }
                } else {
                    _registrationResult.value = RegistrationResult.Error(response.message())
                }
            } catch (e: Exception) {
                _registrationResult.value = RegistrationResult.Error(e.message ?: "An error occurred")
            }
        }
    }
}