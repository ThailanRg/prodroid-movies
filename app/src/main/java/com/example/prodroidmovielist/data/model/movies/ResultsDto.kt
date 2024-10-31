package com.example.prodroidmovielist.data.model.movies

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultsDto(
    @SerialName("id")
    val id:Int,
    @SerialName("title")
    val title:String = ""
)