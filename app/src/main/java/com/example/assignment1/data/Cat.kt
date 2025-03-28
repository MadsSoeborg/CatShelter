package com.example.assignment1.data

import androidx.annotation.DrawableRes

data class Cat(
    val id: String,
    val name: String,
    val category: String,
    val age: String,
    val gender: String,
    val description: String,
    @DrawableRes val imageResId: Int
)