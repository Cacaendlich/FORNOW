package com.camilaendlich.fornow.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.camilaendlich.fornow.models.Product
import com.camilaendlich.fornow.sampledata.sampleProducts
import com.camilaendlich.fornow.ui.theme.FORNOWTheme

@Composable
fun ProductSectionLayout(
    name: String = "Promoções",
    productList: List<Product> = sampleProducts
){
    Column {
        Text(
            text = name.uppercase(),
            modifier = Modifier
                .padding(horizontal = 16.dp),
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )

        Row(
            Modifier
                .padding(
                    top = 8.dp
                )
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(Modifier)
            for (product in productList) {
                ProductItemLayout(product = product)
            }
            Spacer(Modifier)
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