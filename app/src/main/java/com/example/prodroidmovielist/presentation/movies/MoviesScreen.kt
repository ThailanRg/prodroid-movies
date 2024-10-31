package com.example.prodroidmovielist.presentation.movies

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.prodroidmovielist.data.model.movies.MoviesDto
import com.example.prodroidmovielist.data.model.movies.ResultsDto
import com.example.prodroidmovielist.presentation.theme.ProdroidMovieListTheme

@Composable
fun MoviesScreen(
    uiState: MoviesUiState,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {},
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = uiState.movies.results,
            key = { it.id }
        ) { message ->
            Movie(message, onClick)
        }
    }
}

@Preview(showSystemUi = true)
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

@Composable
fun Movie(message: ResultsDto, onClick: (String) -> Unit = {},) {
    Card(Modifier.padding(horizontal = 18.dp).clickable { onClick(message.id.toString()) }) {
        Text(text = message.title, color = Color.Blue, modifier = Modifier.padding(18.dp))
    }
}

@Preview(showSystemUi = true)
@Composable
fun MoviePreview() {
    Movie(
        ResultsDto(
            id = 0,
            title = "Marvel"
        )
    )
}

