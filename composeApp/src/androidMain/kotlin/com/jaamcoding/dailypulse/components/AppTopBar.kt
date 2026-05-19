package com.jaamcoding.dailypulse.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.jaamcoding.dailypulse.screens.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    currentRoute: String?,
    onBackClick: () -> Unit,
    onAboutButtonClick: () -> Unit,
) {

    when (currentRoute) {

        Screens.ARTICLES.route -> {
            TopAppBar(
                title = {
                    Text("Articles")
                },
                actions = {
                    IconButton(onClick = onAboutButtonClick) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = "About Device button"
                        )
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
    }
}