package com.example.prodroidmovielist.presentation.movies

import androidx.paging.PagingData
import com.example.prodroidmovielist.core.routes.Routes
import com.example.prodroidmovielist.data.model.movies.ResultsDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MoviesIntent {
    data class MoviesUiState(
        val movies: Flow<PagingData<ResultsDto>> = flow {  },
        val isLoading: Boolean = true,
    )

    sealed class MoviesEvent {
        data object InitScreen : MoviesEvent()
        data class Loading(val isLoading: Boolean = true) : MoviesEvent()
        data class SendEffect(val routes: Routes) : MoviesEvent()
    }

    sealed class MoviesEffect {
        data class GoToDetail(val routes: Routes? = null) : MoviesEffect()
    }

}