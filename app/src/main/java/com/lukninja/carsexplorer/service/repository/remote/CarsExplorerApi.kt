package com.lukninja.carsexplorer.service.repository.remote

import com.lukninja.carsexplorer.service.model.dto.MakesDto
import com.lukninja.carsexplorer.service.model.dto.ManufacturesDto
import com.lukninja.carsexplorer.service.model.dto.ModelsDto
import com.lukninja.carsexplorer.util.Constants.ENDPOINT_GET_MAKES_OF_CARS
import com.lukninja.carsexplorer.util.Constants.ENDPOINT_GET_MODELS_PER_MAKE
import com.lukninja.carsexplorer.util.Constants.ENDPOINT_GET_MANUFACTURERS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CarsExplorerApi {

    @GET(ENDPOINT_GET_MAKES_OF_CARS)
    suspend fun getMakesForVehicleType(): Response<MakesDto>

    @GET(ENDPOINT_GET_MANUFACTURERS)
    suspend fun getManufactures(@Path("make") make: String): Response<ManufacturesDto>

    @GET(ENDPOINT_GET_MODELS_PER_MAKE)
    suspend fun getModels(@Path("make") make: String): Response<ModelsDto>

}