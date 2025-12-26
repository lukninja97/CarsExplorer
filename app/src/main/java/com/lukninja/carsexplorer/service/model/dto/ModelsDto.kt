package com.lukninja.carsexplorer.service.model.dto

import com.google.gson.annotations.SerializedName

data class ModelsDto(
    @SerializedName("Count")
    val count: Int? = null,
    @SerializedName("Results")
    val models: List<ModelDto>? = null,
)