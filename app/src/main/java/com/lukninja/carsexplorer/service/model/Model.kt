package com.lukninja.carsexplorer.service.model

import com.google.gson.annotations.SerializedName

data class Model(
    @SerializedName("Make_ID")
    val idMake: Int,
    @SerializedName("Make_Name")
    val makeName: String,
    @SerializedName("Model_ID")
    val id: Int,
    @SerializedName("Model_Name")
    val name: String
)