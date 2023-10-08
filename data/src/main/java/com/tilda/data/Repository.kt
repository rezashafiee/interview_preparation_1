package com.tilda.data

class Repository {

    suspend fun getPrice(api: Api): Price {
        return api.getCurrentPrice()
    }
}