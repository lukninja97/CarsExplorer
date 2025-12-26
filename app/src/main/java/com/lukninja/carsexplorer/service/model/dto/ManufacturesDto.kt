package com.lukninja.carsexplorer.service.model.dto

import com.google.gson.annotations.SerializedName

data class ManufacturesDto(
    @SerializedName("Count")
    val count: Int? = null,
    @SerializedName("Results")
    val manufactures: List<ManufacturerDto>? = null,
)