package com.lukninja.carsexplorer.service.repository


import android.util.Log
import com.lukninja.carsexplorer.service.model.dto.toEntity
import com.lukninja.carsexplorer.service.model.entity.MakeEntity
import com.lukninja.carsexplorer.service.repository.local.MakeDao
import com.lukninja.carsexplorer.service.repository.remote.CarsExplorerApi
import com.lukninja.carsexplorer.service.util.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MakeRepository @Inject constructor (
    private val api: CarsExplorerApi,
    private val makeDao: MakeDao,
) {

    suspend fun getMakes(): ApiResult<List<MakeEntity>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getMakesForVehicleType().body()?.makes

                val entities = response?.map {
                    it.toEntity(it.id)
                } ?: run {
                    listOf()
                }

                if (entities.isNotEmpty())
                    makeDao.insertAll(entities)

                Log.i("Makes", "com internet")

                ApiResult.Success(entities)
            } catch (e: Exception) {
                val entities = makeDao.getAllMakes()
                Log.i("Makes", "sem internet")

                if (entities.isEmpty()) {
                    ApiResult.Error("Falha ao carregar marcas", e)
                } else {
                    ApiResult.Success(entities)
                }
            }
        }
    }
}