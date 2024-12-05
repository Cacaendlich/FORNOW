package com.camilaendlich.fornow.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.camilaendlich.fornow.R
import com.camilaendlich.fornow.ui.models.ProductModel
import com.camilaendlich.fornow.ui.theme.FORNOWTheme
import java.math.BigDecimal

@Composable
fun ProductSectionLayout(){
    Column(
    ) {
        Text(
            text = "Promoções",
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )

        Row (
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(top = 8.dp, bottom = 16.dp)
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ){
            Spacer(modifier = Modifier)
            ProductItemLayout(ProductModel(
                name = "Cheese Burguer",
                price = BigDecimal("29.99"),
                image = R.drawable.burguer
            ))
            ProductItemLayout(ProductModel(
                name = "Batata Frita",
                price = BigDecimal("19.99"),
                image = R.drawable.fries
            ))
            ProductItemLayout(ProductModel(
                name = "Pizza",
                price = BigDecimal("59.99"),
                image = R.drawable.pizza
            ))
            Spacer(modifier = Modifier)

        }
    }
}

@Preview(showBackground = false)
@Composable
fun ProductSectionLayoutPreview() {
    FORNOWTheme {
        ProductSectionLayout()
    }
}