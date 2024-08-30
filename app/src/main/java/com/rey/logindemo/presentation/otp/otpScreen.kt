package com.rey.logindemo.presentation.otp

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.rey.logindemo.R

@Composable
fun OtpScreen(navController: NavController) {
    val context = LocalContext.current
    var otp by remember { mutableStateOf("") }
    val bgColor = Color(0xFF102C57)

    // Hardcoded OTP for verification
    val hardcodedOtp = "123456"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
            .padding(top = 240.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp),
        ) {
            Text(
                text = "OTP",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = "Verification",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Enter the code from the sms we sent to", color = Color.White, fontSize = 15.sp)
            Text(text = "your phone number", color = Color.White, fontSize = 15.sp)
        }

        Spacer(modifier = Modifier.height(0.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(bgColor),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.size(50.dp))

            BasicTextField(
                value = otp,
                onValueChange = {
                    if (it.length <= 6) otp = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    repeat(6) { index ->
                        val number = when {
                            index >= otp.length -> ""
                            else -> otp[index]
                        }

                        Column(
                            verticalArrangement = Arrangement.spacedBy(6.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = number.toString(),
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White
                            )

                            Box(
                                modifier = Modifier
                                    .width(40.dp)
                                    .height(2.dp)
                                    .background(Color.White)
                            ) {}
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.size(30.dp))

            Button(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .height(45.dp)
                    .width(350.dp)
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth(0.8f)
                    .clip(RoundedCornerShape(12.dp)),
                onClick = {
                    if (otp == hardcodedOtp) {
                        navController.navigate("home")
                        Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Invalid OTP", Toast.LENGTH_SHORT).show()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFDAC0A3)
                )
            ) {
                Text(
                    text = stringResource(id = R.string.verify),
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun OtpScreenPreview() {
    OtpScreen(rememberNavController())
}