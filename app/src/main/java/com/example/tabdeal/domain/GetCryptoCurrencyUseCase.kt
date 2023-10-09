package com.example.tabdeal.domain

import com.example.tabdeal.util.Resource
import dagger.Provides
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
class GetCryptoCurrencyUseCase @Inject constructor(
    private val cryptoRepository: CryptoRepository
) {
     operator fun invoke() = flow {
        try {
            emit(Resource.loading())
            val crypto = cryptoRepository.getCryptoFromRoom()
            cryptoRepository.getCryptoCurrencyListFromBackend()
            emit(Resource.success(crypto))
        } catch (e: HttpException) {
            emit(Resource.error("خطا در دریافت اطلاعات"))
        } catch (e: IOException) {
            emit(Resource.error("لطفا اینترنت خودرا بررسی و مجددا تلاش کتید."))
        }
    }
}