package com.lukninja.carsexplorer.service.model.dto

import com.google.gson.annotations.SerializedName
import com.lukninja.carsexplorer.service.model.entity.ModelEntity
import java.util.Locale

data class ModelDto(
    @SerializedName("Model_ID")
    val id: Int,
    @SerializedName("Model_Name")
    val name: String?,
    @SerializedName("Make_ID")
    val idMake: Int,
    @SerializedName("Make_Name")
    val makeName: String?,
)

fun ModelDto.toEntity(id: Int): ModelEntity {
    return ModelEntity(
        id = id,
        name = this.name ?: "-",
        idMake = this.idMake,
        makeName = this.makeName?.uppercase(Locale.ROOT) ?: "-",
    )
}