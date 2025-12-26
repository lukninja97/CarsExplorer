package com.lukninja.carsexplorer.service.model.dto

import com.google.gson.annotations.SerializedName

data class MakesDto(
    @SerializedName("Count")
    val count: Int,
    @SerializedName("Message")
    val message: String,
    @SerializedName("Results")
    val makes: List<MakeDto>,
    @SerializedName("SearchCriteria")
    val searchCriteria: Any
)