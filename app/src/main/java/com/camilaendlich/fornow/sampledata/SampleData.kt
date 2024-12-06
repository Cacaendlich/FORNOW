package com.camilaendlich.fornow.sampledata

import com.camilaendlich.fornow.R
import com.camilaendlich.fornow.models.ProductModel
import java.math.BigDecimal

class SampleData {
    val samplePromotions = listOf(
        ProductModel(
            name = "Hamburguer",
            price = BigDecimal("29.99"),
            image = R.drawable.img_burguer
        )
    )

    val sampleSnacks = listOf(
        ProductModel(
            name = "Hamburguer",
            price = BigDecimal("29.99"),
            image = R.drawable.img_burguer
        ),
        ProductModel(
            name = "Batata Frita",
            price = BigDecimal("15.99"),
            image = R.drawable.img_fries
        ),
        ProductModel(
            name = "Pizza",
            price = BigDecimal("24.99"),
            image = R.drawable.img_pizza
        )
    )

    val sampleSweets = listOf(
        ProductModel(
            name = "Kit Kat",
            price = BigDecimal("4.99"),
            image = R.drawable.img_kitkat
        ),
        ProductModel(
            name = "Sorvete",
            price = BigDecimal("12.99"),
            image = R.drawable.img_icecream
        ),
        ProductModel(
            name = "Picolé",
            price = BigDecimal("6.99"),
            image = R.drawable.img_picole
        )
    )

    val sampleDrinks = listOf(
        ProductModel(
            name = "Cola Cola",
            price = BigDecimal("6.99"),
            image = R.drawable.img_coca_cola
        ),
        ProductModel(
            name = "Sprite",
            price = BigDecimal("5.99"),
            image = R.drawable.img_sprite
        ),
        ProductModel(
            name = "Água Mineral",
            price = BigDecimal("4.99"),
            image = R.drawable.img_crystal
        )
    )

}