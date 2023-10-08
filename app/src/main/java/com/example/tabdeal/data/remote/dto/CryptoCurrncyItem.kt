package com.example.tabdeal.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CryptoCurrncyItem(
    @SerializedName("symbol")
    val symbol: String = "",

    @SerializedName("created")
    val created: String = "",

    @SerializedName("usdt_volume")
    val usdtVolume: String = "",

    @SerializedName("name_fa")
    val nameFa: String = "",

    @SerializedName("change_percent")
    val changePercent: String = "",

    @SerializedName("volume")
    val volume: String = "",

    @SerializedName("markets")
    val markets: List<MarketsItem>?,

    @SerializedName("is_swappable")
    val isSwappable: Boolean = false,

    @SerializedName("price_in_usdt")
    val priceInUsdt: String = "",

    @SerializedName("name")
    val name: String = "",

    @SerializedName("id")
    val id: Int = 0
)