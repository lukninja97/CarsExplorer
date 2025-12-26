package com.lukninja.carsexplorer.service.model

import com.google.gson.annotations.SerializedName
import com.lukninja.carsexplorer.service.model.dto.MakeDto

data class Makes(
    @SerializedName("Count")
    val count: Int,
    @SerializedName("Message")
    val message: String,
    @SerializedName("Results")
    val makes: List<MakeDto>,
    @SerializedName("SearchCriteria")
    val searchCriteria: Any
)