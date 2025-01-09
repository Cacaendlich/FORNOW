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
import com.camilaendlich.fornow.ui.theme.LightGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchLayout(
    query: String = "",
    onQueryChange: (String) -> Unit = {},
    placeholder: String = "Procurar...",
    onSearch: () -> Unit = {},
    isDarkTheme: Boolean = false
) {
    val keyboardController = androidx.compose.ui.platform.LocalSoftwareKeyboardController.current

    TextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        placeholder = {
            Text(
                text = placeholder,
                color = if (isDarkTheme) LightGray else MaterialTheme.colorScheme.primary
            )
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                keyboardController?.hide()
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
                tint = if (isDarkTheme) LightGray else MaterialTheme.colorScheme.primary
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