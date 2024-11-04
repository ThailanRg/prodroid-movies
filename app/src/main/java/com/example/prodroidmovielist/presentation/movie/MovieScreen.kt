package com.example.prodroidmovielist.presentation.movie

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.prodroidmovielist.R
import com.example.prodroidmovielist.data.model.movie.MovieDto
import com.example.prodroidmovielist.presentation.component.ShimmerMovie
import com.example.prodroidmovielist.presentation.theme.CustomDimens
import com.example.prodroidmovielist.presentation.theme.PurpleProDroid

@SuppressLint("StringFormatInvalid")
@Composable
fun MovieScreen(
    uiState: MovieUiState,
) {

    ShimmerMovie(isLoading = uiState.isLoading, contentAfterLoading = {
        val context = LocalContext.current
        Row(
            modifier = Modifier.padding(CustomDimens.dimens.containerPadding)
        ) {
            AsyncImage(
                model = uiState.movie.loadImage(),
                placeholder = painterResource(R.drawable.placeholder),
                contentDescription = null,
                modifier = Modifier.width(180.dp)
            )
            Column(
                modifier = Modifier.padding(start = 10.dp),
                verticalArrangement = Arrangement.spacedBy(CustomDimens.dimens.spaceBy)
            ) {

                Text(
                    text = uiState.movie.title,
                    style = MaterialTheme.typography.titleLarge,
                )

                Text(
                    text = context.getString(R.string.genres, uiState.movie.genres.first().name),
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = context.getString(R.string.release, uiState.movie.yearOfRelease()),
                    style = MaterialTheme.typography.bodyMedium
                )

                Column {
                    StarIcon()
                    Row(
                        modifier = Modifier.padding(top = 4.dp)
                    ) {
                        Text(text = uiState.movie.voteAverage.toString())
                        Text(
                            text = context.getString(
                                R.string.vote_count,
                                uiState.movie.voteCount.toString(),
                            ),
                        )
                    }
                }

                Text(
                    text = uiState.movie.overview,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    })
}

@Composable
fun StarIcon(
    maxStart: Int = 5
) {

    val amountStart = List(maxStart) { it }
    var positionClicked by remember { mutableIntStateOf(0) }


    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(CustomDimens.dimens.spaceBy)
    ) {
        items(count = amountStart.size) { position ->

            when{
                position <= positionClicked -> {
                    Icon(
                        painter = painterResource(R.drawable.start_fill),
                        tint = PurpleProDroid,
                        modifier = Modifier
                            .size(20.dp)
                            .clickable {
                                positionClicked = position
                            },
                        contentDescription = ""
                    )
                }
                else -> {
                    Icon(
                        painter = painterResource(R.drawable.start_outlined),
                        tint = PurpleProDroid,
                        modifier = Modifier
                            .size(20.dp)
                            .clickable {
                                positionClicked = position
                            },
                        contentDescription = ""
                    )
                }
            }
        }
    }
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