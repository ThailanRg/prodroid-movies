package br.com.feat_movies.data.remote

import br.com.core_network.getRequest
import br.com.feat_movies.data.MoviesDto



class MoviesDataSourceImpl : MoviesDataSource {

    override suspend fun movies(page: String): MoviesDto {
        return getRequest<MoviesDto>(END_POINT_LIST, page)
    }

    companion object {
        const val END_POINT_LIST = "popular"
    }

}
