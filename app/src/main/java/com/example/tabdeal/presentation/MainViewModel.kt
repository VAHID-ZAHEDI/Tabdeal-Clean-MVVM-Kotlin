package com.example.tabdeal.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class MainViewModel(application: Application) : AndroidViewModel(application) {
}