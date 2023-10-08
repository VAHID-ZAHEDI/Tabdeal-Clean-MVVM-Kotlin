package com.example.tabdeal.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tabdeal.data.local.CryptoCurrencyDao
import com.example.tabdeal.domain.model.CryptoCurrencyEntity

@Database(entities = [CryptoCurrencyEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCryptoCurrencyDao(): CryptoCurrencyDao

}