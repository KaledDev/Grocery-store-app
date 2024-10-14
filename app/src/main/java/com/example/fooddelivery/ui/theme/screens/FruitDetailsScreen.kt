package com.example.fooddelivery.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material3.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.fooddelivery.R
import com.example.fooddelivery.ui.theme.cart
import com.example.fooddelivery.ui.theme.poppinsFontFamily


@Composable
fun FruitDetailsScreen(navController: NavController, fruit: foodItem) {
    // État pour la quantité
    var quantity by remember { mutableStateOf(1) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
    ) {

        // Box pour gérer le background et l'image
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.5f) // Donne plus de poids à l'image pour qu'elle prenne plus de place
                .background(Color(0xFFF3F5F7)) // Couleur d'arrière-plan ajoutée
                .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)) // Coins arrondis en bas
        ) {
            // Bouton de retour
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.padding(bottom = 16.dp).offset(0.dp , 20.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_24), // Remplace par l'icône de retour appropriée
                    contentDescription = "Retour",
                    tint = Color.Black // Change la couleur de l'icône si nécessaire
                )
            }
            // Image du fruit en grand
            Image(
                painter = painterResource(id = fruit.imageRes),
                contentDescription = fruit.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp) // Augmente la hauteur de l'image
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 32.dp,
                            bottomEnd = 32.dp
                        )
                    ) // Coins arrondis en bas
                    .align(Alignment.Center) // Centre l'image dans la Box
            )
        }

        // Deuxième moitié pour les détails
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ) {
            // Nom du fruit
            Text(
                text = fruit.name,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color(0xFF27214D),
                modifier = Modifier.padding(vertical = 8.dp),
                fontFamily = poppinsFontFamily
            )

            // Prix
            Text(
                text = "Prix: " + String.format("%.0f", fruit.price) + "fr",
                fontSize = 20.sp,
                color = Color.Gray,
                fontFamily = poppinsFontFamily
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Quantité ajustable avec boutons + et -
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Quantité :", fontSize = 18.sp)

                Row(
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { if (quantity > 1) quantity-- },
                        modifier = Modifier
                            .clip(RoundedCornerShape(50))
                            .background(Color(0xFFFFA500)),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0XFFFFA500),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "-", fontSize = 20.sp)
                    }

                    // Quantité affichée
                    Text(
                        text = quantity.toString(),
                        modifier = Modifier.padding(horizontal = 16.dp),
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = { quantity++ },
                        modifier = Modifier
                            .clip(RoundedCornerShape(50))
                            .background(Color(0xFFFFA500)),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0XFFFFA500),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "+", fontSize = 20.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Bouton Ajouter au panier
            Button(
                onClick = {
                    repeat(quantity) {
                        cart.add(fruit)
                    }
                    // Navigue vers l'écran du panier après avoir ajouté l'élément
                    navController.navigate("cart")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFFFA500)),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0XFFFFA500),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Ajouter au panier", fontSize = 18.sp)
            }
        }
    }
}
