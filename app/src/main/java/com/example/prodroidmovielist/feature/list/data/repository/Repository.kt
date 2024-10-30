package com.example.prodroidmovielist.feature.list.data.repository

import com.example.prodroidmovielist.feature.list.data.model.MovieDto

interface Repository {
    fun getList():List<MovieDto>
}