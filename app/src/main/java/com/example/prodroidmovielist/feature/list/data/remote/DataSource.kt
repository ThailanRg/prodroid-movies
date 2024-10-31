package com.example.prodroidmovielist.feature.list.data.remote

import com.example.prodroidmovielist.feature.list.data.model.MoviesDto

interface DataSource {
    suspend fun getList():List<MoviesDto>
}