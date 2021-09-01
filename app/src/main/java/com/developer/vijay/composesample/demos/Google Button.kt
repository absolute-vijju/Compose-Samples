package com.developer.vijay.composesample.demos

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.developer.vijay.composesample.MainActivity.Companion.TAG
import com.developer.vijay.composesample.R
import com.developer.vijay.composesample.ui.theme.Shapes
import com.google.android.material.progressindicator.BaseProgressIndicator

@ExperimentalMaterialApi
@Composable
fun GoogleButton(
    initialText: String = "Sign Up with Google",
    loadingText: String = "Creating an Account...",
    icon: Painter = painterResource(id = R.drawable.ic_google_logo),
    shape: Shape = Shapes.medium,
    borderColor: Color = Color.LightGray,
    backgroundColor: Color = MaterialTheme.colors.surface,
    progressIndicatorColor: Color = MaterialTheme.colors.primary,
    onClick: () -> Unit
) {
    var clicked by remember {
        mutableStateOf(false)
    }

    Surface(
        onClick = {
            clicked = !clicked
            onClick()
        },
        shape = shape,
        border = BorderStroke(1.dp, borderColor),
        color = backgroundColor
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp, 16.dp, 12.dp, 12.dp)
                .animateContentSize(
                    tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = icon,
                contentDescription = "Google Logo",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = if (clicked) loadingText else initialText)
            if (clicked) {
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier.size(16.dp),
                    strokeWidth = 2.dp,
                    color = progressIndicatorColor
                )
            }
        }
    }

}

@ExperimentalMaterialApi
@Preview
@Composable
fun GoogleButtonPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GoogleButton {
            Log.d(TAG, "GoogleButton: onClick")
        }
    }
}