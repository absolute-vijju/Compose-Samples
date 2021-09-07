package com.developer.vijay.composesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import com.developer.vijay.composesample.demos.*
import com.developer.vijay.composesample.ui.theme.ComposeSampleTheme

class MainActivity : ComponentActivity() {

    companion object {
        const val TAG = "mydata"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSampleTheme {
                // A surface container using the 'background' color from the theme
                MyCanvas()
            }
        }
    }
}
