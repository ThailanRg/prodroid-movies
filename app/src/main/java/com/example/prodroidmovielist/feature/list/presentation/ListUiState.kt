package com.example.prodroidmovielist.feature.list.presentation

import com.example.prodroidmovielist.feature.list.data.model.MovieDto

data class ListUiState(
    val list: List<MovieDto> = emptyList()
)