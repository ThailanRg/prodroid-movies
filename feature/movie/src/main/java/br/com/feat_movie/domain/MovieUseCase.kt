package br.com.feat_movie.domain

import br.com.feat_movie.data.repository.MovieRepository

class MovieUseCase (
    private val repository: MovieRepository
) {
    suspend operator fun invoke(id:String) = repository.movie(id)
}