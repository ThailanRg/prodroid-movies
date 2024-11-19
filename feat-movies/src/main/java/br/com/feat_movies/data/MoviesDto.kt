package br.com.feat_movies.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesDto(
    @SerialName("page")
    val page:Int = 0,
    @SerialName("results")
    val results:List<ResultsDto> = emptyList()
)