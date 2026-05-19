package com.jaamcoding.dailypulse

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jaamcoding.dailypulse.articles.ArticlesViewModel
import com.jaamcoding.dailypulse.screens.AboutScreen
import com.jaamcoding.dailypulse.screens.ArticlesScreen
import com.jaamcoding.dailypulse.screens.Screens

@Composable
fun AppScaffold(articlesViewModel: ArticlesViewModel) {
    val navController = rememberNavController()
    Scaffold { paddingValues ->
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            articlesViewModel
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    articlesViewModel: ArticlesViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screens.ARTICLES.route,
        modifier = modifier,
    ) {
        composable(Screens.ARTICLES.route) {
            ArticlesScreen(
                onAboutButtonClick = { navController.navigate(Screens.ABOUT_DEVICE.route) },
                articlesViewModel,
            )
        }
        composable(Screens.ABOUT_DEVICE.route) {
            AboutScreen(
                onUpButtonClick = { navController.popBackStack() }
            )
        }
    }
}