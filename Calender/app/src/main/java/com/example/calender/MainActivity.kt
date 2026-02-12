package com.example.calender

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calender.ui.theme.CalenderTheme
import com.guru.fontawesomecomposelib.FaIcon
import com.guru.fontawesomecomposelib.FaIcons

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalenderTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    CalenderHeader(
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }

        }
    }
}

    @Composable
    fun CalenderHeader(modifier: Modifier = Modifier) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top  = 20.dp, bottom = 20.dp),
            horizontalArrangement = Arrangement.End
        ) {
            FaIcon(
                faIcon = FaIcons.Cog,
                size = 30.dp,
                tint = Color.Gray,
                modifier = Modifier.padding(end = 10.dp)
            )

            FaIcon(
                faIcon = FaIcons.Bell,
                size = 30.dp,
                tint = Color.Gray,
                modifier = Modifier.padding(end = 10.dp)
            )

            FaIcon(
                faIcon = FaIcons.Bars,
                size = 30.dp,
                tint = Color.Gray,
                modifier = Modifier.padding(end = 10.dp)
            )
        }
    }
}
