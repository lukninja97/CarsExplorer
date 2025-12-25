package com.lukninja.carsexplorer.service.model

import com.google.gson.annotations.SerializedName

data class Manufacturer(
    @SerializedName("Address")
    val address: String? = null,
    @SerializedName("City")
    val city: String? = null,
    @SerializedName("ContactEmail")
    val contactEmail: String? = null,
    @SerializedName("ContactPhone")
    val contactPhone: String? = null,
    @SerializedName("Country")
    val country: String? = null,
    @SerializedName("EquipmentItems")
    val equipmentItems: List<Any>? = null,
    @SerializedName("Mfr_ID")
    val manufacturerId: Int? = null,
    @SerializedName("Mfr_CommonName")
    val manufacturerCommonName: String?? = null,
    @SerializedName("Mfr_Name")
    val manufacturerName: String? = null,
    @SerializedName("PrincipalFirstName")
    val principalFirstName: String? = null,
    @SerializedName("PrincipalPosition")
    val principalPosition: String? = null,
    @SerializedName("StateProvince")
    val stateProvince: String? = null,
    @SerializedName("SubmittedName")
    val submittedName: String? = null,
    @SerializedName("SubmittedPosition")
    val submittedPosition: String? = null,
    @SerializedName("VehicleTypes")
    val vehicleTypes: List<VehicleType>? = null,
)