package com.lukninja.carsexplorer.service.model

import com.google.gson.annotations.SerializedName

data class VehicleType(
    @SerializedName("Name")
    val name: String
)