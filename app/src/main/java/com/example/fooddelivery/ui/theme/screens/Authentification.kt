package com.example.fooddelivery.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import com.example.fooddelivery.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fooddelivery.ui.theme.poppinsFontFamily

@Composable
fun authentificate(navController: NavController) {
val textState = remember {
    mutableStateOf("")
}
    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color(0xFFFFA451))
        ) {
            val image = painterResource(id = R.drawable.kisspng_fruit_basket_clip_art_5aed5301d44408_1)

            Image(
                painter = image,
                contentDescription = "Image d'identification",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .offset(0.dp, 50.dp)
                .padding(16.dp),
                horizontalAlignment = Alignment.Start
                
        ) {
            Text(
                text = "Quel est votre nom ?",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    fontFamily = poppinsFontFamily
                )
            )

            Spacer(modifier = Modifier.height(35.dp))
            
            OutlinedTextField(
                value = textState.value,
                onValueChange = { newText -> textState.value = newText },
                placeholder = {
                    Text(
                        text = "ex : Kaled",
                        style = TextStyle(
                            fontSize = 18.sp, // Taille du texte du placeholder
                            color = Color.Gray // Couleur du texte du placeholder
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done, // Action du clavier
                    keyboardType = KeyboardType.Text // Type de clavier
                ),
            )

            Spacer(modifier = Modifier.height(35.dp))
            
            Button(
                onClick = { navController.navigate("food") },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(25.dp))
                    .background(Color(0xFFFFA500)),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFA500), // Fond orange du bouton
                    contentColor = Color.White // Texte blanc
                )
            ) {
                Text(
                    text = "Continuer ",
                    color = Color.White,
                    fontFamily = poppinsFontFamily,
                    style = TextStyle(
                        fontSize = 18.sp
                    ),
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
        }
    }
}