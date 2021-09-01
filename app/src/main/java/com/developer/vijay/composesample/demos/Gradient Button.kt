package com.developer.vijay.composesample.demos

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.developer.vijay.composesample.MainActivity.Companion.TAG
import com.developer.vijay.composesample.ui.theme.ComposeSampleTheme

@Composable
fun GradientButton(
    buttonText: String = "Save",
    brush: Brush,
    onClick: () -> Unit
) {
    Button(
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        contentPadding = PaddingValues()
    ) {
        Box(
            modifier = Modifier
                .background(brush = brush)
                .padding(horizontal = 24.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center

        ) {
            Text(text = buttonText)
        }
    }
}

@Preview
@Composable
fun GradientButtonPreview() {
    ComposeSampleTheme {
        // A surface container using the 'background' color from the theme
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GradientButton(brush = Brush.horizontalGradient(listOf(Color.Green, Color.Yellow))) {
                Log.d(TAG, "GradientButton: onClick")
            }
        }
    }
}