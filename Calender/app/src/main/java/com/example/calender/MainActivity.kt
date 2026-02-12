package com.example.calender

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calender.ui.theme.CalenderTheme
import com.guru.fontawesomecomposelib.FaIcon
import com.guru.fontawesomecomposelib.FaIcons
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalenderTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                    ) {
                        CalenderHeader()
                        CalenderDayNames()
                        CalenderDayList()
                    }
                }

            }
        }
    }
}

@Composable
fun CalenderHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 20.dp),
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

@Composable
fun CalenderDayNames(modifier: Modifier = Modifier) {
    val namesList = listOf("일", "월", "화", "수", "목", "금", "토")

    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        namesList.forEach {
            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = it,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun CalenderDayList(modifier: Modifier = Modifier) {
    val time = remember { mutableStateOf(Calendar.getInstance()) }
    val date = time.value

    // 시간 세팅 (2026년 2월)
    date.set(Calendar.YEAR, 2026)
    date.set(Calendar.MONTH, Calendar.FEBRUARY) // 0: January, 1: February
    date.set(Calendar.DAY_OF_MONTH, 1) // 월의 첫날로 설정해야 첫 번째 요일을 정확히 계산

    // 달력 계산 공식 필요값
    val thisMonthDayMax = date.getActualMaximum(Calendar.DAY_OF_MONTH) // 2월의 마지막 날 (28일)
    val thisMonthFirstDay = date.get(Calendar.DAY_OF_WEEK) - 1 // 2026년 2월 1일의 요일
    val thisMonthWeeksCount = (thisMonthDayMax + thisMonthFirstDay + 6) / 7 // 필요한 주 수

    Column(
        modifier = modifier
    ) {
        repeat(thisMonthWeeksCount) { week ->
            Row() {
                repeat(7) { day ->
                    val resultDay = week * 7 + day - thisMonthFirstDay + 1

                    if (resultDay in 1..thisMonthDayMax) {
                        // 달력 날짜 범위 내
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(60.dp)
                                .border(1.dp, Color.Gray)
                        ) {
                            Text(
                                text = resultDay.toString(),
                                fontSize = 14.sp
                            )
                        }
                    } else {
                        // 범위 밖
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(60.dp)
                                .border(1.dp, Color.Gray)
                        ) {

                        }
                    }
                }
            }

        }
    }

}