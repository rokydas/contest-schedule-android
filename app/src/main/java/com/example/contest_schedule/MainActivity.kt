package com.example.contest_schedule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.contest_schedule.ui.ScreenItem
import com.example.contest_schedule.ui.screens.*
import com.example.contest_schedule.ui.theme.ContestScheduleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // state

        setContent {
            ContestScheduleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = ScreenItem.SplashScreenItem.route
                    ) {
                        composable(route = ScreenItem.HomeScreenItem.route) {
                            HomeScreen(navController = navController)
                        }
                        composable(route = ScreenItem.LoginScreenItem.route) {
                            LoginScreen(navController = navController)
                        }
                        composable(route = ScreenItem.RegistrationScreenItem.route) {
                            RegistrationScreen(navController = navController)
                        }
                        composable(route = ScreenItem.ProfileScreenItem.route) {
                            ProfileScreen(navController = navController)
                        }
                        composable(route = ScreenItem.UpdateProfileScreenItem.route) {
                            UpdateProfileScreen(navController = navController)
                        }
                        composable(route = ScreenItem.SplashScreenItem.route) {
                            SplashScreen(navController = navController)
                        }
                        composable(route = ScreenItem.IntroScreenItem.route) {
                            IntroScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ContestScheduleTheme {
        Greeting("Android")
    }
}