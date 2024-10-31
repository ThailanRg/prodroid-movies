package com.example.prodroidmovielist.domain

import com.example.prodroidmovielist.data.repository.Repository

class MoviesUseCase (
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.movies()
}