package com.example.prodroidmovielist.feature.list.data.remote

import com.example.prodroidmovielist.feature.list.data.model.MovieDto

interface DataSource {
    fun getList():List<MovieDto>
}