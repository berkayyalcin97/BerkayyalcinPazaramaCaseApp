package com.example.berkayyalcinpazaramacase.data.remote.source.impl

import com.example.berkayyalcinpazaramacase.data.model.AllProductsResponse
import com.example.berkayyalcinpazaramacase.data.remote.api.ProductsService
import com.example.berkayyalcinpazaramacase.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRemoteDataSourceImpl @Inject constructor(private val productsService: ProductsService):
BaseRemoteDataSource(),ProductsRemoteDataSource{
    override suspend fun getProduct(productId: Int): Flow<DataState<AllProductsResponse>> {
      return getResult { productsService.getProducts(productId) }
    }

}