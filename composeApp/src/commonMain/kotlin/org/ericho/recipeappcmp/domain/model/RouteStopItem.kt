package org.ericho.recipeappcmp.domain.model

import org.ericho.recipeappcmp.data.model.RouteStopApiItem

data class RouteStopItem(
    val route: String,
    val direction: String,
    val serviceType: Int,
    val sequence: Int,
    val stopId: String
)

fun RouteStopApiItem.toRouteStopItem(): RouteStopItem {
    return RouteStopItem(
        route = route,
        direction = direction,
        serviceType = serviceType.toIntOrNull() ?: 1,
        sequence = sequence,
        stopId = stopId
    )
}