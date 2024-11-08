package com.example.prodroidmovielist.presentation.movies

import android.util.Log
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
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.prodroidmovielist.R
import com.example.prodroidmovielist.presentation.theme.CustomDimens
import com.example.prodroidmovielist.presentation.theme.ProdroidMovieListTheme
import com.example.prodroidmovielist.presentation.theme.backgroundGradient
import com.example.prodroidmovielist.presentation.theme.black_2
import kotlinx.coroutines.flow.flow

@Composable
fun MoviesScreen(
    uiState: MoviesIntent.MoviesUiState,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {},
) {

    val lazyMovies = uiState.movies.collectAsLazyPagingItems()
    val listState = rememberLazyGridState()

    lazyMovies.apply {
        when {
            loadState.refresh is LoadState.Loading -> {

                Log.d("TAG", "loadState.refresh is LoadState.Loading ")
            }

            loadState.refresh is LoadState.Error -> {
                Log.d("TAG", "loadState.refresh is LoadState.Error: ")
            }

            loadState.append is LoadState.Loading -> {
                Log.d("TAG", "loadState.append is LoadState.Loading ")
            }

            loadState.append is LoadState.Error -> {
                Log.d("TAG", "loadState.append is LoadState.Error ")
            }
        }
    }

    Scaffold(topBar = {
        Text(
            text = stringResource(R.string.explorer),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .fillMaxWidth()
                .background(black_2)
                .padding(CustomDimens.dimens.horizontalContainerPadding)
        )
    }) { padding ->
        LazyVerticalGrid(
            state = listState,
            modifier = modifier
                .padding(padding)
                .fillMaxSize()
                .background(brush = backgroundGradient),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(CustomDimens.dimens.spaceBy),
            horizontalArrangement = Arrangement.spacedBy(CustomDimens.dimens.spaceBy),
            contentPadding = PaddingValues(CustomDimens.dimens.containerPadding)
        ) {
            items(
                count = lazyMovies.itemCount,
                key = { it.hashCode() },
                itemContent = { movie ->
                    MoviesItem(
                        movie = lazyMovies[movie],
                        onClick = onClick
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    ProdroidMovieListTheme {
        MoviesScreen(MoviesIntent.MoviesUiState(movies = flow { }))
    }
}


