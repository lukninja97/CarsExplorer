package com.lukninja.carsexplorer.util

object Constants {
    const val BASE_URL = "https://vpic.nhtsa.dot.gov/"
    const val VERSION_API = "api/"
    const val FORMAT_JSON = "?format=json"

    // Paths
    const val PATH_VEHICLES = "vehicles/"

    // Endpoints
    const val ENDPOINT_GET_MAKES_OF_CARS =
        VERSION_API + PATH_VEHICLES + "GetMakesForVehicleType/car" + FORMAT_JSON
    const val ENDPOINT_GET_MANUFACTURERS =
        VERSION_API + PATH_VEHICLES + "getManufacturerDetails/{make}" + FORMAT_JSON
    const val ENDPOINT_GET_MODELS_PER_MAKE =
        VERSION_API + PATH_VEHICLES + "getmodelsformake/{make}" + FORMAT_JSON

}