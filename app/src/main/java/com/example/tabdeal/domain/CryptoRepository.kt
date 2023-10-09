package com.example.tabdeal.domain

import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.example.tabdeal.data.remote.dto.CryptoCurrencyItemDto
import com.example.tabdeal.domain.model.CryptoCurrencyEntity
import dagger.Provides
import kotlinx.coroutines.flow.Flow

interface CryptoRepository {
    suspend fun getCryptoCurrencyListFromBackend(): List<CryptoCurrencyItemDto>
    suspend fun getCryptoFromRoom(): Flow<PagingData<CryptoCurrencyEntity>>
    suspend fun insertCryptoCurrencyToRoom(cryptoItem: List<CryptoCurrencyEntity>)
}