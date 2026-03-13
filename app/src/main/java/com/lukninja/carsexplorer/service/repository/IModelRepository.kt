package com.lukninja.carsexplorer.service.repository

import com.lukninja.carsexplorer.service.model.entity.ModelEntity
import com.lukninja.carsexplorer.service.util.ApiResult

interface IModelRepository {
    suspend fun getModels(make: String): ApiResult<List<ModelEntity>>
}