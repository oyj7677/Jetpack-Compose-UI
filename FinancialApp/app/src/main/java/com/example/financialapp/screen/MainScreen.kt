package com.example.financialapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.financialapp.ui.theme.FinancialAppTheme
import com.guru.fontawesomecomposelib.FaIcon
import com.guru.fontawesomecomposelib.FaIcons

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.Black)
    ) {
        Header()
        TopMenu()
        TopMenuBottom()
        SpendThisMonth()
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        FaIcon(
            faIcon = FaIcons.ArrowLeft,
            tint = Color.White,
            modifier = Modifier.padding(20.dp)

        )
        FaIcon(
            faIcon = FaIcons.Plus,
            tint = Color.White,
            modifier = Modifier.padding(20.dp)
        )
    }
}

@Composable
fun TopMenu() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
    ) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "자산",
                color = Color.Gray,
                fontSize = 16.sp
            )
        }

        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "소비·수입",
                color = Color.White,
                fontSize = 16.sp
            )
        }

        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "연말 정산",
                color = Color.Gray,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun TopMenuBottom() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
    ) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {

        }

        Box(
            modifier = Modifier
                .weight(1f)
                .padding(top = 15.dp, start = 5.dp, end = 5.dp)
                .height(2.dp)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {

        }

        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {

        }
    }
}

@Composable
fun SpendThisMonth() {
    Row(
        modifier = Modifier
            .padding(10.dp)
    ) {
        FaIcon(
            faIcon = FaIcons.CaretLeft,
            tint = Color.White,
            modifier = Modifier.padding(start = 10.dp, top = 1.5.dp, end = 5.dp)
        )

        Text(
            text = "11월 소비",
            color = Color.White,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp),
            textDecoration = TextDecoration.Underline
        )

        FaIcon(
            faIcon = FaIcons.CaretRight,
            tint = Color.White,
            modifier = Modifier.padding(start = 5.dp, top = 1.5.dp, end = 5.dp)
        )
    }

    Text(
        text = "1,000,000원",
        color = Color.White,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 20.dp)
    )

    Text(
        text = "계좌에서 쓴 금액 포함",
        color = Color.Gray,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 20.dp, top = 10.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    FinancialAppTheme {
        MainScreen()
    }
}