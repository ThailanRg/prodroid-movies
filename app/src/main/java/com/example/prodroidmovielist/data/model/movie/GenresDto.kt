package com.example.prodroidmovielist.data.model.movie

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenresDto(
    @SerialName("id")
    val id: Int = 0,
    @SerialName("name")
    val name: String = "",
)