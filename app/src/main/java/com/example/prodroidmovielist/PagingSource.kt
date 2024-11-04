package com.example.prodroidmovielist

import androidx.paging.PagingSource
import androidx.paging.PagingState
import coil.network.HttpException
import com.example.prodroidmovielist.data.model.movies.ResultsDto
import com.example.prodroidmovielist.data.remote.DataSource
import kotlinx.io.IOException

class PagingSource(
    private val remoteDataSource: DataSource,
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