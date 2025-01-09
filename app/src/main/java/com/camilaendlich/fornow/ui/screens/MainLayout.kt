package com.camilaendlich.fornow.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.camilaendlich.fornow.R
import com.camilaendlich.fornow.models.Product
import com.camilaendlich.fornow.ui.components.ProductSectionLayout
import com.camilaendlich.fornow.ui.components.SearchLayout
import com.camilaendlich.fornow.ui.theme.MediumGray
import com.camilaendlich.fornow.ui.theme.Primary
import com.camilaendlich.fornow.ui.theme.Secondary
import com.camilaendlich.fornow.ui.theme.White

@Composable
fun MainLayout(
    modifier: Modifier = Modifier,
    sections: Map<String, List<Product>>,
    darkThemeState: MutableState<Boolean>,
    activateDarkTheme: (Boolean) -> Unit = {},
) {
    val searchQuery = remember { mutableStateOf("") }

    val filteredSections = sections.mapValues { entry ->
        entry.value.filter { product ->
            product.name.contains(searchQuery.value, ignoreCase = true)
        }
    }.filter { it.value.isNotEmpty() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        Header(
            isDarkTheme = darkThemeState.value,
            activateDarkTheme = activateDarkTheme
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(MaterialTheme.colorScheme.background)
        ) {
            Spacer(modifier = Modifier)

            SearchLayout(
                query = searchQuery.value,
                onQueryChange = { searchQuery.value = it },
                isDarkTheme = darkThemeState.value
            )

            for (section in filteredSections) {
                ProductSectionLayout(
                    name = section.key,
                    productList = section.value
                )
            }

            Spacer(modifier = Modifier)
        }
    }
}

@Composable
fun Header(
    isDarkTheme: Boolean = false,
    activateDarkTheme: (Boolean) -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Primary,
                        Secondary
                    )
                )
            )
            .padding(start = 16.dp, end = 16.dp, top = 64.dp, bottom = 8.dp)
    ) {
        Column {
            Text(
                text = "É PRA JÁ",
                fontWeight = FontWeight.Bold,
                modifier = Modifier,
                color = White
            )

            Text(
                text = "DELIVERY",
                modifier = Modifier,
                color = MediumGray,
                fontSize = 12.sp
            )
        }

        Image(
            painter = painterResource(if (isDarkTheme)R.drawable.ic_mode_night else R.drawable.ic_light_mode),
            contentDescription = null,
            modifier = Modifier
                .clickable { activateDarkTheme(!isDarkTheme) },
            colorFilter = ColorFilter.tint(White)
        )
    }
}