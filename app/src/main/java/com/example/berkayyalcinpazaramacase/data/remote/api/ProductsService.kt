package com.example.berkayyalcinpazaramacase.data.remote.api

import com.example.berkayyalcinpazaramacase.data.model.AllProductsResponse
import retrofit2.http.GET
import retrofit2.Response

interface ProductsService {

    @GET("products")
    suspend fun getProducts(productId: Int): Response<AllProductsResponse>

}