package com.example.simplechart

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Ex1_11() {
    val items = listOf(
        ChartModel(fraction = 0.5f, color = Color.Red),
        ChartModel(fraction = 0.2f, color = Color.Green),
        ChartModel(fraction = 0.3f, color = Color.Black)
    )

    var animationProgress by remember { mutableStateOf(0f) }

    val animationState by animateFloatAsState(
        targetValue = animationProgress,
        animationSpec = tween(durationMillis = 1500, easing = LinearOutSlowInEasing)
    )

    LaunchedEffect(Unit) {
        animationProgress = 1f
    }


    var startAngle = 0f
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier.size(300.dp)
        ) {
            items.forEach {

                val fraction = (it.fraction * 100).toInt().toString() + "%"

                Canvas(
                    modifier = Modifier.fillMaxSize()
                ) {
                    drawArc(
                        color = it.color,
                        startAngle = startAngle,
                        sweepAngle = 360 * animationState * it.fraction,
                        useCenter = true,
                        size = Size(size.width, size.height),
                        style = Fill
                    )

                    val paint = Paint().asFrameworkPaint().apply {
                        color = android.graphics.Color.BLUE
                        textSize = 60f
                    }

                    val midPosition = startAngle + it.fraction * 180 // 중앙에 위치
                    val radiusPosition = size.width * 0.5f * 0.5f // 원 중앙에서 얼마나 떨어지는지

                    val xPosion = (radiusPosition * kotlin.math.cos(midPosition * (Math.PI / 180))).toFloat() + size.width * 0.5f // x 좌표
                    val yPosition = (radiusPosition * kotlin.math.sin(midPosition * (Math.PI / 180))).toFloat() + size.height * 0.5f // y 좌표

                    val textWidth = paint.measureText(it.fraction.toString())
                    val textHeight = paint.descent() - paint.ascent()

                    val xPositionChanged = xPosion - textWidth * 0.5f
                    val yPositionChanged = yPosition + textHeight * 0.5f

                    drawIntoCanvas {
                        it.nativeCanvas.drawText(fraction, xPositionChanged, yPositionChanged, paint)
                    }
                    startAngle += it.fraction * 360f

                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun Ex1_11_Preview() {
    Ex1_11()
}