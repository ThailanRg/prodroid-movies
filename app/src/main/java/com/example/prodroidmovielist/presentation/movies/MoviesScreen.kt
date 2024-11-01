package com.example.prodroidmovielist.presentation.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.prodroidmovielist.data.model.movies.MoviesDto
import com.example.prodroidmovielist.data.model.movies.ResultsDto
import com.example.prodroidmovielist.presentation.movies.component.MoviesItem
import com.example.prodroidmovielist.presentation.theme.ProdroidMovieListTheme

@Composable
fun MoviesScreen(
    uiState: MoviesUiState,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {},
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(18.dp),
        horizontalArrangement = Arrangement.spacedBy(18.dp),
        contentPadding = PaddingValues(18.dp)
    ) {
        items(
            items = uiState.movies.results,
            key = { it.id }
        ) { movie ->
            MoviesItem(
                movie = movie,
                onClick = onClick
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    ProdroidMovieListTheme {
        MoviesScreen(
            MoviesUiState(
                movies = MoviesDto(
                    page = 0,
                    results = listOf(
                        ResultsDto(id = 1, title = "lanterna verde"),
                        ResultsDto(id = 0, title = "marvel")
                    )
                )
            )
        )
    }
}


