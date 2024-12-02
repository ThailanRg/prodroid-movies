package br.com.feat_movie.data.remote

import br.com.core_network.getRequest
import br.com.feat_movie.data.model.MovieDto

class MovieDataSourceImpl : MovieDataSource {
    override suspend fun movie(id: String) = getRequest<MovieDto>(endpoint = id)
}
