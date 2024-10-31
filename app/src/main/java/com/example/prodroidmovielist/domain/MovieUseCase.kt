package com.example.prodroidmovielist.domain

import com.example.prodroidmovielist.data.repository.Repository

class MovieUseCase (
    private val repository: Repository
) {
    suspend operator fun invoke(id:String) = repository.movie(id)
}