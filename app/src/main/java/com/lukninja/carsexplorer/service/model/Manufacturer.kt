package com.lukninja.carsexplorer.service.model

import com.google.gson.annotations.SerializedName

data class Manufacturer(
    @SerializedName("Address")
    val address: String,
    @SerializedName("City")
    val city: String,
    @SerializedName("ContactEmail")
    val contactEmail: String,
    @SerializedName("ContactPhone")
    val contactPhone: String,
    @SerializedName("Country")
    val country: String,
    @SerializedName("EquipmentItems")
    val equipmentItems: List<Any>,
    @SerializedName("Mfr_CommonName")
    val manufacturerCommonName: String?,
    @SerializedName("Mfr_Name")
    val manufacturerName: String,
    @SerializedName("PrincipalFirstName")
    val principalFirstName: String,
    @SerializedName("PrincipalPosition")
    val principalPosition: String,
    @SerializedName("StateProvince")
    val stateProvince: String,
    @SerializedName("SubmittedName")
    val submittedName: String,
    @SerializedName("SubmittedPosition")
    val submittedPosition: String,
    @SerializedName("VehicleTypes")
    val vehicleTypes: List<VehicleType>,
)