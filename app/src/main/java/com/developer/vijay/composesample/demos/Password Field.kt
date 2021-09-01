package com.developer.vijay.composesample.demos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.Placeholder
import com.developer.vijay.composesample.R
import com.developer.vijay.composesample.ui.theme.ComposeSampleTheme

@Composable
fun PasswordField(
    label: String = "Password",
    placeholderText: String = "Password",
    onClickEyeButton: () -> Unit
) {
    var password by rememberSaveable { mutableStateOf("") }
    var isPasswordIconClicked by remember {
        mutableStateOf(false)
    }
    var painter =
        if (isPasswordIconClicked) painterResource(id = R.drawable.ic_password_show) else painterResource(
            id = R.drawable.ic_passoword_hide
        )


    OutlinedTextField(
        value = password,
        onValueChange = {
            password = it
        },
        placeholder = {
            Text(text = placeholderText)
        },
        label = {
            Text(text = label)
        },
        trailingIcon = {
            IconButton(onClick = {
                isPasswordIconClicked = !isPasswordIconClicked
                onClickEyeButton()
            }) {
                Icon(
                    painter = painter,
                    contentDescription = "Password Icon",
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        visualTransformation = if (isPasswordIconClicked) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

@Preview
@Composable
fun PasswordFieldPreview() {
    ComposeSampleTheme {
        // A surface container using the 'background' color from the theme
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PasswordField {

            }
        }
    }
}