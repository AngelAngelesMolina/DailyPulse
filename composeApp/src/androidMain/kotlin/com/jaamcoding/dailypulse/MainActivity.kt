package com.jaamcoding.dailypulse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jaamcoding.dailypulse.articles.ArticlesViewModel
import com.jaamcoding.dailypulse.screens.AboutScreen
import com.jaamcoding.dailypulse.screens.ArticlesScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        Platform().logSystemInfo()
        val articlesVm: ArticlesViewModel by viewModels()
        setContent {
            ArticlesScreen(articlesVm)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    AboutScreen()
}