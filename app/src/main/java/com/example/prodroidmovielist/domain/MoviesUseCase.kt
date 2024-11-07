package com.example.prodroidmovielist.domain

import com.example.prodroidmovielist.data.repository.MoviesRepository

class MoviesUseCase (
    private val repository: MoviesRepository
) {
    suspend operator fun invoke() = repository.movies()
}