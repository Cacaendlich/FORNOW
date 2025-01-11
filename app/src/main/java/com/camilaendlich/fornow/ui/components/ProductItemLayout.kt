package com.camilaendlich.fornow.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.camilaendlich.fornow.R
import com.camilaendlich.fornow.extensions.toBrazilianCurrency
import com.camilaendlich.fornow.models.Product
import com.camilaendlich.fornow.ui.theme.FORNOWTheme
import com.camilaendlich.fornow.ui.theme.MediumGray
import com.camilaendlich.fornow.ui.theme.Primary
import com.camilaendlich.fornow.ui.theme.Secondary
import java.math.BigDecimal

@Composable
fun ProductItemLayout(
    product: Product = Product(
        name = "Cheese Burguer",
        price = BigDecimal("14.99")
    )
) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        val imageSize = 100.dp

        Column(
            modifier = Modifier
                .height(220.dp)
                .width(160.dp)
                .background(MaterialTheme.colorScheme.surface)
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
                Log.d("ProductItem", "Imagem URL: ${product.image}")

                AsyncImage(
                    model = product.image,
                    contentDescription = "Imagem do produto",
                    modifier = Modifier
                        .offset(y = imageSize / 3)
                        .size(imageSize)
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter)
                        .border(
                            width = 1.dp,
                            color = MediumGray,
                            shape = CircleShape
                        ),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.ic_launcher_background),
                    error = painterResource(id = R.drawable.ic_launcher_foreground)
                )
            }

            Spacer(modifier = Modifier.height(imageSize/2))

            Column(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = product.name,
                    color = MaterialTheme.colorScheme.onSurface,
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
