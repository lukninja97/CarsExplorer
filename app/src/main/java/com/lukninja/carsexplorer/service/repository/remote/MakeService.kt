package com.lukninja.carsexplorer.service.repository.remote

import com.lukninja.carsexplorer.service.model.Makes
import retrofit2.Response
import retrofit2.http.GET

interface MakeService {

    @GET("api/vehicles/getallmakes?format=json")
    suspend fun getMakes(): Response<Makes>

    @GET("api/vehicles/GetMakesForVehicleType/car?format=json")
    suspend fun getMakesForVehicleType(): Response<Makes>

}