package com.tilda.data

import retrofit2.http.GET

interface Api {

    @GET("currentprice.json")
    suspend fun getCurrentPrice(): Price
}