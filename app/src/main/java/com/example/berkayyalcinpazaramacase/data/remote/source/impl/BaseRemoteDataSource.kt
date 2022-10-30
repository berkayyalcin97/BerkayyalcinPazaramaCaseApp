package com.example.berkayyalcinpazaramacase.data.remote.source.impl

import com.example.berkayyalcinpazaramacase.data.model.ApiEror
import com.example.berkayyalcinpazaramacase.data.remote.utils.DataState
import com.google.android.gms.common.api.Response
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import java.util.concurrent.Flow


open class BaseRemoteDataSource {
    suspend fun <T> getResult(call: suspend () -> retrofit2.Response<T>): kotlinx.coroutines.flow.Flow<DataState<T>> {
        return flow<DataState<T>> {
            val response = call()

            if (response.isSuccessful) {
                val body = response.body()

                if (body != null) emit(DataState.Success(body))
                else {
                    val apiError: ApiEror =
                        Gson().fromJson(response.errorBody()?.charStream(), ApiEror::class.java)
                    emit(DataState.Eror(apiError))
                }
            } else {
                val apiError: ApiEror =
                    Gson().fromJson(response.errorBody()?.charStream(), ApiEror::class.java)
                emit(DataState.Eror(apiError))
            }
        }.catch { e ->
            emit(DataState.Eror(ApiEror(-1, e.message ?: "Unknown Error")))
        }.onStart { emit(DataState.Loading()) }
            .flowOn(Dispatchers.IO)
    }
}