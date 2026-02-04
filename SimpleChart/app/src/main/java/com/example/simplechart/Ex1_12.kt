package com.example.simplechart

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Ex1_12(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier.padding(20.dp)
    ) {

        var sliderProgress by remember { mutableStateOf(0.5f) }

        Slider(
            value = sliderProgress,
            onValueChange = {
                sliderProgress = it
            },
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                activeTickColor = Color.Black,
                inactiveTickColor = Color.Gray
            )
        )

        SliderCircle(sliderProgress)
    }
}

@Composable
fun SliderCircle(sliderProgress: Float) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        contentAlignment = Alignment.Center
    ) {

        Canvas(
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
        ) {
            // 회색 겉의 원
            drawArc(
                brush = SolidColor(Color.Gray),
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(35f)
            )
            val sliderChangedProgress = sliderProgress * 360

            // 검정 안의 원
            drawArc(
                brush = SolidColor(Color.Black),
                startAngle = 0f,
                sweepAngle = sliderChangedProgress,
                useCenter = false,
                style = Stroke(35f, cap = StrokeCap.Round)
            )
        }


        Text(
            text = "${(sliderProgress * 100).toInt()}%",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun Ex1_12_Preview() {
    Ex1_12()
}