package com.example.financialapp.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.financialapp.ui.theme.FinancialAppTheme
import com.guru.fontawesomecomposelib.FaIcon
import com.guru.fontawesomecomposelib.FaIcons

@Composable
fun MainScreen() {

    FaIcon(
        faIcon = FaIcons.ChartBarRegular,
        size = 50.dp,
        tint = Color.Red
    )
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    FinancialAppTheme {
        MainScreen()
    }
}