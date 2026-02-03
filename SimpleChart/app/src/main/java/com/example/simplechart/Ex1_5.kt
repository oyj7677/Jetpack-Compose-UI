package com.example.simplechart

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simplechart.ui.theme.SimpleChartTheme

@Composable
fun Ex1_5() {

    val barDataList = listOf(0.2f, 0.4f, 0.6f, 0.8f, 1.0f)
    val fullWidth = 320.dp

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            barDataList.forEach {

                var resultWidth by remember { mutableStateOf(0.dp) }

                val animateWidth by animateDpAsState(
                    targetValue = resultWidth,
                    animationSpec = tween(durationMillis = 3000, easing = FastOutSlowInEasing)
                )

                LaunchedEffect(true) {
                    resultWidth = fullWidth * it
                }

                Row() {
                    Box(
                        modifier = Modifier
                            .width(animateWidth)
                            .height(30.dp)
                            .background(Color.Black, shape = RoundedCornerShape(topEnd = 15.dp, bottomEnd = 15.dp))
                    ) {

                    }

                    Text(
                        text = "${(it * 100).toInt()}%",
                        modifier = Modifier.padding(top = 3.dp, start = 10.dp),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
private fun Ex1_5_Preview() {
    SimpleChartTheme {
        Ex1_5()
    }
}