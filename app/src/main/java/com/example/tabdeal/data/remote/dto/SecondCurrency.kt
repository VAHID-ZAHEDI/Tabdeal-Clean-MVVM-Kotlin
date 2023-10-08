package com.example.tabdeal.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SecondCurrency(

    @SerializedName("symbol")
    val symbol: String = "",

    @SerializedName("name")
    val name: String = "",

    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("name_fa")
    val nameFa: String = ""
)