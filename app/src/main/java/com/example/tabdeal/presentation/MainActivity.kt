package com.example.tabdeal.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tabdeal.databinding.ActivityMainBinding
import com.example.tabdeal.presentation.adapter.CryptoCurrencyListAdapter
import com.example.tabdeal.util.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val cryptoCurrencyListAdapter = CryptoCurrencyListAdapter()
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initCryptoRecyclerView()
        lifecycleScope.launch {
            mainViewModel.getCryptoCurrencyList().collectLatest {
                when (it.status) {

                    Status.LOADING -> {
                        binding.swipRefresh.isRefreshing = true
                    }

                    Status.SUCCESS -> {
                        binding.swipRefresh.isRefreshing = false
                        it.data?.let { cryptoCurrencyPagingData ->
                            cryptoCurrencyListAdapter.submitData(cryptoCurrencyPagingData)
                        }
                    }

                    Status.ERROR -> {
                        binding.swipRefresh.isRefreshing = false


                    }

                    else -> {}
                }
            }

        }


    }

    private fun initCryptoRecyclerView() {
        binding.cryptoRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = cryptoCurrencyListAdapter
        }
    }
}