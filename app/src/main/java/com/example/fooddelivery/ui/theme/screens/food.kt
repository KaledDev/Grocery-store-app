
package com.example.fooddelivery.ui.theme.screens
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.fooddelivery.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavController
import androidx.compose.ui.Alignment
import com.example.fooddelivery.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun food(navController: NavController) {
    var search by remember { mutableStateOf("") }

    // Utilisation de LazyColumn pour le défilement vertical
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
                Row(
                    modifier = Modifier
                        .clickable(onClick = { navController.navigate("cart") }) // Redirige vers le panier
                        .padding(16.dp) // Ajoute un peu d'espacement
                        .fillMaxWidth(), // Fait en sorte que la ligne occupe toute la largeur
                    horizontalArrangement = Arrangement.End // Aligne l'image et le texte à droite
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.vector),
                        contentDescription = "Icon de panier",
                        modifier = Modifier
                            .size(30.dp)
                            .padding(end = 8.dp) // Ajoute un petit espacement entre l'image et le texte
                    )
                    Text(
                        text = "Mon panier",
                        fontFamily = poppinsFontFamily,
                        modifier = Modifier.align(Alignment.CenterVertically) // Aligne verticalement le texte avec l'image
                    )
                }



            // Texte de bienvenue
            Text(
                text = "Bienvenue, quel  fruit voulez-vous\naujourd'hui ?",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.W400,
                fontSize = 20.sp,
                color = Color(0xFF27214D)
            )

            // Champ de recherche
            OutlinedTextField(
                value = search,
                onValueChange = { search = it },
                placeholder = { Text(text = "Chercher un fruit", color = Color.Gray) },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_search_24),
                        contentDescription = "Search Icon",
                        tint = Color.Gray
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(30.dp))
                    .padding(vertical = 16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFFF3F4F9),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                singleLine = true,
                textStyle = TextStyle(
                    color = Color.Black,
                    fontFamily = poppinsFontFamily
                )
            )
        }
        // Ajouter une liste d'éléments de nourriture
        items(foodItems) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                onClick = {
                    // Navigation vers l'écran de détails du fruit
                    navController.navigate("fruitDetails/${item.name}")
                }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = item.imageRes),
                        contentDescription = item.name,
                        modifier = Modifier.size(80.dp)
                    )

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 16.dp)
                    ) {
                        Text(
                            text = item.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.Black,
                            fontFamily = poppinsFontFamily
                        )

                        Text(
                            text = String.format("%.0f", item.price) + "fr",
                            fontSize = 16.sp,
                            color = Color.Gray,
                            fontFamily = poppinsFontFamily
                        )
                    }

                    // Bouton pour afficher plus de détails
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                        contentDescription = "Détails",
                        tint = Color.Gray,
                        modifier = Modifier
                            .size(24.dp)
                            .padding(end = 8.dp)
                    )
                }
            }
        }
    }
}