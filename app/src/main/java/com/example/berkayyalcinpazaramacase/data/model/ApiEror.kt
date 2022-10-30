package com.example.berkayyalcinpazaramacase.data.model

import com.google.gson.annotations.SerializedName

data class ApiEror (

    @SerializedName("status_code")
    val status_code :Long,
    @SerializedName("status_message")
    val status_message: String
    )

