package com.example.tabdeal.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tabdeal.databinding.ItemCryptoBinding
import com.example.tabdeal.domain.model.CryptoCurrencyEntity

class CryptoCurrencyListAdapter :
    PagingDataAdapter<CryptoCurrencyEntity, CryptoCurrencyListAdapter.CryptoCurrencyViewHolder>(
        VISIT_DIFF_CALLBACK
    ) {

    class CryptoCurrencyViewHolder(val binding: ItemCryptoBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoCurrencyViewHolder {
        val view = ItemCryptoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CryptoCurrencyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CryptoCurrencyViewHolder, position: Int) {
        Log.d("iuiiuiued", "onCreate: ${getItem(position)?.nameFa}")

        holder.binding.nameTextView.text = getItem(position)?.nameFa
    }


    companion object {
        private val VISIT_DIFF_CALLBACK = object : DiffUtil.ItemCallback<CryptoCurrencyEntity>() {
            override fun areItemsTheSame(
                oldItem: CryptoCurrencyEntity,
                newItem: CryptoCurrencyEntity
            ): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: CryptoCurrencyEntity,
                newItem: CryptoCurrencyEntity
            ): Boolean =
                oldItem == newItem
        }


    }
}
