package com.example.prodroidmovielist.presentation.movie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.prodroidmovielist.R
import com.example.prodroidmovielist.data.model.movie.MovieDto
import com.example.prodroidmovielist.presentation.theme.rajdHaniFamily

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MovieScreen(
    uiState: MovieUiState,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier.padding(18.dp)
    ) {
        val image = "https://image.tmdb.org/t/p/w500${uiState.movie.posterPath}"

        Text(
            text = "#${uiState.movie.id}",
            color = Color.White,
            modifier = Modifier.padding(
                bottom = 12.dp
            )
        )

        AsyncImage(
            model = image,
            placeholder = painterResource(R.drawable.placeholder),
            contentDescription = null,
            modifier = Modifier
                .width(120.dp)
        )
        Text(
            text = uiState.movie.title,
            color = Color.White,
            style = MaterialTheme.typography.titleLarge,
        )

        Row {
            Text(
                text = "${context.getString(R.string.release)} ${uiState.movie.releaseDate}",
                color = Color.White,
            )
        }

        Text(
            text = stringResource(R.string.genres),
            color = Color.White,
        )

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(top = 10.dp)
        ) {
            uiState.movie.genres.forEach {
                Genres(it.name)
            }
        }

        Text(
            text = uiState.movie.overview,
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
fun Genres(text: String) {
    Text(
        text = text,
        color = Color.White,
        modifier = Modifier
            .background(
                color = Color.Blue,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(vertical = 2.dp, horizontal = 8.dp),
        fontSize = 10.sp
    )
}

@Composable
@Preview(showSystemUi = true)
fun MovieScreenPreview() {
    MovieScreen(
        MovieUiState(
            movie = MovieDto(
                title = "Venom: The Last Dance",
                posterPath = "https://image.tmdb.org/t/p/w500/3V4kLQg0kSqPLctI5ziYWabAZYF.jpg"
            )
        )
    )
}