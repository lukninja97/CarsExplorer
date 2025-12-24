package com.lukninja.carsexplorer.service.model

import com.google.gson.annotations.SerializedName

data class Make(
    @SerializedName("Make_ID")
    val idMake: Int,
    @SerializedName("Make_Name")
    val name: String
)
