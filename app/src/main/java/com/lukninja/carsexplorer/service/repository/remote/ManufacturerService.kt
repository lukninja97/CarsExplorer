package com.lukninja.carsexplorer.service.repository.remote


import com.lukninja.carsexplorer.service.model.Manufactures
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ManufacturerService {

    @GET("api/vehicles/getManufacturerDetails/{make}?format=json")
    suspend fun getManufactures(@Path("make") make: String): Response<Manufactures>

}