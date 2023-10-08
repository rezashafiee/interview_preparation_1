package com.tilda.data

import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("bpi")
    val bpi: BPI?
)

data class BPI(
    @SerializedName("EUR")
    val eur: EUR?
)

data class EUR(
    @SerializedName("rate")
    val rate: String?
)