package com.example.tabdeal.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.tabdeal.data.local.CryptoCurrencyDao
import com.example.tabdeal.data.remote.MainApiService
import com.example.tabdeal.data.remote.dto.CryptoCurrencyItemDto
import com.example.tabdeal.data.remote.dto.toCryptoCurrencyEntity
import com.example.tabdeal.domain.CryptoRepository
import com.example.tabdeal.domain.model.CryptoCurrencyEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val mainApiService: MainApiService,
    private val cryptoCurrencyDao: CryptoCurrencyDao
) : CryptoRepository {

    override suspend fun getCryptoCurrencyListFromBackend(): List<CryptoCurrencyItemDto> {
        try {
            val remoteData = mainApiService.getCryptoCurrencyData()

            cryptoCurrencyDao.insertAll(remoteData.map { it.toCryptoCurrencyEntity() })

            return remoteData
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getCryptoFromRoom(): Flow<PagingData<CryptoCurrencyEntity>> {
        return Pager(
            config = PagingConfig(pageSize = 5),
            pagingSourceFactory = {
//                CryptoPagingSource(cryptoCurrencyDao)
                cryptoCurrencyDao.getAllCryptoData()
            }
        ).flow


    }


    override suspend fun insertCryptoCurrencyToRoom(cryptoItem: List<CryptoCurrencyEntity>) {
        cryptoCurrencyDao.insertAll(cryptoItem)
    }
}