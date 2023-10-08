package com.example.tabdeal.util

import androidx.annotation.Keep

@Keep
class Resource<T> private constructor(val status: Status, val data: T?, val error: String?) {
    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> loading(): Resource<T> {
            return Resource(Status.LOADING, null, null)
        }

        fun <T> error(errorMsg: String): Resource<T> {
            return Resource(Status.ERROR, null, errorMsg)
        }

        fun <T> emptyList(): Resource<T> {
            return Resource(Status.NOTHING, null, null)
        }
    }
}