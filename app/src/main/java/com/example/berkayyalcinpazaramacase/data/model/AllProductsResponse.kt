package com.example.berkayyalcinpazaramacase.data.model

import com.google.gson.annotations.SerializedName


class AllProductsResponse(
    @SerializedName("results")
    val results:List<AllProduct?>?
)