package com.example.rulegame.rule_screen

import android.graphics.Color
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rulegame.ui.theme.Reed
import com.example.rulegame.ui.theme.White1
import com.example.rulette.R
import com.example.rulette.utils.numberUtil
import kotlin.math.roundToInt

@Composable
fun RuleScreen() {

    var rotationValue by remember {
        mutableStateOf(0f)
    }

    var number by remember {
        mutableStateOf(0)
    }

    val angle: Float by animateFloatAsState(
        targetValue = rotationValue,
        animationSpec = tween(
            durationMillis = 2976,
        ),
        finishedListener = {
            val index = (360f - (it % 360)) / (360f / 37)
            number = numberUtil.list[index.roundToInt()]
        }
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .wrapContentWidth()
                .wrapContentHeight(),
            text = number.toString(),
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
            color = White1
        
        )
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxSize()){
            Image(
                painter = painterResource(id = R.drawable.ruleta),
                contentDescription = "Ruletta",
                modifier = Modifier
                    .fillMaxSize()
                    .rotate(angle)
            )
            Image(
                painter = painterResource(id = R.drawable.flecha),
                contentDescription = "Flecha",
                modifier = Modifier.fillMaxSize()
            )
        }
        Button(
            onClick = {
                      rotationValue = (2520..3240).random().toFloat() + angle

            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Reed),
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)

        ) {


            Text(
                text = "Start",
                color = White1
            )
        }



    }
}