package com.example.prodroidmovielist.presentation.movie

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.prodroidmovielist.R
import com.example.prodroidmovielist.data.model.movie.MovieDto
import com.example.prodroidmovielist.presentation.component.ShimmerMovie
import com.example.prodroidmovielist.presentation.theme.CustomDimens
import com.example.prodroidmovielist.presentation.theme.PurpleHeadProDroid
import com.example.prodroidmovielist.presentation.theme.PurpleProDroid
import com.example.prodroidmovielist.presentation.theme.backgroundGradient
import com.example.prodroidmovielist.presentation.theme.black_2

@SuppressLint("StringFormatInvalid")
@Composable
fun MovieScreen(
    uiState: MovieUiState,
    popBack: () -> Unit = {}
) {
    ShimmerMovie(modifier = Modifier
        .fillMaxSize()
        .background(brush = backgroundGradient),
        isLoading = uiState.isLoading,
        contentAfterLoading = {
            val context = LocalContext.current
            Scaffold(topBar = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(black_2)
                        .padding(CustomDimens.dimens.horizontalContainerPadding),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.icon_back),
                        tint = PurpleHeadProDroid,
                        modifier = Modifier
                            .height(16.dp)
                            .clickable {
                                popBack()
                            },
                        contentDescription = null
                    )
                    Text(
                        text = stringResource(R.string.back),
                        modifier = Modifier.padding(start = CustomDimens.dimens.spaceBy),
                        style = MaterialTheme.typography.headlineMedium,
                    )
                }

            }) { padding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(brush = backgroundGradient)
                        .padding(padding)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = CustomDimens.dimens.horizontalContainerPadding)
                    ) {
                        Row {
                            AsyncImage(
                                model = uiState.movie.loadImage(),
                                placeholder = painterResource(R.drawable.placeholder),
                                contentDescription = null,
                                modifier = Modifier.width(180.dp)
                            )
                            Column(
                                modifier = Modifier.padding(start = CustomDimens.dimens.spaceSection),
                                verticalArrangement = Arrangement.spacedBy(CustomDimens.dimens.spaceBy)
                            ) {
                                Text(
                                    text = uiState.movie.title,
                                    style = MaterialTheme.typography.titleLarge,
                                )

                                Text(
                                    text = context.getString(
                                        R.string.genres, uiState.movie.genres.first().name
                                    ), style = MaterialTheme.typography.bodyMedium
                                )

                                Text(
                                    text = context.getString(
                                        R.string.release, uiState.movie.yearOfRelease()
                                    ), style = MaterialTheme.typography.bodyMedium
                                )

                                Column {
                                    StarIcon()
                                    Row(
                                        modifier = Modifier.padding(top = CustomDimens.dimens.spaceBy)
                                    ) {
                                        Text(
                                            text = uiState.movie.voteAverage.toString(),
                                            style = MaterialTheme.typography.bodyMedium
                                        )
                                        Text(
                                            text = context.getString(
                                                R.string.vote_count,
                                                uiState.movie.voteCount.toString(),
                                            ), style = MaterialTheme.typography.bodyMedium,
                                        )
                                    }
                                }
                            }
                        }
                        Text(
                            text = uiState.movie.overview,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(top = CustomDimens.dimens.spaceSection)
                        )
                    }
                }
            }
        })
}

@Composable
fun StarIcon(
    maxStart: Int = 5
) {

    var positionClicked by remember { mutableIntStateOf(0) }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(CustomDimens.dimens.spaceBy)
    ) {
        items(count = List(maxStart) { it }.size) { position ->

            when {
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