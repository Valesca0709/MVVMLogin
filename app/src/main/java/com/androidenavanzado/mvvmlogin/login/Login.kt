package com.androidenavanzado.mvvmlogin.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidenavanzado.mvvmlogin.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


private val auth by lazy {
    Firebase.auth
}



@Composable
fun LoginScreen(onClickLogin: () -> Unit) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Login(Modifier.align(Alignment.Center), onClickLogin)
    }

}

@Composable
fun Login(modifier: Modifier, onClickLogin: () -> Unit) {
    Column(modifier = modifier) {
        HeaderImage()
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_16)))
        EmailFied()
        Spacer(modifier = Modifier.padding(4.dp))
        PasswordLogin()
        Spacer(modifier = Modifier.padding(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.padding(4.dp))
        LoginButton(onClickLogin)

    }

}



@Composable
fun LoginButton(onClickLogin: () -> Unit) {
    Button(onClick = {
        onClickLogin.invoke()
    }, modifier = Modifier
        .fillMaxWidth()
        .height(48.dp),
        colors= ButtonDefaults.buttonColors( backgroundColor = Color(0xFFFF4303),
        disabledBackgroundColor = Color(0xFFF78058),
            contentColor = Color.White, disabledContentColor = Color.White)) {
        Text(text="Iniciar sesión")
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(text = "¿Olvidaste la contraseña?",
        modifier = modifier.clickable { },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xDAFB9600)

   )
}


@Composable
fun PasswordLogin() {
    var password = remember{mutableStateOf("")}
    TextField(
        value = password.value , onValueChange = {password.value = it},
        modifier = Modifier.fillMaxWidth(),
        placeholder = {Text(text = "Contraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true, // el campo entra en una sola línea
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors
            (
            textColor = Color(0xFF636262),
            backgroundColor = Color(0xFFDEDDDD),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EmailFied() {
    var email = remember{mutableStateOf("")}
    TextField(
        value = email.value , onValueChange = {email.value = it},
        modifier = Modifier.fillMaxWidth(),
        placeholder = {Text(text = "Email")}, // se informa que debe hacer el usuario
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true, // el campo entra en una sola línea
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors
            (
            textColor = Color(0xFF636262),
            backgroundColor = Color(0xFFDEDDDD),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun HeaderImage() {
    Image(
        painter = painterResource(id = R.drawable.programadora_final),
        contentDescription = "logo de Mobdev"
    )



}





