package org.ericho.recipeappcmp.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.ericho.recipeappcmp.data.model.ApiResponse
import org.ericho.recipeappcmp.data.model.RouteApiItem
import org.ericho.recipeappcmp.data.model.RouteStopApiItem
import org.ericho.recipeappcmp.data.model.StopApiItem
import org.ericho.recipeappcmp.data.model.toStopItem
import org.ericho.recipeappcmp.data.safeApiCall
import org.ericho.recipeappcmp.domain.model.ETAItem
import org.ericho.recipeappcmp.domain.model.RouteItem
import org.ericho.recipeappcmp.domain.model.RouteStopItem
import org.ericho.recipeappcmp.domain.model.StopItem
import org.ericho.recipeappcmp.domain.model.toRouteItem
import org.ericho.recipeappcmp.domain.model.toRouteStopItem

class BusRemoteDataSourceImpl(
    private val httpClient: HttpClient
) : BusRemoteDataSource {

    private val PATH_ALL_ROUTE = "route/"
    private val PATH_ROUTE = "route/{route}/{direction}/{serviceType}"

    private val PATH_ALL_STOP = "stop"
    private val PATH_STOP = "stop/{stopId}"

    private val PATH_ALL_ROUTE_STOP = "route-stop"
    private val PATH_ROUTE_STOP = "route-stop/{route}/{direction}/{serviceType}"

    private val PATH_ETA_STOP_ROUTE_SERVICETYPE = "eta/{stopId}/{route}/{serviceType}"
    private val PATH_ETA_STOP = "stop-eta/{stopId}"
    private val PATH_ETA_ROUTE = "route-eta/{route}/{serviceType}"


    override suspend fun getAllRoutes(): Result<List<RouteItem>> {
        return kotlin.runCatching {
            val c = safeApiCall {
                httpClient.get(PATH_ALL_ROUTE).body<ApiResponse<List<RouteApiItem>>>()
            }
            c.map { it.toRouteItem() }
        }
    }

    override suspend fun getBusRoute(
        route: String,
        direction: String,
        serviceType: String
    ): Result<RouteItem> {
        return kotlin.runCatching {
            val url = PATH_ROUTE.replace("{route}", route)
                .replace("{direction}", direction)
                .replace("{serviceType}", serviceType)
            val c = safeApiCall {
                httpClient.get(url).body<ApiResponse<RouteApiItem>>()
            }
            c.toRouteItem()
        }
    }

    override suspend fun getAllStops(): Result<List<StopItem>> {
        return kotlin.runCatching {
            val c = safeApiCall {
                httpClient.get(PATH_ALL_STOP).body<ApiResponse<List<StopApiItem>>>()
            }
            c.map { it.toStopItem() }
        }
    }

    override suspend fun getStop(stopId: String): Result<StopItem> {
        return kotlin.runCatching {
            val url = PATH_STOP.replace("{stopId}", stopId)
            val c = safeApiCall {
                httpClient.get(url).body<ApiResponse<StopApiItem>>()
            }
            c.toStopItem()
        }
    }

    override suspend fun getAllRouteStops(): Result<List<RouteStopItem>> {
        return kotlin.runCatching {
            val c = safeApiCall {
                httpClient.get(PATH_ALL_ROUTE_STOP).body<ApiResponse<List<RouteStopApiItem>>>()
            }
            c.map { it.toRouteStopItem() }
        }
    }

    override suspend fun getRouteStop(
        route: String,
        direction: String,
        serviceType: String
    ): Result<RouteStopItem> {
        return kotlin.runCatching {
            val c = safeApiCall {
                httpClient.get(PATH_ROUTE_STOP).body<ApiResponse<RouteStopApiItem>>()
            }
            c.toRouteStopItem()
        }
    }

    override suspend fun getEstimatedArrival(route: String, stopId: String): Result<List<ETAItem>> {
        TODO("Not yet implemented")
    }

    override suspend fun getEstimatedArrival(stopId: String): Result<List<ETAItem>> {
        TODO("Not yet implemented")
    }

    override suspend fun getEstimatedArrival(
        route: String,
        stopId: String,
        serviceType: String
    ): Result<ETAItem> {
        TODO("Not yet implemented")
    }
}