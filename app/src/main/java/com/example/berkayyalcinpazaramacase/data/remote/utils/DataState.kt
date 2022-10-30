package com.example.berkayyalcinpazaramacase.data.remote.utils

import com.example.berkayyalcinpazaramacase.data.model.ApiEror


sealed class DataState<T>{

    data class Success<T>(val data: T) : DataState<T>()
    data class Eror<T>(val api: ApiEror) : DataState<T>()
    data class Loading<T>(val data: T? = null) : DataState<T>()

}