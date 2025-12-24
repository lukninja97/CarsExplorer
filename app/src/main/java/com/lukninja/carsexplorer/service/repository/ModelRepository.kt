package com.lukninja.carsexplorer.service.repository


import com.lukninja.carsexplorer.service.model.Models
import com.lukninja.carsexplorer.service.repository.remote.ModelService
import com.lukninja.carsexplorer.service.repository.remote.RetrofitClient
import com.lukninja.carsexplorer.service.util.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ModelRepository {
    private val mRemote = RetrofitClient.createService(ModelService::class.java)

    suspend fun getModels(make: String): ApiResult<Models> {
        return withContext(Dispatchers.IO) {
            try {
                val response = mRemote.getModels(make)

                ApiResult.Success(response.body() ?: Models())
            } catch (e: Exception) {
                ApiResult.Error("Falha ao carregar modelos", e)
            }
        }
    }
}