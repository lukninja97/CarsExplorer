package com.lukninja.carsexplorer.service.model.dto

import com.google.gson.annotations.SerializedName
import com.lukninja.carsexplorer.service.model.entity.ManufacturerEntity

data class ManufacturerDto(
    @SerializedName("Address")
    val address: String?,
    @SerializedName("City")
    val city: String?,
    @SerializedName("ContactEmail")
    val contactEmail: String?,
    @SerializedName("ContactPhone")
    val contactPhone: String?,
    @SerializedName("Country")
    val country: String?,
    @SerializedName("Mfr_ID")
    val manufacturerId: Int,
    @SerializedName("Mfr_CommonName")
    val manufacturerCommonName: String?,
    @SerializedName("Mfr_Name")
    val manufacturerName: String?,
    @SerializedName("PrincipalFirstName")
    val principalFirstName: String?,
    @SerializedName("PrincipalPosition")
    val principalPosition: String?,
    @SerializedName("StateProvince")
    val stateProvince: String?,
    @SerializedName("SubmittedName")
    val submittedName: String?,
    @SerializedName("SubmittedPosition")
    val submittedPosition: String?,
)

fun ManufacturerDto.toEntity(id: Int, make: String): ManufacturerEntity {
    return ManufacturerEntity(
        manufacturerId = id,
        manufacturerCommonName = this.manufacturerCommonName ?: "-",
        manufacturerName = this.manufacturerName ?: "-",
        city = this.city ?: "-",
        contactEmail = this.contactEmail ?: "-",
        contactPhone = this.contactPhone ?: "-",
        address = this.address ?: "-",
        stateProvince = this.stateProvince ?: "-",
        country = this.country ?: "-",
        principalFirstName = this.principalFirstName ?: "-",
        principalPosition = this.principalPosition ?: "-",
        submittedName = this.submittedName ?: "-",
        submittedPosition = submittedPosition ?: "-",
        make = make,
    )
}