package com.example.prodroidmovielist.di

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.prodroidmovielist.PagingSource
import com.example.prodroidmovielist.data.remote.DataSource
import com.example.prodroidmovielist.data.remote.DataSourceImpl
import com.example.prodroidmovielist.data.repository.Repository
import com.example.prodroidmovielist.data.repository.RepositoryImpl
import com.example.prodroidmovielist.domain.MovieUseCase
import com.example.prodroidmovielist.domain.MoviesUseCase
import com.example.prodroidmovielist.presentation.movie.MovieViewModel
import com.example.prodroidmovielist.presentation.movies.MoviesViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

private val provideDataLayerMovies = module {
    singleOf(::DataSourceImpl) { bind<DataSource>() }
    singleOf(::RepositoryImpl) { bind<Repository>() }
}

private val provideDomainLayerMovies = module {
    singleOf(::MoviesUseCase)
    singleOf(::MovieUseCase)
}

private val providePresentationLayerMovies = module {
    viewModelOf(::MovieViewModel)
    viewModelOf(::MoviesViewModel)
    factoryOf(::PagingSource)
    single {
        PagingConfig(pageSize = 20)
    }
    single {
        Pager(config = get(), pagingSourceFactory = { get<PagingSource>() })
    }
}

val moviesModule =
    listOf(providePresentationLayerMovies, provideDomainLayerMovies, provideDataLayerMovies)