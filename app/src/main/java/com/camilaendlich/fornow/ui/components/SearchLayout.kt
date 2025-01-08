package com.camilaendlich.fornow.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.camilaendlich.fornow.R
import com.camilaendlich.fornow.ui.theme.FORNOWTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchLayout(
    query: String = "",
    onQueryChange: (String) -> Unit = {},
    placeholder: String = "Procurar...",
    onSearch: () -> Unit = {}
) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        placeholder = {
            Text(
                text = placeholder,
                color = MaterialTheme.colorScheme.primary
            )
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearch()
            }
        ),
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.icon_search),
                contentDescription = "Search Icon",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    )
}

@Preview()
@Composable
private fun SearchLayoutPreview() {
    FORNOWTheme {
        SearchLayout()
    }
}