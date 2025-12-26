package com.lukninja.carsexplorer.service.repository.remote

import com.lukninja.carsexplorer.service.model.dto.MakesDto
import com.lukninja.carsexplorer.service.model.dto.ManufacturesDto
import com.lukninja.carsexplorer.service.model.dto.ModelsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CarsExplorerApi {

    @GET("api/vehicles/GetMakesForVehicleType/car?format=json")
    suspend fun getMakesForVehicleType(): Response<MakesDto>

    @GET("api/vehicles/getManufacturerDetails/{make}?format=json")
    suspend fun getManufactures(@Path("make") make: String): Response<ManufacturesDto>

    @GET("api/vehicles/getmodelsformake/{make}?format=json")
    suspend fun getModels(@Path("make") make: String): Response<ModelsDto>

}