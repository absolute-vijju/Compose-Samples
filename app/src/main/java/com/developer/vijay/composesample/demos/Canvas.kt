package com.developer.vijay.composesample.demos

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyCanvas() {
    Canvas(modifier = Modifier.size(200.dp)) {
        this.drawRect(
            size = size,
            color = Color.LightGray
        )

        this.drawRect(
            topLeft = Offset(100.dp.toPx(), 100.dp.toPx()),
            color = Color.Yellow,
            style = Stroke(3.dp.toPx())
        )

        this.drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(Color.Red, Color.Yellow),
                center = center,
                radius = 100f
            ),
            radius = 50.dp.toPx()
        )

        this.drawArc(
            color = Color.Red,
            startAngle = 0f,
            sweepAngle = 270f,
            useCenter = false,
            topLeft = Offset(10f, 50f),
            size = Size(200f, 200f),
            style = Stroke(3.dp.toPx())
        )

        this.drawArc(
            color = Color.Green,
            startAngle = 0f,
            sweepAngle = 270f,
            useCenter = true,
            topLeft = Offset(230f, 50f),
            size = Size(200f, 200f)
        )

        this.drawOval(
            Color.Magenta,
            topLeft = Offset(100.dp.toPx(), 100.dp.toPx()),
            size = Size(20.dp.toPx(), 40.dp.toPx())
        )

        this.drawLine(
            Color.Cyan,
            start = Offset(size.width, 0f),
            end = Offset(0f, size.height),
            strokeWidth = 2.dp.toPx()
        )

        this.drawLine(
            Color.Cyan,
            start = Offset(0f, 0f),
            end = Offset(size.width, size.height),
            strokeWidth = 2.dp.toPx()
        )
    }
}

@Preview
@Composable
fun CanvasPreview() {
    MyCanvas()
}