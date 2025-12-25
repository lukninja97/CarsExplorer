package com.lukninja.carsexplorer.service.model

import com.google.gson.annotations.SerializedName

data class Manufactures(
    @SerializedName("Count")
    val count: Int? = null,
    @SerializedName("Message")
    val message: String? = null,
    @SerializedName("Results")
    val manufactures: List<Manufacturer>? = null,
    @SerializedName("SearchCriteria")
    val searchCriteria: String? = null
)