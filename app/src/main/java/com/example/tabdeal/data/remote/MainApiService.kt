package com.example.tabdeal.data.remote

import com.example.tabdeal.data.remote.dto.CryptoCurrencyItemDto
import retrofit2.http.GET

interface MainApiService {
    @GET("r/plots/currency_prices")
    suspend fun getCryptoCurrencyData(): List<CryptoCurrencyItemDto>
}