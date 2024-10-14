package com.example.fooddelivery.ui.theme

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fooddelivery.ui.theme.screens.CartScreen
import com.example.fooddelivery.ui.theme.screens.FruitDetailsScreen
import com.example.fooddelivery.ui.theme.screens.SplashScreen
import com.example.fooddelivery.ui.theme.screens.authentificate
import com.example.fooddelivery.ui.theme.screens.food
import com.example.fooddelivery.ui.theme.screens.foodItems
import com.example.fooddelivery.ui.theme.screens.welcomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    // Configuration du NavHost avec les différentes routes
    NavHost(navController = navController, startDestination = "splash") {
        // Ecran Splash
        composable("splash") {
            SplashScreen(navController = navController)
        }
        // Ecran Welcome
        composable("welcome") {
            welcomeScreen(navController = navController)
        }

        // Ecran Authentification
        composable("authentification") {
            authentificate(navController = navController)
        }
        // Ecran Food
        composable("food") {
            food(navController = navController)
        }
        // Ecran FruitDetails avec un argument (fruitName)
        composable("fruitDetails/{fruitName}") { backStackEntry ->
            // Récupérer le nom du fruit passé dans la route
            val fruitName = backStackEntry.arguments?.getString("fruitName")
            val selectedFruit = foodItems.find { it.name == fruitName } // Trouver le fruit correspondant

            // Afficher l'écran de détails si le fruit est trouvé
            selectedFruit?.let {
                FruitDetailsScreen(navController = navController, fruit = it)
            }
        }
        composable("cart") {
            CartScreen(navController = navController)
        }


    }

}