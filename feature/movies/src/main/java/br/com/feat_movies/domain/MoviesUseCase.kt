package br.com.feat_movies.domain

import br.com.feat_movies.data.repository.MoviesRepository

class MoviesUseCase (
    private val repository: MoviesRepository
) {
    suspend operator fun invoke() = repository.movies()
}