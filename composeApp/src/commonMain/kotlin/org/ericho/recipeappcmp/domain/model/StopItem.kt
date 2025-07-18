package org.ericho.recipeappcmp.domain.model

data class StopItem(
    val id: String,
    val nameTc: String,
    val nameEn: String,
    val nameSc: String,
    val latitude: Double,
    val longitude: Double
)
