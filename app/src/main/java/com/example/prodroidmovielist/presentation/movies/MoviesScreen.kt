package com.example.prodroidmovielist.presentation.movies

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.prodroidmovielist.R
import com.example.prodroidmovielist.core.routes.Routes.Movie
import com.example.prodroidmovielist.presentation.component.ShimmerMovies
import com.example.prodroidmovielist.presentation.movies.MoviesIntent.MoviesEvent
import com.example.prodroidmovielist.presentation.movies.MoviesIntent.MoviesEvent.Loading
import com.example.prodroidmovielist.presentation.movies.MoviesIntent.MoviesEvent.SendEffect
import com.example.prodroidmovielist.presentation.movies.MoviesIntent.MoviesUiState
import com.example.prodroidmovielist.presentation.theme.CustomDimens.dimens
import com.example.prodroidmovielist.presentation.theme.ProdroidMovieListTheme
import com.example.prodroidmovielist.presentation.theme.backgroundGradient
import com.example.prodroidmovielist.presentation.theme.black_2
import kotlinx.coroutines.flow.flow

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
                                onEvent(SendEffect(Movie(it)))
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

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    ProdroidMovieListTheme {
        MoviesScreen(MoviesUiState(movies = flow { }))
    }
}


