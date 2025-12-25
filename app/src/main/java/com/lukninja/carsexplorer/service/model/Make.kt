package com.lukninja.carsexplorer.service.model

import com.google.gson.annotations.SerializedName

data class Make(
    @SerializedName("MakeId")
    val id: Int,
    @SerializedName("MakeName")
    val name: String
)
