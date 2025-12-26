package com.lukninja.carsexplorer.service.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("manufacturer")
data class ManufacturerEntity(
    @PrimaryKey
    val manufacturerId: Int,
    val manufacturerCommonName: String,
    val manufacturerName: String,
    val city: String,
    val contactEmail: String,
    val contactPhone: String,
    val address: String,
    val stateProvince: String,
    val country: String,
    val principalFirstName: String,
    val principalPosition: String,
    val submittedName: String,
    val submittedPosition: String,
    val make: String,
)