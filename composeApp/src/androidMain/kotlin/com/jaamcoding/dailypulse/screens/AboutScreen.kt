package com.jaamcoding.dailypulse.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jaamcoding.dailypulse.Platform

@Composable
fun AboutScreen(
) {
    Column {
        ContentView()
    }
}

@Composable
private fun ContentView() {
    val items = makeItems()
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(items) { row ->
            RowView(title = row.first, subtitle = row.second)
        }

    }

}

private fun makeItems(): List<Pair<String, String>> {
    val platform = Platform()
    platform.logSystemInfo()

    return listOf(
        Pair("Operating Sistem", "${platform.osName} ${platform.osVersion}"),
        Pair("Device Model", platform.deviceModel),
        Pair("Density", platform.density.toString())
    )
}

@Composable
private fun RowView(title: String, subtitle: String) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
    }
    HorizontalDivider()
}