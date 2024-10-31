package com.example.prodroidmovielist.data.repository

import com.example.prodroidmovielist.data.remote.DataSource

class RepositoryImpl(
    private val dataSource: DataSource
) : Repository {
    override suspend fun movies() = dataSource.movies()
    override suspend fun movie(id:String) = dataSource.movie(id)

}