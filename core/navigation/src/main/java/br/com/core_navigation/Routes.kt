package br.com.core_navigation

import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    data object Movies : Routes()

    @Serializable
    data class Movie(val id:String) : Routes()
}