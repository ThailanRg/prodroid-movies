package com.example.prodroidmovielist.feature.list.data.repository

import com.example.prodroidmovielist.feature.list.data.model.MoviesDto

interface Repository {
    suspend fun getList():List<MoviesDto>
}