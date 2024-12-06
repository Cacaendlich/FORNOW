package com.camilaendlich.fornow.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.camilaendlich.fornow.R
import com.camilaendlich.fornow.extensions.toBrazilianCurrency
import com.camilaendlich.fornow.models.ProductModel
import com.camilaendlich.fornow.ui.theme.FORNOWTheme
import com.camilaendlich.fornow.ui.theme.Primary
import com.camilaendlich.fornow.ui.theme.Secondary
import java.math.BigDecimal

@Composable
fun ProductItemLayout(
    product: ProductModel = ProductModel(
        name = "Cheese Burguer",
        price = BigDecimal("14.99"),
        image = R.drawable.ic_launcher_background
    )
) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        val imageSize = 100.dp

        Column(
            modifier = Modifier
                .height(250.dp)
                .width(200.dp)
                .background(Color.White)
        ) {

            Box(
                modifier = Modifier
                    .heightIn(100.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Primary,
                                Secondary
                            )
                        )
                    )
                    .fillMaxWidth()
            ) {

                Image(
                    painter = painterResource(product.image),
                    contentDescription = "Imagem do produto",
                    modifier = Modifier
                        .offset(y = imageSize/2)
                        .size(imageSize)
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(imageSize/2))

            Column(
                modifier = Modifier
                    .padding(all = 16.dp)
            ) {
                Text(
                    text = product.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = product.price.toBrazilianCurrency(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ProductItemLayoutPreview() {
    FORNOWTheme {
        ProductItemLayout()
    }
}
