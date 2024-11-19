package br.com.feat_movies.data.repository


import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.feat_movies.data.ResultsDto
import br.com.feat_movies.data.remote.MoviesDataSource
import coil.network.HttpException
import java.io.IOException

class MoviesPagingSource(
    private val remoteDataSource: MoviesDataSource,
) : PagingSource<Int, ResultsDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultsDto> {
        return try {
            val currentPage = params.key ?: 1
            val result = remoteDataSource.movies(page = currentPage.toString())
            LoadResult.Page(
                data = result.results,
                nextKey = currentPage + 1,
                prevKey = null
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ResultsDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.minus(1) ?: anchorPage?.nextKey?.plus(1)
        }
    }
}