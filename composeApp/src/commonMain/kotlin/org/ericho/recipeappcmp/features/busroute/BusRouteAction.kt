package org.ericho.recipeappcmp.features.busroute

sealed class BusRouteAction {
    class LoadBusRoutes(val busStopId: Long) : BusRouteAction()

    class SelectBusRoute(val routeId: Long) : BusRouteAction()

    class SelectBusStop(val busStopId: Long) : BusRouteAction()

    data object ClearSelectedRoute : BusRouteAction()

    data object ClearSelectedBusStop : BusRouteAction()
}