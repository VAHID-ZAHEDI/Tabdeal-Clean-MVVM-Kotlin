//package com.example.tabdeal.presentation.adapter
//
//import android.util.Log
//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//import com.example.tabdeal.data.local.CryptoCurrencyDao
//import com.example.tabdeal.domain.model.CryptoCurrencyEntity
//import retrofit2.HttpException
//
//const val STARTING_KEY = 1
//
//class CryptoPagingSource(val cryptoCurrencyDao: CryptoCurrencyDao) :
//    PagingSource<Int, CryptoCurrencyEntity>() {
//    override fun getRefreshKey(state: PagingState<Int, CryptoCurrencyEntity>): Int? {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CryptoCurrencyEntity> {
//        try {
//            val page = params.key ?: STARTING_KEY
//            val response = cryptoCurrencyDao.getAllCryptoData(
//                pageSize = page,
//                offset = params.loadSize
//            )
//            Log.d("uiccc", "load: ${response[0].nameFa}")
//            return LoadResult.Page(
//
//                data = response.toList(),
//
//                prevKey = if (page == STARTING_KEY) null else page.minus(1),
//
//                nextKey = if (response.isEmpty()) null else page.plus(1)
//            )
//        } catch (e: Exception) {
//            return LoadResult.Error(e)
//        } catch (e: HttpException) {
//
//            return LoadResult.Error(e)
//        }
//
//        return LoadResult.Error(Exception("Failed to load data"))
//    }
//}