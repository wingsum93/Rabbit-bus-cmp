package org.ericho.recipeappcmp.data.local

import org.ericho.recipeappcmp.domain.model.BusRouteItem
import org.ericho.recipeappcmp.domain.model.RouteStopItem
import org.ericho.recipeappcmp.domain.model.StopItem

interface BusLocalDataSource {
    // 路線列表數據
    suspend fun getAllBusRoutes(): List<BusRouteItem>?

    // 路線數據
    suspend fun getBusRoute(
        route: String,
        direction: String,
        serviceType: String
    ): List<BusRouteItem>?

    // ----------------------------------------------
    // 巴士站列表數據
    suspend fun getAllStops(): List<StopItem>?

    // 巴士站數據
    suspend fun getStop(stopId: String): StopItem?

    // ----------------------------------------------
    // 路線-巴士站 列表數據
    suspend fun getAllRouteStops(): List<RouteStopItem>?

    // 路線-巴士站數據
    suspend fun getRouteStop(route: String, direction: String, serviceType: String): RouteStopItem?
}