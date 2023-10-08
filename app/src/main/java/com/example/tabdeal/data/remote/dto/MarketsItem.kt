package com.example.tabdeal.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MarketsItem(
    @SerializedName("symbol")
    val symbol: String = "",

    @SerializedName("last_trade_price")
    val lastTradePrice: String = "",

    @SerializedName("leverage")
    val leverage: String = "",

    @SerializedName("market_last_trade_price")
    val marketLastTradePrice: String = "",

    @SerializedName("market_last_trade_price_v2")
    val marketLastTradePriceV: String = "",

    @SerializedName("usdt_volume")
    val usdtVolume: String = "",

    @SerializedName("first_currency")
    val firstCurrency: FirstCurrency,

    @SerializedName("first_currency_precision")
    val firstCurrencyPrecision: Int = 0,

    @SerializedName("spot_grid_bot_active")
    val spotGridBotActive: Boolean = false,

    @SerializedName("name_fa")
    val nameFa: String = "",

    @SerializedName("change_percent")
    val changePercent: String = "",

    @SerializedName("price_precision")
    val pricePrecision: Int = 0,

    @SerializedName("volume")
    val volume: String = "",

    @SerializedName("high")
    val high: String = "",

    @SerializedName("second_currency")
    val secondCurrency: SecondCurrency,

    @SerializedName("low")
    val low: String = "",

    @SerializedName("enable")
    val enable: Boolean = false,

    @SerializedName("price")
    val price: String = "",

    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("margin_isolated_trade")
    val marginIsolatedTrade: Boolean = false
)