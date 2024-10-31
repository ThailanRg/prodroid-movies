package com.example.prodroidmovielist.feature.list.presentation

import com.example.prodroidmovielist.feature.list.data.model.MoviesDto

data class ListUiState(
    val movies: MoviesDto = MoviesDto(page = 0)
)