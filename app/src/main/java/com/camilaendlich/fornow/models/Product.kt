package com.camilaendlich.fornow.models

import androidx.annotation.DrawableRes
import java.math.BigDecimal

class ProductModel (
    val name: String,
    val price: BigDecimal,
    @DrawableRes val image: Int
)