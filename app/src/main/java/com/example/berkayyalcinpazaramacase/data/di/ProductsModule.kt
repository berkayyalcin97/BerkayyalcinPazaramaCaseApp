package com.example.berkayyalcinpazaramacase.data.di

import com.example.berkayyalcinpazaramacase.data.remote.api.ProductsService
import com.example.berkayyalcinpazaramacase.data.remote.source.impl.ProductsRemoteDataSource
import com.example.berkayyalcinpazaramacase.data.remote.source.impl.ProductsRemoteDataSourceImpl
import com.example.berkayyalcinpazaramacase.domain.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)


class ProductsModule {


    @Singleton
    @Provides
    fun provideProductsService(retrofit: Retrofit) = retrofit.create(ProductsService::class.java)

    @Singleton
    @Provides
    fun provideProductsRemoteDataSource(productsService: ProductsService): ProductsRemoteDataSource =
        ProductsRemoteDataSourceImpl(productsService)

    //@Singleton
   // @Provides
    //fun provideProductsRepository(productsRemoteDataSource: ProductsRemoteDataSource): ProductsRepository =
       // ProductsRemoteDataSourceImpl(productsRemoteDataSource)
}