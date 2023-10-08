package com.tilda.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {

    fun getInstance(): Retrofit = Retrofit.Builder().apply {
        baseUrl("https://api.coindesk.com/v1/bpi/")
        addConverterFactory(GsonConverterFactory.create())
    }.build()
}