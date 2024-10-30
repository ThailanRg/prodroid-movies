package com.example.prodroidmovielist.feature.list.data.repository

import com.example.prodroidmovielist.feature.list.data.remote.DataSource

class RepositoryImpl(
    private val dataSource: DataSource
) : Repository {
    override fun getList() = dataSource.getList()

}