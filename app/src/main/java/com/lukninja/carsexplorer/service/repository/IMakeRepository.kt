package com.lukninja.carsexplorer.service.repository

import com.lukninja.carsexplorer.service.model.entity.MakeEntity
import com.lukninja.carsexplorer.service.util.ApiResult


interface IMakeRepository {
    suspend fun getMakes(): ApiResult<List<MakeEntity>>
}