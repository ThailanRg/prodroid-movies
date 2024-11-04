package com.example.prodroidmovielist.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.prodroidmovielist.R
import com.example.prodroidmovielist.data.model.movies.ResultsDto
import com.example.prodroidmovielist.presentation.theme.CustomDimens
import com.example.prodroidmovielist.presentation.theme.black_1

@Composable
fun MoviesItem(
    movie: ResultsDto?,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .clickable { onClick(movie?.id.toString()) },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box {
            AsyncImage(
                model = movie?.loadImage().orEmpty(),
                placeholder = painterResource(R.drawable.placeholder),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().heightIn(220.dp)
            )
            Column(
                modifier = Modifier
                    .height(100.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(black_1, black_1, black_1, Color.Transparent).reversed()
                        )
                    )
                    .align(Alignment.BottomEnd),
                verticalArrangement = Arrangement.Center,
            ) {
                MovieInfoText(
                    text = movie?.title.orEmpty(),
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodyLarge
                )
                MovieInfoText(
                    text = movie?.overview.orEmpty(),
                    maxLines = 2,
                    modifier = Modifier.fillMaxWidth(),
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun MovieInfoText(
    text: String,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = LocalTextStyle.current,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = style,
        maxLines = maxLines,
        overflow = overflow,
        textAlign = TextAlign.Center,
        modifier = modifier.padding(top = CustomDimens.dimens.containerPadding),
    )
}

@Preview(showBackground = true)
@Composable
fun MoviesPreview() {
    MoviesItem(
        ResultsDto(
            id = 0, title = "Marvel"
        )
    )
}