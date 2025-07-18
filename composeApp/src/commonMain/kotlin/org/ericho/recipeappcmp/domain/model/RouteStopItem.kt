package org.ericho.recipeappcmp.domain.model

import kotlinx.datetime.Instant
import kotlinx.datetime.toInstant
import org.ericho.recipeappcmp.data.model.RouteStopApiItem

data class RouteStopItem(
    val company: String,
    val route: String,
    val direction: String,
    val serviceType: Int,
    val sequence: Int,
    val stopId: String,
    val updatedAt: Instant
)

fun RouteStopApiItem.toRouteStopItem(): RouteStopItem {
    return RouteStopItem(
        company = company,
        route = route,
        direction = direction,
        serviceType = serviceType.toIntOrNull() ?: 1,
        sequence = sequence,
        stopId = stopId,
        updatedAt = dataTimestamp.toInstant()
    )
}