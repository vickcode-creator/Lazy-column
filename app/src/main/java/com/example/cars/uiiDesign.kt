package com.example.cars

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Design(check: carsAndDetails){

    var expand = remember {
        mutableStateOf(false)
    }
    val extrapadding by animateDpAsState(
        if (expand.value) 24.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )


    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Card (modifier = Modifier
            .width(400.dp)
            .height(300.dp)
            .background(Color.Red),
            elevation = CardDefaults.cardElevation(10.dp)
        ){
            Column(modifier = Modifier
                .fillMaxSize()
                .background(Color.Magenta)
            ) {
                Image(painter = painterResource(id = check.cars), contentDescription = "",
                    modifier = Modifier
                        .width(400.dp)
                        .height(200.dp))
                Text(text = "CALL: O1717372882", fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight(12),
                    fontFamily = FontFamily.Monospace

                )
                Spacer(modifier = Modifier.height(5.dp))


                OutlinedButton(onClick = { expand.value =! expand.value }
               ) {
                    Text(if (expand.value) "Show Less" else "Show More")
                }

            }


        }
        if (expand.value){

            Column(modifier = Modifier
                .padding(bottom = extrapadding.coerceAtLeast(0.dp))
                .background(Color.Green)) {
                Text(text = check.carDetails)

            }

        }

    }

}


