package br.com.feat_movies.data.repository

import kotlinx.coroutines.flow.Flow
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.feat_movies.data.ResultsDto

class MoviesRepositoryImpl(
    private val pagingSource: MoviesPagingSource
) : MoviesRepository {
    override suspend fun movies() : Flow<PagingData<ResultsDto>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = { pagingSource }
        ).flow
    }
}