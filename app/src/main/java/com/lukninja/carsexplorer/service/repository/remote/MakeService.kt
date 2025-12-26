package com.lukninja.carsexplorer.service.repository.remote

import com.lukninja.carsexplorer.service.model.dto.MakesDto
import retrofit2.Response
import retrofit2.http.GET

interface MakeService {

    @GET("api/vehicles/GetMakesForVehicleType/car?format=json")
    suspend fun getMakesForVehicleType(): Response<MakesDto>

}