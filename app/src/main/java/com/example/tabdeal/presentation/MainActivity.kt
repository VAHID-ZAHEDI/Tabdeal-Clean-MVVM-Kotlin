package com.example.tabdeal.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.tabdeal.databinding.ActivityMainBinding
import com.example.tabdeal.util.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launch {
            mainViewModel.getCryptoCurrencyList().collectLatest {
                when (it.status) {

                    Status.LOADING -> {}

                    Status.SUCCESS -> {
                        Log.d("sssfff", "onCreate: ${it.data}")
                    }

                    Status.ERROR -> {

                    }

                    else -> {}
                }
            }

        }


    }
}