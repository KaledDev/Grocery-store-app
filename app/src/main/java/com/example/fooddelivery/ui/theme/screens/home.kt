package com.example.fooddelivery.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fooddelivery.R
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(500) // 3 secondes avant de naviguer
        navController.navigate("welcome") {
            popUpTo("splash") { inclusive = true }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
    val svgPainter = painterResource(id = R.drawable.group_60)

        Image(
            painter = svgPainter,
            contentDescription = null,
            modifier = Modifier
                .size(300.dp) // Taille de l'image
                .align(Alignment.Center) // Centre l'image dans l'écran
        )
    }
}
