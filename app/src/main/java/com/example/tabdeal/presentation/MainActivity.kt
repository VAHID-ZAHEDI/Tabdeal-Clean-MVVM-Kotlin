package com.example.tabdeal.presentation

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tabdeal.databinding.ActivityMainBinding
import com.example.tabdeal.presentation.adapter.CryptoCurrencyListAdapter
import com.example.tabdeal.util.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val cryptoCurrencyListAdapter = CryptoCurrencyListAdapter()
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

//    override fun attachBaseContext(newBase: Context?) {
//        super.attachBaseContext(newBase?.let { ViewPumpContextWrapper.wrap(it) })
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initCryptoRecyclerView()
        refreshList()
        retryToGetCryptoCurrencyData()
        lifecycleScope.launch {
            collectCryptoData()
            handleLoading()

        }

    }

    private fun retryToGetCryptoCurrencyData() {
        binding.retryButton.setOnClickListener {
            cryptoCurrencyListAdapter.retry()
        }
    }

    private suspend fun handleLoading() {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            cryptoCurrencyListAdapter.loadStateFlow.collectLatest {
                binding.swipRefresh.isRefreshing = it.source.prepend is LoadState.Loading

            }
        }
    }

    private fun refreshList() {
        binding.swipRefresh.setOnRefreshListener {
            cryptoCurrencyListAdapter.refresh()
        }
    }

    private suspend fun collectCryptoData() {
        mainViewModel.getCryptoCurrencyList().collectLatest {
            when (it.status) {

                Status.LOADING -> {
                    binding.swipRefresh.isRefreshing = true
                }

                Status.SUCCESS -> {
                    binding.cryptoRecyclerView.visibility = View.VISIBLE
                    binding.retryButton.visibility = View.GONE
                    binding.swipRefresh.isRefreshing = false
                    it.data?.let { cryptoCurrencyPagingData ->
                        cryptoCurrencyListAdapter.submitData(cryptoCurrencyPagingData)
                    }
                }

                Status.ERROR -> {
                    binding.cryptoRecyclerView.visibility = View.GONE
                    binding.retryButton.visibility = View.VISIBLE
                    binding.swipRefresh.isRefreshing = false


                }

                else -> {}
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