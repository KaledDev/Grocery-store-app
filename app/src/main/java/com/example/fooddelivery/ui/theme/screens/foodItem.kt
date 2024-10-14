package com.example.fooddelivery.ui.theme.screens

import com.example.fooddelivery.R

data class foodItem(
    val id: String,
    val imageRes: Int,
    val name: String,
    val price: Double
)

val foodItems = listOf(
    foodItem("1", R.drawable.image_5, "Fraise", 500.0),
    foodItem("2", R.drawable.image_6, "Pomme", 500.0),
    foodItem("3", R.drawable.image_7, "Orange", 500.0),
    foodItem("4", R.drawable.image__6__removebg_preview, "Banane", 500.0),
    foodItem("5", R.drawable.image__5__removebg_preview, "Salade", 500.0),
    foodItem("6", R.drawable.image__7__removebg_preview, "Tomate", 500.0),
    foodItem("7", R.drawable.image__8__removebg_preview, "Oignon", 500.0),
    foodItem("8", R.drawable.image__9__removebg_preview, "Citron", 500.0)
)