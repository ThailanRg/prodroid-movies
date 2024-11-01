package com.example.prodroidmovielist.data.model.movie

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
    val genres: List<GenresDto> = emptyList()
)