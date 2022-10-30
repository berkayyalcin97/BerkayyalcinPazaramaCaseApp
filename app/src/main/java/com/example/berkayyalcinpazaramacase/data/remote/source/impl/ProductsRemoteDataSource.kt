package com.example.berkayyalcinpazaramacase.data.remote.source.impl

import android.provider.ContactsContract
import com.example.berkayyalcinpazaramacase.data.model.AllProductsResponse
import com.example.berkayyalcinpazaramacase.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow

interface ProductsRemoteDataSource {
    suspend fun getProduct(productId :Int):Flow<DataState<AllProductsResponse>>
}