package com.rey.logindemo.presentation.login

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.rey.logindemo.R
import com.rey.logindemo.ui.theme.bgColor
import com.rey.logindemo.ui.theme.enterNumberColor

@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    var phoneNum by remember { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current


    val hardcodedPhoneNumber = "1234567890"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
            .padding(horizontal = 24.dp)
            .pointerInput(Unit) {
                detectTapGestures(onTap = { _ ->
                    keyboardController?.hide()
                })
            },
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(id = R.string.lbl_welcome),
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall.copy(fontSize = 30.sp),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 39.dp)
                .fillMaxWidth(),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )

        Text(
            text = stringResource(id = R.string.msg_sign_in_to_your),
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp),
            modifier = Modifier
                .padding(top = 9.dp)
                .fillMaxWidth(),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )

        Image(
            painter = painterResource(id = R.drawable.im_onboarding),
            contentDescription = "Login Image",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp)
                .size(150.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 38.dp),
        ) {
            OutlinedTextField(
                value = phoneNum,
                onValueChange = { if (it.length <= 10) phoneNum = it },
                label = { Text("Enter number") },
                colors = TextFieldDefaults.colors(
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = enterNumberColor,
                    focusedContainerColor = Color(0xFFF8F0E5),
                    unfocusedContainerColor = Color(0xFFF8F0E5),
                    focusedIndicatorColor = Color(android.graphics.Color.parseColor("#32357A")),
                    cursorColor = Color.Black
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 13.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                textStyle = TextStyle(
                    color = Color.Black
                ),
            )

            Button(
                onClick = {
                    if (phoneNum == hardcodedPhoneNumber) {
                        navController.navigate("otp")
                    } else {
                        Toast.makeText(context, "Invalid phone number", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 17.dp)
                    .padding(top = 24.dp),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFDAC0A3)
                ),
                contentPadding = PaddingValues(14.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.lbl_sign_in),
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row {
                    Text(text = stringResource(R.string.don_t_have_an_account), color = Color.White)
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = stringResource(R.string.sign_up),
                        color = Color(0xFFDAC0A3),
                        modifier = Modifier.clickable { navController.navigate("signup") }
                    )
                }
            }
        }
    }
}





@Preview
@Composable
fun SignInScreenPreview() {
    LoginScreen(rememberNavController())
}