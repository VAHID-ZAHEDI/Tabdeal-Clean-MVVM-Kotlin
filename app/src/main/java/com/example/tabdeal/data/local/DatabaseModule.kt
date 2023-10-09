package com.example.tabdeal.data.local

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
//    @Provides
//    @Singleton
//    fun provideDatabase(@ApplicationContext appContext: Context) = Room.databaseBuilder(
//        appContext,
//        AppDatabase::class.java, "AppDatabase"
//    ).allowMainThreadQueries().fallbackToDestructiveMigration().build()



}