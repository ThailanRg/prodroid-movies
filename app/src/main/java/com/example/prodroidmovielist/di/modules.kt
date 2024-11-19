package com.example.prodroidmovielist.di

import androidx.paging.Pager
import androidx.paging.PagingConfig
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.koin.core.module.dsl.bind

import br.com.feat_movie.domain.MovieUseCase
import br.com.feat_movie.data.remote.MovieDataSourceImpl
import br.com.feat_movie.data.remote.MovieDataSource
import br.com.feat_movie.presentation.viewmodel.MovieViewModel
import br.com.feat_movie.data.repository.MovieRepository
import br.com.feat_movie.data.repository.MovieRepositoryImpl

import br.com.feat_movies.domain.MoviesUseCase
import br.com.feat_movies.data.remote.MoviesDataSourceImpl
import br.com.feat_movies.data.remote.MoviesDataSource
import br.com.feat_movies.data.repository.MoviesPagingSource
import br.com.feat_movies.presentation.viewmodel.MoviesViewModel
import br.com.feat_movies.data.repository.MoviesRepository
import br.com.feat_movies.data.repository.MoviesRepositoryImpl

private val provideDataLayerMovies = module {
    singleOf(::MovieDataSourceImpl) { bind<MovieDataSource>() }
    singleOf(::MovieRepositoryImpl) { bind<MovieRepository>() }

    singleOf(::MoviesDataSourceImpl) { bind<MoviesDataSource>() }
    singleOf(::MoviesRepositoryImpl) { bind<MoviesRepository>() }
}

private val provideDomainLayerMovies = module {
    factoryOf(::MovieUseCase)
    factoryOf(::MoviesUseCase)
}

private val providePresentationLayerMovies = module {
    viewModelOf(::MovieViewModel)
    viewModelOf(::MoviesViewModel)
    factoryOf(::MoviesPagingSource)
    single { PagingConfig(pageSize = 10) }
    single {
        Pager(
            config = get(),
            pagingSourceFactory = { get<MoviesPagingSource>() }
        )
    }
}

val moviesModule =
    listOf(providePresentationLayerMovies, provideDomainLayerMovies, provideDataLayerMovies)