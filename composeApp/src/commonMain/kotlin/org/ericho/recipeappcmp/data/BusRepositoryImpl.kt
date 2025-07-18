package org.ericho.recipeappcmp.data

import org.ericho.recipeappcmp.data.local.BusLocalDataSource
import org.ericho.recipeappcmp.data.remote.BusRemoteDataSource
import org.ericho.recipeappcmp.domain.model.ETAItem
import org.ericho.recipeappcmp.domain.model.RouteItem
import org.ericho.recipeappcmp.domain.model.RouteStopItem
import org.ericho.recipeappcmp.domain.model.StopItem

class BusRepositoryImpl(
    private val localDataSource: BusLocalDataSource,
    private val remoteDataSource: BusRemoteDataSource
) : BusRepository {

    override suspend fun getAllBusRoutes(): Result<List<RouteItem>> {
        return remoteDataSource.getAllRoutes()
    }

    override suspend fun getBusRoute(
        route: String,
        direction: String,
        serviceType: String
    ): Result<RouteItem> {
        return remoteDataSource.getBusRoute(route, direction, serviceType)
    }

    override suspend fun getAllStops(): Result<List<StopItem>> {
        return remoteDataSource.getAllStops()
    }

    override suspend fun getStop(stopId: String): Result<StopItem> {
        return remoteDataSource.getStop(stopId)
    }

    override suspend fun getAllRouteStops(): Result<List<RouteStopItem>> {
        return remoteDataSource.getAllRouteStops()
    }

    override suspend fun getRouteStop(
        route: String,
        direction: String,
        serviceType: String
    ): Result<RouteStopItem> {
        return remoteDataSource.getRouteStop(route, direction, serviceType)
    }

    override suspend fun getEstimatedArrival(route: String, stopId: String): Result<List<ETAItem>> {
        return remoteDataSource.getEstimatedArrival(route, stopId)
    }

    override suspend fun getEstimatedArrival(stopId: String): Result<List<ETAItem>> {
        return remoteDataSource.getEstimatedArrival(stopId)
    }

    override suspend fun getEstimatedArrival(
        route: String,
        stopId: String,
        serviceType: String
    ): Result<ETAItem> {
        return remoteDataSource.getEstimatedArrival(route, stopId, serviceType)
    }
}