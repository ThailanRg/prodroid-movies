package com.example.prodroidmovielist.feature.list.di

import org.koin.dsl.module
import com.example.prodroidmovielist.feature.list.domain.ListUseCase
import com.example.prodroidmovielist.feature.list.data.remote.DataSource
import com.example.prodroidmovielist.feature.list.data.remote.DataSourceImpl
import com.example.prodroidmovielist.feature.list.data.repository.Repository
import com.example.prodroidmovielist.feature.list.data.repository.RepositoryImpl
import com.example.prodroidmovielist.feature.list.presentation.ListViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf

private val provideDataLayerList = module {
    singleOf(::DataSourceImpl) { bind<DataSource>() }
    singleOf(::RepositoryImpl) { bind<Repository>() }
}

private val provideDomainLayerList = module {
    singleOf(::ListUseCase)
}

private val providePresentationLayerList = module {
    viewModelOf(::ListViewModel)
}

val loginModule = listOf(providePresentationLayerList, provideDomainLayerList, provideDataLayerList)