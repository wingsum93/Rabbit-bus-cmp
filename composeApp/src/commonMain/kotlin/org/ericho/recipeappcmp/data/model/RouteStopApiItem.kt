package org.ericho.recipeappcmp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RouteStopApiItem(
    @SerialName("route")
    val route: String,   // e.g. "1A"

    @SerialName("bound")
    val direction: String, // e.g. "O" (Outbound / Inbound)

    @SerialName("service_type")
    val serviceType: String, // 有些 KMB 會用 "1", "2" 代表不同服務版本

    @SerialName("seq")
    val sequence: Int,   // Stop sequence, e.g. 34

    @SerialName("stop")
    val stopId: String,  // Stop reference, e.g. "DCFF4041D0C0ACF8"
)