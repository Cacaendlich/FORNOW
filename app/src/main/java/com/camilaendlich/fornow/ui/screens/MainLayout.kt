package com.camilaendlich.fornow.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.camilaendlich.fornow.models.Product
import com.camilaendlich.fornow.sampledata.sampleSections
import com.camilaendlich.fornow.ui.components.ProductSectionLayout
import com.camilaendlich.fornow.ui.theme.FORNOWTheme

@Composable
fun MainLayout(
    modifier: Modifier = Modifier,
    sections: Map<String, List<Product>>
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier)
        for (section in sections){
            ProductSectionLayout(
                name = section.key,
                productList = section.value
            )
        }
        Spacer(modifier = Modifier)
    }
}

@Preview(showSystemUi = true)
@Composable
private fun MainLayoutPreview() {
    FORNOWTheme {
        MainLayout(sections = sampleSections)
    }
}