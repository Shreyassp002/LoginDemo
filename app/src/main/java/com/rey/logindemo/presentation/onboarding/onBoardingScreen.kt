package com.rey.logindemo.presentation.onboarding

import android.util.Log
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
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.rey.logindemo.R
import com.rey.logindemo.ui.theme.bgColor

@Composable
fun OnBoardingScreen(navController: NavController) {

    val keyboardController = LocalSoftwareKeyboardController.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.Start
    ) {


        Image(
            painter = painterResource(id = R.drawable.im_onboarding),
            contentDescription = "Login Image",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp)
                .size(180.dp)
        )
        Text(
            text = stringResource(id = R.string.lbl_welcome),
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall.copy(fontSize = 30.sp),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 39.dp)
                .fillMaxWidth(),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            textAlign = TextAlign.Center
        )

        Text(
            text = stringResource(id = R.string.msg_sign_in_to_your),
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 15.sp),
            modifier = Modifier
                .padding(top = 9.dp)
                .fillMaxWidth(),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(id = R.string.msg_sign_in_to_your1),
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 15.sp),
            modifier = Modifier
                .padding(top = 9.dp)
                .fillMaxWidth(),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            textAlign = TextAlign.Center
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 38.dp),

            ) {

            Button(
                onClick = {
                    navController.navigate("login")
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
                Text(text = stringResource(id = R.string.lbl_sign_in), color = Color.Black, style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp, fontWeight = FontWeight.SemiBold))
            }

            Button(
                onClick = {
                    navController.navigate("signup")
                },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFDAC0A3)
                ),
                contentPadding = PaddingValues(14.dp)
            ) {
                Text(text = stringResource(id = R.string.lbl_sign_up), color = Color.Black, style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp, fontWeight = FontWeight.SemiBold))
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
                    .padding(bottom = 24.dp), // Adjust the padding as needed
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.msg_or_continue_with),
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(10.dp))

                Row {
                    Image(
                        painter = painterResource(id = R.drawable.ic_google),
                        modifier = Modifier
                            .size(23.dp)
                            .clickable { navController.navigate("home") },
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_facebook),
                        modifier = Modifier
                            .size(23.dp)
                            .clickable { navController.navigate("home") },
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_linkedin),
                        modifier = Modifier
                            .size(23.dp)
                            .clickable { navController.navigate("home") },
                        contentDescription = null
                    )
                }



            }
        }



    }
}

@Composable
fun SocialMediaButton(
    text: String,

    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFe3e5e9), shape = RoundedCornerShape(10.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFe3e5e9)),
        shape = RoundedCornerShape(10.dp)
    ) {

        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            color = Color.Black,
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp),
            maxLines = 1
        )
    }
}


@Preview
@Composable
fun SignInScreenPreview() {
    OnBoardingScreen(rememberNavController())
}