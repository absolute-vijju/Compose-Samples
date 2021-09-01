package com.developer.vijay.composesample.demos

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.developer.vijay.composesample.R
import com.developer.vijay.composesample.ui.theme.ComposeSampleTheme

@ExperimentalCoilApi
@Composable
fun Coil() {
    Box(
        modifier = Modifier
            .size(150.dp),
        contentAlignment = Alignment.Center,
    ) {
        val painter = rememberImagePainter("https://avatars.githubusercontent.com/u/53289959?v=4",
            builder = {
                crossfade(1000)
                transformations(CircleCropTransformation())
                placeholder(R.drawable.placeholder)
                error(R.drawable.error)
            })

        val painterState = painter.state
        Image(painter = painter, contentDescription = "Image from URL")

        /*if (painterState is ImagePainter.State.Loading)
            CircularProgressIndicator()*/
    }
}

@ExperimentalCoilApi
@Preview
@Composable
fun CoilPreview() {
    ComposeSampleTheme {
        // A surface container using the 'background' color from the theme
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Coil()
        }
    }
}