package com.example.berkayyalcinpazaramacase.domain.repository.impl

import com.example.berkayyalcinpazaramacase.data.model.AllProductsResponse
import com.example.berkayyalcinpazaramacase.data.remote.source.impl.ProductsRemoteDataSource
import com.example.berkayyalcinpazaramacase.data.remote.utils.DataState
import com.example.berkayyalcinpazaramacase.domain.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class ProductsRepositoryImpl @Inject constructor(private val productsRemoteDataSource: ProductsRemoteDataSource):
    ProductsRepository {

    override suspend fun getProductsDetail(productId: Int): Flow<DataState<AllProductsResponse>> {
        return productsRemoteDataSource.getProduct(productId)
    }
}
