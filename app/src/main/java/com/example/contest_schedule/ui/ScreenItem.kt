package com.example.contest_schedule.ui

sealed class ScreenItem(val route: String) {
    object HomeScreenItem: ScreenItem("home_screen")
    object ProfileScreenItem: ScreenItem("profile_screen")
    object SplashScreenItem: ScreenItem("splash_screen")
    object RegistrationScreenItem: ScreenItem("registration_screen")
    object IntroScreenItem: ScreenItem("intro_screen")
    object LoginScreenItem: ScreenItem("login_screen")
    object UpdateProfileScreenItem: ScreenItem("update_profile_screen")
}