package com.example.prodroidmovielist.data.model.movie

import android.annotation.SuppressLint
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class MovieDto(
    @SerialName("id")
    val id: Int = 0,
    @SerialName("title")
    val title: String = "",
    @SerialName("tagline")
    val tagline: String = "",
    @SerialName("original_title")
    val originalTitle: String = "",
    @SerialName("poster_path")
    val posterPath: String = "",
    @SerialName("overview")
    val overview: String = "",
    @SerialName("release_date")
    val releaseDate: String = "",
    @SerialName("genres")
    val genres: List<GenresDto> = emptyList(),
    @SerialName("vote_average")
    val voteAverage: Double = 0.0,
    @SerialName("vote_count")
    val voteCount: Int = 0
) {
    fun loadImage () = "https://image.tmdb.org/t/p/w500/${posterPath}"
    @SuppressLint("NewApi")
    fun yearOfRelease () = LocalDate.parse(releaseDate).year.toString()

}