package com.example.prodroidmovielist.presentation.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.prodroidmovielist.presentation.component.MoviesItem
import com.example.prodroidmovielist.presentation.component.ShimmerMovies
import com.example.prodroidmovielist.presentation.theme.CustomDimens
import com.example.prodroidmovielist.presentation.theme.ProdroidMovieListTheme
import kotlinx.coroutines.flow.flow

@Composable
fun MoviesScreen(
    uiState: MoviesUiState,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {},
) {

    val lazyPokemon = uiState.movies.collectAsLazyPagingItems()

    ShimmerMovies(
        isLoading = uiState.isLoading,
        contentAfterLoading = {
            LazyVerticalGrid(
                modifier = modifier,
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(CustomDimens.dimens.spaceBy),
                horizontalArrangement = Arrangement.spacedBy(CustomDimens.dimens.spaceBy),
                contentPadding = PaddingValues(CustomDimens.dimens.containerPadding)
            ) {

                items(
                    count = lazyPokemon.itemCount,
                ) { position ->
                    MoviesItem(
                        movie = lazyPokemon[position],
                        onClick = onClick
                    )
                }
            }
        }
    )

}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    ProdroidMovieListTheme {
        MoviesScreen(
            MoviesUiState(
                movies = flow { }
            )
        )
    }
}


