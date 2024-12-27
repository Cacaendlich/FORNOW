package com.camilaendlich.fornow.models

import java.math.BigDecimal

class Product (
    val name: String,
    val price: BigDecimal,
    val image: String? = null
)