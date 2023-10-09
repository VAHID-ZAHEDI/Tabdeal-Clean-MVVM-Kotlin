package com.example.tabdeal.domain

import android.util.Log
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.tabdeal.domain.model.CryptoCurrencyEntity
import com.example.tabdeal.util.Resource
import dagger.Provides
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCryptoCurrencyUseCase @Inject constructor(
    private val cryptoRepository: CryptoRepository
) {
    operator fun invoke(): Flow<Resource<PagingData<CryptoCurrencyEntity>>> = channelFlow  {
        try {
//            cryptoRepository.getCryptoCurrencyListFromBackend()
            send(Resource.loading())

            cryptoRepository.getCryptoFromRoom().collectLatest {
                send(Resource.success(it))
            }


        } catch (e: HttpException) {
            send(Resource.error("خطا در دریافت اطلاعات"))
        } catch (e: IOException) {
            send(Resource.error("لطفا اینترنت خودرا بررسی و مجددا تلاش کتید."))
        }
    }
}