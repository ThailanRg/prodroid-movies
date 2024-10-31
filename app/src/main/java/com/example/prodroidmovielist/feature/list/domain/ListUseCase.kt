package com.example.prodroidmovielist.feature.list.domain

import com.example.prodroidmovielist.feature.list.data.repository.Repository

class ListUseCase (
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.getList()
}