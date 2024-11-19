package br.com.feat_movies.data.repository

import androidx.paging.PagingData
import br.com.feat_movies.data.ResultsDto
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun movies(): Flow<PagingData<ResultsDto>>
}