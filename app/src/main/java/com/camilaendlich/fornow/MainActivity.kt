package com.camilaendlich.fornow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.camilaendlich.fornow.sampledata.SampleData
import com.camilaendlich.fornow.view.ProductSectionLayout
import com.camilaendlich.fornow.ui.theme.FORNOWTheme

class MainActivity : ComponentActivity() {
    private val sampleData = SampleData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FORNOWTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                ) { innerPadding ->
                    MainLayout(
                        modifier = Modifier.padding(innerPadding),
                        sampleData
                    )
                }
            }
        }
    }
}

@Composable
fun MainLayout(modifier: Modifier = Modifier, sampleData: SampleData) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier)
        ProductSectionLayout(
            name = "Promoções", sampleData.samplePromotions
        )
        ProductSectionLayout(
            name = "Lanches", sampleData.sampleSnacks
        )
        ProductSectionLayout(
            name = "Doces", sampleData.sampleSweets
        )
        ProductSectionLayout(
            name = "Bebidas", sampleData.sampleDrinks
        )
        Spacer(modifier = Modifier)
    }
}