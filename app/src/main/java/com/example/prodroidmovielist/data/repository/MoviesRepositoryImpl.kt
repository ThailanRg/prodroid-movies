package com.example.prodroidmovielist.data.repository

import com.example.prodroidmovielist.data.remote.MoviesDataSource

import kotlinx.coroutines.flow.Flow
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.prodroidmovielist.data.PagingSource
import com.example.prodroidmovielist.data.model.movies.ResultsDto

class MoviesRepositoryImpl(
    private val dataSource: MoviesDataSource,
    private val pagingSource: PagingSource,
) : MoviesRepository {
    override suspend fun movies() : Flow<PagingData<ResultsDto>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = { pagingSource }
        ).flow
    }
    override suspend fun movie(id:String) = dataSource.movie(id)

}