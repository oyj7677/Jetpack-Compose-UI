package com.example.simplechart

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import java.text.NumberFormat

@Composable
fun Ex1_8() {

    var resultMoney by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        val animateMoney by animateIntAsState(
            targetValue = resultMoney,
            animationSpec = tween(3000)
        )

        LaunchedEffect(true) {
            resultMoney = 100000000
        }

        val formattedResultMoney = NumberFormat.getNumberInstance().format(animateMoney)

        Text(
            text = "$formattedResultMoney 원",
            fontSize = 50.sp
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun Ex1_8_Preview() {
    Ex1_8()
}