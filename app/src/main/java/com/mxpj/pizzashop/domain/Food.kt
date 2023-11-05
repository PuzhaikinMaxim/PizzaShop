package com.mxpj.pizzashop.domain

data class Food(
    val id: Int,
    val name: String,
    val description: String,
    val price: String,
    val imageLocation: String = "",
    val isLocal: Boolean = false
)