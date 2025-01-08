package com.camilaendlich.fornow.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.camilaendlich.fornow.R
import com.camilaendlich.fornow.ui.theme.FORNOWTheme

@Composable
fun SearchLayout(
    onClick: (contentSearch: String) -> Unit = {}
) {
    var search by remember { mutableStateOf("Procurar") }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        Row{
            TextField(
                value = search,
                onValueChange = { contentSearch ->
                    search = contentSearch
                                },
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.icon_search),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable { onClick(search) }
                    )
                }
            )
        }
    }
}

@Preview()
@Composable
private fun SearchLayoutPreview() {
    FORNOWTheme {
        SearchLayout()
    }
}