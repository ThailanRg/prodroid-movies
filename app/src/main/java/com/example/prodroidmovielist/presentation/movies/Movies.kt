package com.example.prodroidmovielist.presentation.movies

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.prodroidmovielist.R
import com.example.prodroidmovielist.data.model.movies.ResultsDto
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
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = movie?.loadImage().orEmpty(),
                placeholder = painterResource(R.drawable.placeholder),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 220.dp)
            )
            Column(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .background(brush = Brush.verticalGradient(colors = listOf(black_1, black_1, black_1, Color.Transparent).reversed())).align(Alignment.BottomEnd),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MovieInfoText(
                    text = movie?.title.orEmpty(),
                    modifier = Modifier.wrapContentSize(),
                    lineHeight = 14.sp,
                    style = MaterialTheme.typography.bodyLarge
                )
                if(movie?.overview.orEmpty().isNotEmpty()){
                    MovieInfoText(
                        text = movie?.overview.orEmpty(),
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.bodySmall
                    )
                } else {
                    MovieInfoText(
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

@Composable
fun MovieInfoText(
    text: String = "-",
    maxLines: Int = 2,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    style: TextStyle = LocalTextStyle.current,
    modifier: Modifier = Modifier,
    lineHeight: TextUnit = TextUnit.Unspecified,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    ) {
    Text(
        text = text,
        style = style,
        maxLines = maxLines,
        fontSize = fontSize,
        minLines = 2,
        textAlign = TextAlign.Center,
        lineHeight = lineHeight,
        letterSpacing = letterSpacing,
        overflow = overflow,
        modifier = modifier
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