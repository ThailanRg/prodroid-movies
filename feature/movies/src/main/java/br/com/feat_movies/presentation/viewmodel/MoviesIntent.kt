package br.com.feat_movies.presentation.viewmodel

import androidx.paging.PagingData
import br.com.feat_movies.data.ResultsDto
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
        data class SendEffect(val routes: br.com.core_navigation.Routes) : MoviesEvent()
    }

    sealed class MoviesEffect {
        data class GoToDetail(val routes: br.com.core_navigation.Routes? = null) : MoviesEffect()
    }

}