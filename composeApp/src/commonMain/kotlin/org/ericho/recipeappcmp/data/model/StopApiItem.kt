package org.ericho.recipeappcmp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.ericho.recipeappcmp.domain.model.StopItem

@Serializable
data class StopApiItem(
    @SerialName("stop")
    val stop: String,

    @SerialName("name_tc")
    val nameTc: String,

    @SerialName("name_en")
    val nameEn: String,

    @SerialName("name_sc")
    val nameSc: String,

    @SerialName("lat")
    val lat: Double,

    @SerialName("long")
    val lng: Double, // Kotlin 命名不能用 long，所以轉成 lng
)

fun StopApiItem.toStopItem(): StopItem {
    return StopItem(
        id = stop,
        nameTc = nameTc,
        nameEn = nameEn.trim(), // 處理 " SAU MAU PING\n(CENTRAL)"
        nameSc = nameSc,
        latitude = lat,
        longitude = lng
    )
}