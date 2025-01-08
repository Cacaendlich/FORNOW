package com.camilaendlich.fornow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.camilaendlich.fornow.sampledata.sampleSections
import com.camilaendlich.fornow.ui.screens.MainLayout
import com.camilaendlich.fornow.ui.theme.FORNOWTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = android.graphics.Color.TRANSPARENT
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            App(
                isDarkTheme = false
            )
        }
    }
}

@Composable
fun App(
    isDarkTheme: Boolean = false,
    activateDarkTheme: (Boolean) -> Unit = {}
) {
    FORNOWTheme(
        darkTheme = isDarkTheme ,
        dynamicColor = false
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) { innerPadding ->
            MainLayout(
                modifier = Modifier.padding(innerPadding),
                sections = sampleSections,
                isDarkTheme = isDarkTheme,
                activateDarkTheme = activateDarkTheme
            )
        }
    }
}