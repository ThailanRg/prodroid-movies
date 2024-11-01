package com.example.prodroidmovielist.data.repository

import com.example.prodroidmovielist.data.remote.DataSource

import kotlinx.coroutines.flow.Flow
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.prodroidmovielist.PagingSource
import com.example.prodroidmovielist.data.model.movies.ResultsDto

class RepositoryImpl(
    private val dataSource: DataSource,
    private val pagingSource: PagingSource,
) : Repository {
    override suspend fun movies() : Flow<PagingData<ResultsDto>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { pagingSource }
        ).flow
    }
    override suspend fun movie(id:String) = dataSource.movie(id)

}