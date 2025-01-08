package com.camilaendlich.fornow

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.camilaendlich.fornow.sampledata.sampleSections
import com.camilaendlich.fornow.ui.theme.FORNOWTheme
import com.camilaendlich.fornow.ui.screens.MainLayout

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(
                onClick = { contentSearch ->  Log.e("SEARCH_CLICK", contentSearch)}
            )
        }
    }
}

@Composable
fun App(
    onClick: (contentSearch: String) -> Unit
) {
    FORNOWTheme(
        dynamicColor = false
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
        ) { innerPadding ->
            MainLayout(
                modifier = Modifier.padding(innerPadding),
                sections = sampleSections,
                onClick = onClick
            )
        }
    }
}