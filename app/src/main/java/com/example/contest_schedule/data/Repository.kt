package com.example.contest_schedule.data

class Repository(private val apiService: ApiService) {

    suspend fun login(email: String, password: String) = apiService.login(email, password)

    suspend fun register(name: String, email: String, password: String) =
        apiService.register(name, email, password)

    suspend fun getProfile() = apiService.getProfile()

    suspend fun updateProfile(name: String, email: String, imageUrl: String?) =
        apiService.updateProfile(name, email, imageUrl)
}