package br.com.feat_movies.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultsDto(
    @SerialName("id")
    val id:Int,
    @SerialName("title")
    val title:String = "" ,
    @SerialName("original_title")
    val originalTitle:String = "" ,
    @SerialName("poster_path")
    val posterPath:String = "",
    @SerialName("overview")
    val overview:String = ""
){
    fun loadImage () = "https://image.tmdb.org/t/p/w500/${posterPath}"
}