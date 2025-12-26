package com.lukninja.carsexplorer.service.model.dto

import com.google.gson.annotations.SerializedName
import com.lukninja.carsexplorer.service.model.entity.MakeEntity

data class MakeDto(
    @SerializedName("MakeId")
    val id: Int,
    @SerializedName("MakeName")
    val name: String
)

fun MakeDto.toEntity(id: Int): MakeEntity {
    return MakeEntity(
        id = id,
        name = this.name,
    )
}
