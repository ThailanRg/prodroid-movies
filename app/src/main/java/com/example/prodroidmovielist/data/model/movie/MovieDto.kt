package com.example.prodroidmovielist.data.model.movie

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDto(
    @SerialName("title")
    val title:String = ""
)