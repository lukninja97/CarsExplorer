package com.lukninja.carsexplorer.service.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("make")
data class MakeEntity(
    @PrimaryKey
    val id: Int = 0,
    val name: String
)
