package com.lukninja.carsexplorer.service.repository


import com.lukninja.carsexplorer.service.model.Make
import com.lukninja.carsexplorer.service.repository.remote.MakeService
import com.lukninja.carsexplorer.service.repository.remote.RetrofitClient
import com.lukninja.carsexplorer.service.util.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MakeRepository {

    private val mRemote = RetrofitClient.createService(MakeService::class.java)

    suspend fun getMakes(): ApiResult<List<Make>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = mRemote.getMakes()

                ApiResult.Success(response.body()?.makes ?: listOf())
            } catch (e: Exception) {
                ApiResult.Error("Falha ao carregar marcas", e)
            }
        }
    }
}