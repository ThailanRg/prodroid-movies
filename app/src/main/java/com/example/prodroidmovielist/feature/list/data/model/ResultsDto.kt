package com.example.prodroidmovielist.feature.list.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultsDto(
    @SerialName("id")
    val id:Int,
    @SerialName("title")
    val title:String = ""
)