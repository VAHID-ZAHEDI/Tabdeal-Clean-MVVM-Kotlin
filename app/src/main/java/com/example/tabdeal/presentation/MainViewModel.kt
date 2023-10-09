package com.example.tabdeal.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tabdeal.domain.GetCryptoCurrencyUseCase
import com.example.tabdeal.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCryptoCurrencyUseCase: GetCryptoCurrencyUseCase,
    val app: Application

) : AndroidViewModel(app) {




     fun getCryptoCurrencyList() = getCryptoCurrencyUseCase()

}