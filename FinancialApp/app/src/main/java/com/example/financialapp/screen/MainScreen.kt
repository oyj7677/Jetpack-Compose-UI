package com.example.financialapp.screen

import android.util.Log
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.financialapp.R
import com.example.financialapp.animation.TextAnimation
import com.example.financialapp.ui.theme.FinancialAppTheme
import com.guru.fontawesomecomposelib.FaIcon
import com.guru.fontawesomecomposelib.FaIcons

private const val TAG = "MainScreen"

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
        SendThisMonthProgressBar()
        SpendThisMonthCategoryList()
        SpaceGray()
        SpendGraphHeader()
        SpendGraph()
        SpaceGray()
        SpendThisMonthInsuranceHeader()
        SpendThisMonthInsuranceGraph()
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

    TextAnimation(
        targetValue = 1000000,
        textColor = Color.White,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        padding = PaddingValues(start = 20.dp)
    )

    Text(
        text = "계좌에서 쓴 금액 포함",
        color = Color.Gray,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 20.dp, top = 10.dp)
    )
}

@Composable
fun SendThisMonthProgressBar() {

    var startAnimation by remember { mutableStateOf(false) }

    val weightList = listOf(7f, 1f, 1f, 1f)
    val colorList = listOf(Color.Red, Color.Gray, Color.Blue, Color.Green)

    val animatedWeights = weightList.map {
        animateFloatAsState(
            targetValue = if (startAnimation) it else 0.1f,
            animationSpec = tween(durationMillis = 3000)
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 20.dp, end = 20.dp)
    ) {
        animatedWeights.forEachIndexed { index, state ->
            Box(
                modifier = Modifier
                    .padding(end = 5.dp)
                    .weight(state.value)
                    .height(30.dp)
                    .background(
                        color = colorList[index],
                        shape = when (index) {
                            0 -> RoundedCornerShape(topStart = 5.dp, bottomStart = 5.dp)
                            3 -> RoundedCornerShape(topEnd = 5.dp, bottomEnd = 5.dp)
                            else -> RectangleShape
                        }
                    ),
            ) {

            }
        }

    }
    LaunchedEffect(Unit) {
        startAnimation = true
    }


//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(top = 20.dp, start = 20.dp, end = 20.dp)
//    ) {
//        Box(
//            modifier = Modifier
//                .padding(end = 5.dp)
//                .weight(7f)
//                .height(30.dp)
//                .background(Color.Red, shape = RoundedCornerShape(topStart = 5.dp, bottomStart = 5.dp)),
//        ) {
//
//        }
//
//        Box(
//            modifier = Modifier
//                .padding(end = 5.dp)
//                .weight(1f)
//                .height(30.dp)
//                .background(Color.Gray),
//        ) {
//
//        }
//
//        Box(
//            modifier = Modifier
//                .padding(end = 5.dp)
//                .weight(1f)
//                .height(30.dp)
//                .background(Color.Blue),
//        ) {
//
//        }
//
//        Box(
//            modifier = Modifier
//                .padding(end = 5.dp)
//                .weight(1f)
//                .height(30.dp)
//                .background(Color.Green, shape = RoundedCornerShape(topEnd = 5.dp, bottomEnd = 5.dp)),
//        ) {
//
//        }
//    }
}

@Composable
fun SpendThisMonthCategoryList() {
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = (Arrangement.SpaceBetween),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.Red, shape = RoundedCornerShape(20.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.category1),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier.size(25.dp)
                    )
                }

                Column(
                    modifier = Modifier.padding(start = 50.dp)
                ) {
                    Text(
                        text = "이체",
                        color = Color.White,
                    )
                    Text(
                        text = "70%",
                        color = Color.White,
                    )
                }
            }
            Text(
                text = "700,000원",
                color = Color.LightGray,
                fontWeight = FontWeight.Bold
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = (Arrangement.SpaceBetween),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.Gray, shape = RoundedCornerShape(20.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.category2),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier.size(25.dp)
                    )
                }

                Column(
                    modifier = Modifier.padding(start = 50.dp)
                ) {
                    Text(
                        text = "송금",
                        color = Color.White,
                    )
                    Text(
                        text = "10%",
                        color = Color.White,
                    )
                }
            }
            Text(
                text = "100,000원",
                color = Color.LightGray,
                fontWeight = FontWeight.Bold
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = (Arrangement.SpaceBetween),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.Blue, shape = RoundedCornerShape(20.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.category3),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier.size(25.dp)
                    )
                }

                Column(
                    modifier = Modifier.padding(start = 50.dp)
                ) {
                    Text(
                        text = "저금",
                        color = Color.White,
                    )
                    Text(
                        text = "10%",
                        color = Color.White,
                    )
                }
            }
            Text(
                text = "100,000원",
                color = Color.LightGray,
                fontWeight = FontWeight.Bold
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = (Arrangement.SpaceBetween),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.Green, shape = RoundedCornerShape(20.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.category4),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier.size(25.dp)
                    )
                }

                Column(
                    modifier = Modifier.padding(start = 50.dp)
                ) {
                    Text(
                        text = "월세",
                        color = Color.White,
                    )
                    Text(
                        text = "10%",
                        color = Color.White,
                    )
                }
            }
            Text(
                text = "100,000원",
                color = Color.LightGray,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun SpaceGray() {
    Box(
        modifier = Modifier
            .padding(top = 20.dp, bottom = 20.dp)
            .fillMaxWidth()
            .height(10.dp)
            .background(Color.DarkGray)
    )
}

@Composable
fun SpendGraphHeader() {
    Text(
        text = "이번달",
        color = Color.White,
        modifier = Modifier.padding(start = 15.dp)
    )
}

@Composable
fun SpendGraph() {
    val dotPositions = listOf(400f, 300f, 750f, 600f, 800f)
    val dotPositionsNew = listOf(500f, 150f, 300f)

    // 2. 찍은 점이 번쩍전쩍 하기
    val showHideEffect = rememberInfiniteTransition()
    val showHideAnimation = showHideEffect.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000)
        )
    )

    Canvas(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        val width = size.width
        val height = size.height
        Log.d(TAG, "SpendGraph: width: $width, height: $height")
        val maxPosition = dotPositions.max()
        val minPosition = dotPositions.min()

        // x y
        val positionMap = dotPositions.mapIndexed { index, value ->
            val x = (width / (dotPositions.size - 1)) * index
            val y = height - (height * (value - minPosition) / (maxPosition - minPosition))

            x to y
        }


        Log.d(TAG, "SpendGraph: x y positions: $positionMap")
        positionMap.zipWithNext { a, b ->
            drawLine(
                color = Color.Gray,
                start = Offset(a.first, a.second),
                end = Offset(b.first, b.second),
                strokeWidth = 5f,
                cap = Stroke.DefaultCap
            )
        }

        val positionMapNew = dotPositionsNew.mapIndexed { index, value ->
            val x = (width / (dotPositions.size - 1)) * index
            val y = height - (height * (value - minPosition) / (maxPosition - minPosition))

            x to y
        }

        // 새로운 그래프 그리기
        positionMapNew.zipWithNext { a, b ->
            drawLine(
                color = Color.Blue,
                start = Offset(a.first, a.second),
                end = Offset(b.first, b.second),
                strokeWidth = 5f,
                cap = Stroke.DefaultCap
            )
        }

        // 점찍기
        positionMapNew.lastOrNull().let {
            drawCircle(
                color = Color.Blue,
                radius = 13f,
                center = Offset(it?.first ?: 0f, it?.second ?: 0f),
                alpha = showHideAnimation.value
            )
        }
    }

    Spacer(
        modifier = Modifier.padding(20.dp)
    )
}

@Composable
fun SpendThisMonthInsuranceHeader() {

    Text(
        text = "매달 내는 보험료 적절할까요?",
        color = Color.White,
        modifier = Modifier.padding(start = 15.dp)
    )
}

@Composable
fun SpendThisMonthInsuranceGraph() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom
    ) {

        Box(
            modifier = Modifier
                .width(80.dp)
        ) {
            // 왼쪽 박스
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "과잉",
                    color = Color.White
                )

                Box(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .width(60.dp)
                        .height(160.dp)
                        .background(Color.Red)
                )

                Text(
                    text = "600,000원",
                    color = Color.White,
                    modifier = Modifier.padding(top = 20.dp)
                )
            }
        }

        // 오른쪽 박스
        Box(
            modifier = Modifier
                .width(80.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "부족",
                    color = Color.White
                )

                Box(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .width(60.dp)
                        .height(40.dp)
                        .background(Color.Blue)
                )

                Text(
                    text = "???,???원",
                    color = Color.White,
                    modifier = Modifier.padding(top = 20.dp)
                )
            }
        }
    }

    Spacer(
        modifier = Modifier.padding(20.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    FinancialAppTheme {
        MainScreen()
    }
}

