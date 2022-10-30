package com.example.berkayyalcinpazaramacase.domain

import com.example.berkayyalcinpazaramacase.data.model.AllProductsResponse
import com.example.berkayyalcinpazaramacase.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    suspend fun getProductsDetail(productId: Int) :Flow<DataState<AllProductsResponse>>
}