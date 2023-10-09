package com.example.tabdeal.data.local

import androidx.paging.DataSource
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tabdeal.domain.model.CryptoCurrencyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CryptoCurrencyDao {

    @Query("SELECT * FROM CryptoCurrencyEntity LIMIT :pageSize OFFSET :offset")
    fun getAllCryptoData(pageSize: Int, offset: Int): List<CryptoCurrencyEntity>

    //    @Query("SELECT * FROM CryptoCurrencyEntity")
//    fun getAllCryptoData(): PagingSource<Int, CryptoCurrencyEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cryptoList: List<CryptoCurrencyEntity>)
}