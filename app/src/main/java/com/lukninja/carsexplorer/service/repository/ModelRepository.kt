package com.lukninja.carsexplorer.service.repository


import android.util.Log
import com.lukninja.carsexplorer.service.model.dto.ModelDto
import com.lukninja.carsexplorer.service.model.dto.ModelsDto
import com.lukninja.carsexplorer.service.model.dto.toEntity
import com.lukninja.carsexplorer.service.model.entity.ModelEntity
import com.lukninja.carsexplorer.service.repository.local.ManufacturerDao
import com.lukninja.carsexplorer.service.repository.local.ModelDao
import com.lukninja.carsexplorer.service.repository.remote.CarsExplorerApi
import com.lukninja.carsexplorer.service.util.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ModelRepository @Inject constructor (
    private val api: CarsExplorerApi,
    private val modelDao: ModelDao
) {

    suspend fun getModels(make: String): ApiResult<List<ModelEntity>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getModels(make).body()?.models

                val entities = response?.map {
                    it.toEntity(it.id)
                } ?: run {
                    listOf()
                }

                if (entities.isNotEmpty())
                    modelDao.insertAll(entities)

                Log.i("Manufactures", "com internet")

                ApiResult.Success(entities)
            } catch (e: Exception) {
                val entities = modelDao.getModelsByMake(make)

                Log.i("Models", "sem internet - $e")

                if (entities.isEmpty()) {
                    ApiResult.Error("Falha ao carregar modelos", e)
                } else {
                    ApiResult.Success(entities)
                }
            }
        }
    }
}