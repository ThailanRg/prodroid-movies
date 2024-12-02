package br.com.feat_movie.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenresDto(
    @SerialName("id")
    val id: Int = 0,
    @SerialName("name")
    val name: String = "",
)