package com.example.tabdeal.di

import android.app.Application
import androidx.room.Room
import com.example.tabdeal.data.CryptoRepositoryImpl
import com.example.tabdeal.data.local.CryptoCurrencyDao
import com.example.tabdeal.data.remote.MainApiService
import com.example.tabdeal.domain.CryptoRepository
import com.example.tabdeal.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideCryptoRepository(
        mainApiService: MainApiService,
        cryptoCurrencyDao: CryptoCurrencyDao
    ): CryptoRepository {
        return CryptoRepositoryImpl(mainApiService, cryptoCurrencyDao)
    }

    @Provides
    @Singleton
    fun provideCryptoCurrencyDao(application: Application): CryptoCurrencyDao {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            "appDatabase"
        )
            .fallbackToDestructiveMigration()
            .build()
            .getCryptoCurrencyDao()
    }
}