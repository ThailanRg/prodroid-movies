package com.example.prodroidmovielist.feature.list.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesDto(
    @SerialName("page")
    val page:Int,
    @SerialName("results")
    val results:List<ResultsDto> = emptyList()
)