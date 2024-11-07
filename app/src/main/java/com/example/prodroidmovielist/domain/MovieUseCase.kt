package com.example.prodroidmovielist.domain

import com.example.prodroidmovielist.data.repository.MoviesRepository

class MovieUseCase (
    private val repository: MoviesRepository
) {
    suspend operator fun invoke(id:String) = repository.movie(id)
}