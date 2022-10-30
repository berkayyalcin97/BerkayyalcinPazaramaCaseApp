package com.example.berkayyalcinpazaramacase.data.interceptor

import com.example.berkayyalcinpazaramacase.data.remote.utils.ConStants
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() :Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
       val requestBuilder = chain.request()

        val newUrl = requestBuilder.url.newBuilder().
                addQueryParameter(ConStants.KEY_API_KEY, value =ConStants.API_KEY ).build()

        val newRequest = requestBuilder.newBuilder().url(newUrl).build()

        return  chain.proceed(newRequest)
    }
}