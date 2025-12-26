package com.lukninja.carsexplorer.service.repository


import android.util.Log
import com.lukninja.carsexplorer.service.model.dto.MakeDto
import com.lukninja.carsexplorer.service.model.dto.toEntity
import com.lukninja.carsexplorer.service.model.entity.MakeEntity
import com.lukninja.carsexplorer.service.repository.local.DatabaseProvider
import com.lukninja.carsexplorer.service.repository.local.MakeDao
import com.lukninja.carsexplorer.service.repository.remote.MakeService
import com.lukninja.carsexplorer.service.repository.remote.RetrofitClient
import com.lukninja.carsexplorer.service.util.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MakeRepository(private val makeDao: MakeDao) {

    private val mRemote = RetrofitClient.createService(MakeService::class.java)


    suspend fun getMakes(): ApiResult<List<MakeEntity>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = mRemote.getMakesForVehicleType().body()?.makes

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