package com.example.tabdeal.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CryptoCurrencyEntity(
    @PrimaryKey
    val id:Int,
    val nameFa: String? = "",
    val enName: String? = "",
    val price: String? = "",
    val symbol: String? = ""

)
