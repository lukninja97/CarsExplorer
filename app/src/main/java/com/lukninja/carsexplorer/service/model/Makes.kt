package com.lukninja.carsexplorer.service.model

import com.google.gson.annotations.SerializedName

data class Makes(
    @SerializedName("Count")
    val count: Int,
    @SerializedName("Message")
    val message: String,
    @SerializedName("Results")
    val makes: List<Make>,
    @SerializedName("SearchCriteria")
    val searchCriteria: Any
)