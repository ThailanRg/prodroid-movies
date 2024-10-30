package com.example.prodroidmovielist.feature.list.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.prodroidmovielist.feature.list.data.model.MovieDto
import com.example.prodroidmovielist.presentation.theme.ProdroidMovieListTheme

@Composable
fun ListScreen(
    uiState: ListUiState,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    LazyColumn {
        items(
            items = uiState.list,
            key = { message -> message.id }
        ) { message ->
            Movie(message)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ListScreenPreview() {
    ProdroidMovieListTheme {
        ListScreen(
            ListUiState(
                list = listOf(
                    MovieDto(id = 1, title = "lanterna verde"),
                    MovieDto(id = 0, title = "marvel")
                )
            )
        )
    }
}

@Composable
fun Movie(message: MovieDto) {
    Text(text = message.title, color = Color.Blue)
}

@Preview(showSystemUi = true)
@Composable
fun MoviePreview() {
    Movie(MovieDto(id = 0, title = "marvel"))
}

