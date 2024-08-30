package com.rey.logindemo

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rey.logindemo.presentation.home.HomeScreen
import com.rey.logindemo.presentation.login.LoginScreen
import com.rey.logindemo.presentation.onboarding.OnBoardingScreen
import com.rey.logindemo.presentation.otp.OtpScreen
import com.rey.logindemo.presentation.signup.SignupScreen
import com.rey.logindemo.presentation.splash.SplashScreen

@Composable
fun Navgraph(
    navController: NavHostController
){

    NavHost(navController = navController, startDestination = "splash"){

        composable("splash") {
            SplashScreen(navController = navController)
        }
        composable("onboarding") {
            OnBoardingScreen(navController = navController)
        }
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("otp") {
            OtpScreen(navController = navController)
        }
        composable("signup") {
            SignupScreen(navController = navController)
        }
        composable("home") {
            HomeScreen(navController = navController)
        }


    }
}