package com.camilaendlich.fornow.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.camilaendlich.fornow.R
import com.camilaendlich.fornow.models.ProductModel
import com.camilaendlich.fornow.ui.theme.FORNOWTheme
import java.math.BigDecimal

@Composable
fun ProductSectionLayout(
    name: String = "Promoções",
    productList: List<ProductModel> = listOf(
        ProductModel(
            name = "Cheese Burguer",
            price = BigDecimal("29.99"),
            image = R.drawable.img_burguer
        ),
        ProductModel(
            name = "Batata Frita",
            price = BigDecimal("19.99"),
            image = R.drawable.img_fries
        ),
        ProductModel(
            name = "Pizza",
            price = BigDecimal("59.99"),
            image = R.drawable.img_pizza
        )
    )
){
    Column {
        Text(
            text = name,
            modifier = Modifier
                .padding(horizontal = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        ) {

            item { // Adiciona um espaço inicial
                Spacer(modifier = Modifier)
            }

            items(productList.size){ index ->
                ProductItemLayout(productList[index])
            }

            item { // Adiciona um espaço inicial
                Spacer(modifier = Modifier)
            }
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