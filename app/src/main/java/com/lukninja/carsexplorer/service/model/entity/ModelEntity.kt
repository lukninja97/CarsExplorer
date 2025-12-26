package com.lukninja.carsexplorer.service.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("model")
data class ModelEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val idMake: Int,
    val makeName: String,
)

