package com.example.tabdeal.util

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
@Keep
data class ErrorModel(
    @SerializedName("result_code")
    var resultCode: String,
    @SerializedName("result_message")
    var resultMessage: String,
    @SerializedName("result_message_fa")
    val resultMessageFa: String? = null

) {

}
