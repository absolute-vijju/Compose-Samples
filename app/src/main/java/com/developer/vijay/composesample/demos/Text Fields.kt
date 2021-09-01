package com.developer.vijay.composesample.demos

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.developer.vijay.composesample.MainActivity.Companion.TAG
import com.developer.vijay.composesample.R
import com.developer.vijay.composesample.ui.theme.ComposeSampleTheme

@Composable
fun TextFields1() {
    var typedString by remember {
        mutableStateOf("Start typing...")
    }
    OutlinedTextField(
        value = typedString,
        onValueChange = {
            typedString = it
        },
        modifier = Modifier.fillMaxWidth(),
        enabled = true,
        readOnly = false,
        singleLine = false,
//        maxLines = 2,
        label = {
            Text(text = stringResource(id = R.string.title))
        },
        leadingIcon = {
            IconButton(onClick = {
                Log.d(TAG, "leadingIcon onClick")
            }) {
                Icon(imageVector = Icons.Filled.Email, contentDescription = "Email")
            }
        },
        trailingIcon = {
            IconButton(onClick = {
                Log.d(TAG, "trailingIcon onClick")
            }) {
                Icon(imageVector = Icons.Filled.CheckCircle, contentDescription = "Check")
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            Log.d(TAG, "keyboardActions onDone")
        })
    )
}


@Preview(showBackground = true)
@Composable
fun TextFieldsPreview() {
    ComposeSampleTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                verticalArrangement = Arrangement.Center
            ) {
                TextFields1()
            }
        }
    }

}