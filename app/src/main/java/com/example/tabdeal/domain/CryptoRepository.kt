package com.example.tabdeal.domain

import androidx.paging.PagingSource
import com.example.tabdeal.data.remote.dto.CryptoCurrencyItemDto
import com.example.tabdeal.domain.model.CryptoCurrencyEntity

interface CryptoRepository {
    suspend fun getCryptoCurrencyListFromBackend(): List<CryptoCurrencyItemDto>
    suspend fun getCryptoFromRoom(): PagingSource<Int, CryptoCurrencyEntity>
    suspend fun insertCryptoCurrencyToRoom(cryptoItem: List<CryptoCurrencyEntity>)
}