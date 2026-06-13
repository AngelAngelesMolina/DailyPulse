package com.jaamcoding.dailypulse.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jaamcoding.dailypulse.articles.presentation.ArticlesViewModel
import com.jaamcoding.dailypulse.sources.domain.Source
import com.jaamcoding.dailypulse.sources.presentation.SourcesViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SourcesScreen(
    sourcesVm: SourcesViewModel = koinViewModel<SourcesViewModel>()
) {
    val sourcesState by sourcesVm.sourcesState.collectAsStateWithLifecycle()

    Column {
        if (sourcesState.isError != null) {
            ErrorMessage(sourcesState.isError!!)
        }
        if (sourcesState.sources.isNotEmpty()) {
            SourcesListView(sourcesVm)
        }
    }
}

@Composable
fun SourcesListView(vm: SourcesViewModel) {
    val state by vm.sourcesState.collectAsStateWithLifecycle()

    val pullToRefreshState = rememberPullToRefreshState()

    PullToRefreshBox(
        state = pullToRefreshState,
        isRefreshing = state.isLoading,
        onRefresh = {
            vm.getSources(true)
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.sources) { source ->
                SourceItem(source)
            }
        }
    }
}


@Composable
fun SourceItem(
    source: Source
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = source.name,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium,
        )
        source.desc?.let {
            Text(
                text = source.desc,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Text(
            text = source.countryLanguage,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End,
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SourceItemPrev() {
    SourceItem(
        source = Source(
            name = "ABC NEWS",
            desc = "You trusted source for breaking neews, analysis, excludsive interviews, headlines and videos at ABCNews.com",
            countryLanguage = "au-en"
        )
    )
}