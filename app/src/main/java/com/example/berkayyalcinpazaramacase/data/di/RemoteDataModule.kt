package com.example.berkayyalcinpazaramacase.data.di

import android.provider.SyncStateContract
import com.example.berkayyalcinpazaramacase.data.interceptor.AuthInterceptor
import com.example.berkayyalcinpazaramacase.data.remote.api.ProductsService
import com.example.berkayyalcinpazaramacase.data.remote.utils.ConStants
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

class RemoteDataModule {

    @Provides
    @Singleton
    fun provideRetrofitService(

        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory,
        baseApiUrl: String

    ): ProductsService {
        return Retrofit.Builder().baseUrl(baseApiUrl).client(okHttpClient)
            .addConverterFactory(converterFactory).build().create(ProductsService::class.java)
    }

    @Provides
    @Singleton
    fun provideBaseUrl() = ConStants.BASE_URL

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        authInterceptor: AuthInterceptor
    ) = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .addInterceptor(httpLoggingInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level=HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory() = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideFirebaseService() = FirebaseAuth.getInstance()

}