package com.example.prodroidmovielist.presentation.movies.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.prodroidmovielist.R
import com.example.prodroidmovielist.data.model.movies.ResultsDto

@Composable
fun MoviesItem(
    movie: ResultsDto,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {}
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .border(width = 1.dp, color = Color(0xFF892CCD), shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
            .clickable {
                onClick(movie.id.toString())
            },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val image = "https://image.tmdb.org/t/p/w500${movie.posterPath}"
        AsyncImage(
            model = image,
            placeholder = painterResource(R.drawable.placeholder),
            contentDescription = null,
            modifier = Modifier.width(120.dp)
        )
        MovieInfoText(text = movie.title, style = MaterialTheme.typography.bodyLarge)
        MovieInfoText(
            text = movie.overview,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun MovieInfoText(
    text: String,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = LocalTextStyle.current
){
    Text(
        text = text,
        style = style,
        maxLines = maxLines,
        overflow = overflow,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(top = 8.dp),
    )
}

@Preview(showBackground = true)
@Composable
fun MoviesPreview() {
    MoviesItem(
        ResultsDto(
            id = 0,
            title = "Marvel"
        )
    )
}