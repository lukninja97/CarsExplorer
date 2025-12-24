package com.lukninja.carsexplorer.service.model

import com.google.gson.annotations.SerializedName

data class Models(
    @SerializedName("Count")
    val count: Int? = null,
    @SerializedName("Message")
    val message: String? = null,
    @SerializedName("Results")
    val models: List<Model>? = null,
    @SerializedName("SearchCriteria")
    val searchCriteria: String? = null
)