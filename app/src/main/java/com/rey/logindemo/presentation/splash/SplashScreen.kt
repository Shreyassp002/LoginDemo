package com.rey.logindemo.presentation.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rey.logindemo.ui.theme.bgColor
import com.rey.logindemo.ui.theme.btncolor
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 3000)
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(3000) // This delay matches the animation duration

        // Navigate to the OnBoarding screen after the animation
        navController.navigate("onboarding") {
            // Pop up to the splash screen from the back stack
            // and then remove it to prevent going back to the splash screen
            popUpTo("splash") { inclusive = true }
        }
    }

    Splash(alpha = alphaAnim)
}

@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = bgColor
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "Tech λ",
                style = MaterialTheme.typography.headlineLarge.copy(color = btncolor, fontWeight = FontWeight.Bold, fontSize = 40.sp),
                modifier = Modifier
                    .alpha(alpha)
                    .graphicsLayer {
                        // Optional: you can adjust textOffset if you want additional animation
                    }
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}
