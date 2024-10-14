package com.example.fooddelivery.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fooddelivery.R
import com.example.fooddelivery.ui.theme.cart

@Composable
fun CartScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 50.dp)
    ) {
        // Bouton de retour
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24), // Remplace par l'icône de retour appropriée
                contentDescription = "Retour",
                tint = Color.Black // Change la couleur de l'icône si nécessaire
            )
        }
        Text(text = "Panier", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        // Afficher les articles du panier
        if (cart.isEmpty()) {
            Text(text = "Votre panier est vide.", fontSize = 18.sp)
        } else {
            // Grouper les articles par nom et calculer la quantité
            val groupedCart = cart.groupingBy { it.name }
                .eachCount() // Retourne un Map<NomDuProduit, Quantité>

            groupedCart.forEach { (productName, quantity) ->
                // Trouver le prix du premier élément correspondant au produit (supposons que le prix est toujours le même pour un produit donné)
                val item = cart.find { it.name == productName }
                val itemPrice = item?.price ?: 0.0
                val totalPrice = itemPrice * quantity

                // Afficher le nom, la quantité et le prix total du produit
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "$productName : Quantité = $quantity", fontSize = 18.sp)
                    Text(text = String.format("%.0f", totalPrice) + " fr", fontSize = 18.sp)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Calculer le total général
            val total = cart.sumOf { it.price }.toInt()
            Text(text = "Total: $total fr", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}
