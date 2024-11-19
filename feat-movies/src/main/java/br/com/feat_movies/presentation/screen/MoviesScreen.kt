package br.com.feat_movies.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.core_navigation.Routes
import br.com.core_design_system.CustomDimens.dimens
import br.com.feat_movies.presentation.viewmodel.MoviesIntent.MoviesEvent
import br.com.feat_movies.presentation.viewmodel.MoviesIntent.MoviesEvent.Loading
import br.com.feat_movies.presentation.viewmodel.MoviesIntent.MoviesEvent.SendEffect
import br.com.feat_movies.presentation.viewmodel.MoviesIntent.MoviesUiState
import br.com.core_design_system.R
import br.com.core_design_system.ShimmerMovies
import br.com.core_design_system.backgroundGradient
import br.com.core_design_system.black_2

const val EMPTY_LIST = 0
const val COLUMNS = 2
const val SIMULATE_EIGHT_ITEMS = 8

@Composable
fun MoviesScreen(
    uiState: MoviesUiState,
    modifier: Modifier = Modifier,
    onEvent: (MoviesEvent) -> Unit = {},
) {

    val lazyMovies = uiState.movies.collectAsLazyPagingItems()
    val listState = rememberLazyGridState()

    Scaffold(topBar = {
        Text(
            text = stringResource(R.string.explorer),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .fillMaxWidth()
                .background(black_2)
                .padding(dimens.horizontalContainerPadding)
        )
    }) { padding ->
        LazyVerticalGrid(
            state = listState,
            modifier = modifier
                .padding(padding)
                .fillMaxSize()
                .background(brush = backgroundGradient),
            columns = GridCells.Fixed(COLUMNS),
            verticalArrangement = Arrangement.spacedBy(dimens.spaceBy),
            horizontalArrangement = Arrangement.spacedBy(dimens.spaceBy),
            contentPadding = PaddingValues(dimens.containerPadding)
        ) {
            onEvent(Loading(isLoading = lazyMovies.itemCount > EMPTY_LIST))
            if (uiState.isLoading) {
                items(
                    count = lazyMovies.itemCount,
                    key = { it.hashCode() },
                    itemContent = { movie ->
                        MoviesItem(
                            movie = lazyMovies[movie],
                            onClick = {
                                onEvent(SendEffect(br.com.core_navigation.Routes.Movie(it)))
                            }
                        )
                    }
                )
            } else {
                items(
                    count = SIMULATE_EIGHT_ITEMS,
                    itemContent = {
                        ShimmerMovies()
                    }
                )
            }
        }
    }
}
