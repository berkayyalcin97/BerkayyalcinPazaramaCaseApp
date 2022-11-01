package com.example.berkayyalcinpazaramacase.data.di

import android.content.Context
import com.example.berkayyalcinpazaramacase.data.local.DataStoreManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideDataStoreManager(@ApplicationContext appContext: Context): DataStoreManager =
        DataStoreManager(appContext)
}