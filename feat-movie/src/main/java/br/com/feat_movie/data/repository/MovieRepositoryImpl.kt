package br.com.feat_movie.data.repository

import br.com.feat_movie.data.remote.MovieDataSource

class MovieRepositoryImpl(
    private val dataSource: MovieDataSource,
) : MovieRepository {
    override suspend fun movie(id: String) = dataSource.movie(id)

}