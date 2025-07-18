package org.ericho.recipeappcmp.data.local

import org.ericho.recipeappcmp.domain.model.RouteItem
import org.ericho.recipeappcmp.domain.model.RouteStopItem
import org.ericho.recipeappcmp.domain.model.StopItem
import org.ericho.recipeappcmp.features.common.data.database.daos.RecipeDao

class BusLocalDataSourceImpl(
    private val dao: RecipeDao
) : BusLocalDataSource {
    override suspend fun getAllBusRoutes(): List<RouteItem>? {
        TODO("Not yet implemented")
    }

    override suspend fun getBusRoute(
        route: String,
        direction: String,
        serviceType: String
    ): List<RouteItem>? {
        TODO("Not yet implemented")
    }

    override suspend fun getAllStops(): List<StopItem>? {
        TODO("Not yet implemented")
    }

    override suspend fun getStop(stopId: String): StopItem? {
        TODO("Not yet implemented")
    }

    override suspend fun getAllRouteStops(): List<RouteStopItem>? {
        TODO("Not yet implemented")
    }

    override suspend fun getRouteStop(
        route: String,
        direction: String,
        serviceType: String
    ): RouteStopItem? {
        TODO("Not yet implemented")
    }
}