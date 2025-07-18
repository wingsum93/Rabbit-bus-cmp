package org.ericho.recipeappcmp.data.remote

import org.ericho.recipeappcmp.domain.model.ETAItem
import org.ericho.recipeappcmp.domain.model.RouteItem
import org.ericho.recipeappcmp.domain.model.RouteStopItem
import org.ericho.recipeappcmp.domain.model.StopItem

interface BusRemoteDataSource {
    // 路線列表數據
    suspend fun getAllBusRoutes(): Result<List<RouteItem>>

    // 路線數據
    suspend fun getBusRoute(
        route: String,
        direction: String,
        serviceType: String
    ): Result<List<RouteItem>>

    // ----------------------------------------------
    // 巴士站列表數據
    suspend fun getAllStops(): Result<List<StopItem>>

    // 巴士站數據
    suspend fun getStop(stopId: String): Result<StopItem>

    // ----------------------------------------------
    // 路線-巴士站 列表數據
    suspend fun getAllRouteStops(): Result<List<RouteStopItem>>

    // 路線-巴士站數據
    suspend fun getRouteStop(
        route: String,
        direction: String,
        serviceType: String
    ): Result<RouteStopItem>

    // ----------------------------------------------
    // 預計到達時間數據(路線)
    suspend fun getEstimatedArrival(route: String, stopId: String): Result<List<ETAItem>>

    // 預計到達時間數據(巴士站)
    suspend fun getEstimatedArrival(stopId: String): Result<List<ETAItem>>

    // 預計到達時間數據
    suspend fun getEstimatedArrival(
        route: String,
        stopId: String,
        serviceType: String
    ): Result<ETAItem>
}