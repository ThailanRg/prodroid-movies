package com.example.prodroidmovielist.presentation.movies

import androidx.paging.PagingData
import com.example.prodroidmovielist.data.model.movies.ResultsDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

data class MoviesUiState(
    val movies: Flow<PagingData<ResultsDto>> = flow {  },
    val isLoading: Boolean = true
)