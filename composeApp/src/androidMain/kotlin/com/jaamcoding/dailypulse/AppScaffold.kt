package com.jaamcoding.dailypulse

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jaamcoding.dailypulse.articles.ArticlesViewModel
import com.jaamcoding.dailypulse.components.AppTopBar
import com.jaamcoding.dailypulse.screens.AboutScreen
import com.jaamcoding.dailypulse.screens.ArticlesScreen
import com.jaamcoding.dailypulse.screens.Screens

@Composable
fun AppScaffold() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route
    Scaffold(
        topBar = {
            AppTopBar(
                currentRoute = currentRoute,
                onBackClick = {
                    navController.popBackStack()
                },
                onAboutButtonClick = {
                    navController.navigate(Screens.ABOUT_DEVICE.route)
                }
            )
        }
    ) { paddingValues ->

        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screens.ARTICLES.route,
        modifier = modifier,
    ) {
        composable(Screens.ARTICLES.route) {
            ArticlesScreen()
        }
        composable(Screens.ABOUT_DEVICE.route) {
            AboutScreen()
        }
    }
}