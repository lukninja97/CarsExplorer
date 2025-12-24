package com.lukninja.carsexplorer.service.repository.remote


import com.lukninja.carsexplorer.service.model.Models
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ModelService {

    @GET("api/vehicles/getmodelsformake/{make}?format=json")
    suspend fun getModels(@Path("make") make: String): Response<Models>

}