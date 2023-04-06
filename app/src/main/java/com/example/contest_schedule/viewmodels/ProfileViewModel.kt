package com.example.contest_schedule.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: Repository) : ViewModel() {

    private val _profileResult = MutableLiveData<ProfileResult>()
    val profileResult: LiveData<ProfileResult> = _profileResult

    fun getProfile() {
        viewModelScope.launch {
            try {
                val response = repository.getProfile()
                if (response.isSuccessful) {
                    val profile = response.body()
                    if (profile != null) {
                        _profileResult.value = ProfileResult.Success(profile)
                    } else {
                        _profileResult.value = ProfileResult.Error("Invalid response")
                    }
                } else {
                    _profileResult.value = ProfileResult.Error(response.message())
                }
            } catch (e: Exception) {
                _profileResult.value = ProfileResult.Error(e.message ?: "An error occurred")
            }
        }
    }
}