package com.example.airpollutionapplication.ui.theme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.airpollutionapp.ui.screens.WeatherState

@Composable
fun AirPollutionScreen(
    modifier: Modifier = Modifier, state: WeatherState,
) {
    var isOpen :Boolean by remember{ mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxWidth()
        ) {
            Text(
                text = "AIR POLLUTION DATA",
                fontSize = 30.sp,
                fontWeight = FontWeight.Black,
                fontFamily = FontFamily.Cursive
            )
            Button(onClick = {isOpen = true}) {
                Text(text = "Click", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
            }
        }
        Spacer(modifier = modifier.padding(20.dp))
        Button(onClick = {isOpen = true}) {
            Text(text = "Click Here")
        }
        if (isOpen) {
            Column {
                Text(text = "${state.result.list}")
            }
        }

    }
}