package com.jaamcoding.dailypulse.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jaamcoding.dailypulse.screens.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    currentRoute: String?,
    onBackClick: () -> Unit,
    onAboutButtonClick: () -> Unit,
    onSourcesClick: () -> Unit,
) {

    when (currentRoute) {

        Screens.ARTICLES.route -> {
            TopAppBar(
                title = {
                    Text("Articles")
                },
                actions = {
                    Row {
                        IconButton(onClick = onSourcesClick) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.List,
                                contentDescription = "Back button"
                            )
                        }
                        IconButton(onClick = onAboutButtonClick) {
                            Icon(
                                imageVector = Icons.Outlined.Info,
                                contentDescription = "Sources button"
                            )
                        }
                    }
                }
            )
        }

        Screens.ABOUT_DEVICE.route -> {
            TopAppBar(
                title = {
                    Text("About device")
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back button"
                        )
                    }
                }
            )
        }

        Screens.SOURCES.route -> {
            TopAppBar(
                title = {
                    Text("Sources")
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back button"
                        )
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppTopBarPrev() {
    AppTopBar(
        currentRoute = Screens.ARTICLES.route,
        onBackClick = {},
        onAboutButtonClick = {},
        onSourcesClick = {}
    )

}