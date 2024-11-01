package com.example.prodroidmovielist.data.repository

import androidx.paging.PagingData
import com.example.prodroidmovielist.data.model.movie.MovieDto
import com.example.prodroidmovielist.data.model.movies.ResultsDto
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun movies(): Flow<PagingData<ResultsDto>>
    suspend fun movie(id:String): MovieDto
}