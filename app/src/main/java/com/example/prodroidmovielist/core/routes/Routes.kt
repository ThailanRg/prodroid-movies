package com.example.prodroidmovielist.core.routes

import kotlinx.serialization.Serializable

object Routes {
    @Serializable
    object Movies

    @Serializable
    data class Movie(val id:String)
}