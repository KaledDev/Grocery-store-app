package com.example.fooddelivery.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.provider.FontsContractCompat.Columns
import androidx.navigation.NavController
import com.example.fooddelivery.R
import com.example.fooddelivery.ui.theme.poppinsFontFamily

@Composable
fun welcomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        // Première moitié : Image avec fond orange
        Box(
            modifier = Modifier
                .weight(1f) // Prend la moitié de l'écran
                .background(Color(0xFFFFA451)) // Fond orange
        ) {
            val image: Painter = painterResource(id = R.drawable.imgbin_basket_of_fruit_cartoon_fruits_basket_still_life_illustration_zt8c0qvnxl2hba3bbdz73amjr_removebg_preview__1__1)
            Image(
                painter = image,
                contentDescription = "Image d'accueil",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp) // Ajoute un padding autour de l'image
            )
        }
        // Deuxième moitié : Titre, description et bouton
        Column(
            modifier = Modifier
                .weight(1f) // Prend la moitié restante de l'écran
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Titre
            Text(
                text = "Découvrez notre application avec une variété de fruits frais.",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    fontFamily = poppinsFontFamily
                ),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp)) // Espace entre le titre et la description

            // Description
            Text(
                text = "Nous livrons la meilleure et la plus fraîche salade de fruits en ville. Commandez un combo aujourd'hui !!!",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Thin,
                    color = Color.Gray,
                    fontFamily = poppinsFontFamily
                ),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp)) // Espace entre la description et le bouton

            // Bouton
            Button(
                onClick = { navController.navigate("authentification") },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFFFA500)),// Fond orange du bouton
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFA500), // Fond orange du bouton
                    contentColor = Color.White // Texte blanc
                )
            ) {
                Text(
                    text = "Continuer",
                    color = Color.White // Texte blanc
                )
            }
        }
    }
}
