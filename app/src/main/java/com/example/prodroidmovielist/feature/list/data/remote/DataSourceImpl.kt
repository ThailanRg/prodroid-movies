package com.example.prodroidmovielist.feature.list.data.remote

import com.example.prodroidmovielist.feature.list.data.model.MovieDto

class DataSourceImpl : DataSource {

    override fun getList(): List<MovieDto> {
       return emptyList()
    }

}