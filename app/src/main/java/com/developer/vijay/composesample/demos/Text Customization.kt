package com.developer.vijay.composesample.demos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developer.vijay.composesample.R
import com.developer.vijay.composesample.ui.theme.ComposeSampleTheme

@Composable
fun TextCustomization() {
    Text(
        text = stringResource(id = R.string.long_text),
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .fillMaxWidth()
            .padding(8.dp),
        color = Color.White,
        fontSize = MaterialTheme.typography.h6.fontSize,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Justify
    )
}

@Composable
fun TextCustomization2() {  // Annotated String
    Text(
        buildAnnotatedString {
            withStyle(ParagraphStyle(TextAlign.Center)) {
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.primary,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("A")
                }
                append("B")
                append("C")
                append("D")
            }
        }
    )
}

@Composable
fun TextCustomization3() {  // Repeat text
    Text(
        text = stringResource(id = R.string.app_name).repeat(20),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}