package com.example.contest_schedule.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UpdateProfileViewModel(private val repository: Repository) : ViewModel() {

    private val _updateProfileResult = MutableLiveData<UpdateProfileResult>()
    val updateProfileResult: LiveData<UpdateProfileResult> = _updateProfileResult

    fun updateProfile(name: String, email: String, imageUrl: String?) {
        viewModelScope.launch {
            try {
                val response = repository.updateProfile(name, email, imageUrl)
                if (response.isSuccessful) {
                    val profile = response.body()
                    if (profile != null) {
                        _updateProfileResult.value = UpdateProfileResult.Success(profile)
                    } else {
                        _updateProfileResult.value = UpdateProfileResult.Error("Invalid response")
                    }
                } else {
                    _updateProfileResult.value = UpdateProfileResult.Error(response.message())
                }
            } catch (e: Exception) {
                _updateProfileResult.value = UpdateProfileResult.Error(e.message ?: "An error occurred")
            }
        }
    }
}