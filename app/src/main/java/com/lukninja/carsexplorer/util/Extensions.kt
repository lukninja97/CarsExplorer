package com.lukninja.carsexplorer.util

import androidx.lifecycle.MutableLiveData
import com.lukninja.carsexplorer.service.util.ApiResult

suspend fun <T> MutableLiveData<ApiResult<T>>.safeApiCall(call: suspend () -> ApiResult<T>) {
    this.postValue(ApiResult.Loading)
    try {
        this.postValue(call())
    } catch (e: Exception) {
        this.postValue(ApiResult.Error("Ocorreu um erro inesperado", e))
    }
}