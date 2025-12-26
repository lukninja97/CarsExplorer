package com.lukninja.carsexplorer.service.repository


import android.util.Log
import com.lukninja.carsexplorer.service.model.dto.ManufacturerDto
import com.lukninja.carsexplorer.service.model.dto.toEntity
import com.lukninja.carsexplorer.service.model.entity.ManufacturerEntity
import com.lukninja.carsexplorer.service.repository.local.ManufacturerDao
import com.lukninja.carsexplorer.service.repository.remote.CarsExplorerApi
import com.lukninja.carsexplorer.service.util.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ManufacturerRepository @Inject constructor(
    private val api: CarsExplorerApi,
    private val manufacturerDao: ManufacturerDao
) {

    suspend fun getManufactures(make: String): ApiResult<List<ManufacturerEntity>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getManufactures(make).body()?.manufactures

                val entities = response?.map {
                    it.toEntity(it.manufacturerId, make)
                } ?: run {
                    listOf()
                }

                if (entities.isNotEmpty())
                    manufacturerDao.insertAll(entities)

                Log.i("Manufactures", "com internet")

                ApiResult.Success(entities)
            } catch (e: Exception) {
                val entities = manufacturerDao.getManufacturesByMake(make)
                Log.i("Manufactures", "sem internet")

                if (entities.isEmpty()) {
                    ApiResult.Error("Falha ao carregar fábricas", e)
                } else {
                    ApiResult.Success(entities)
                }
            }
        }
    }

    suspend fun getManufacturer(manufacturerId: Int): ApiResult<ManufacturerEntity> {
        return withContext(Dispatchers.IO) {
            try {
                val manufacturer = manufacturerDao.getManufacturerById(manufacturerId)

                ApiResult.Success(manufacturer)
            } catch (e: Exception) {
                ApiResult.Error("Falha ao carregar fábrica", e)
            }
        }
    }

}