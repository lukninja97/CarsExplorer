package com.lukninja.carsexplorer.service.repository

import com.lukninja.carsexplorer.service.model.entity.ManufacturerEntity
import com.lukninja.carsexplorer.service.util.ApiResult

interface IManufacturerRepository {
    suspend fun getManufactures(make: String): ApiResult<List<ManufacturerEntity>>
    suspend fun getManufacturer(manufacturerId: Int): ApiResult<ManufacturerEntity>
}