package com.lukninja.carsexplorer.service.repository


import com.lukninja.carsexplorer.service.model.Manufactures
import com.lukninja.carsexplorer.service.model.Models
import com.lukninja.carsexplorer.service.repository.remote.ManufacturerService
import com.lukninja.carsexplorer.service.repository.remote.ModelService
import com.lukninja.carsexplorer.service.repository.remote.RetrofitClient
import com.lukninja.carsexplorer.service.util.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ManufacturerRepository {
    private val mRemote = RetrofitClient.createService(ManufacturerService::class.java)

    suspend fun getManufactures(make: String): ApiResult<Manufactures> {
        return withContext(Dispatchers.IO) {
            try {
                val response = mRemote.getManufactures(make)

                ApiResult.Success(response.body() ?: Manufactures())
            } catch (e: Exception) {
                ApiResult.Error("Falha ao carregar fábricas", e)
            }
        }
    }
}