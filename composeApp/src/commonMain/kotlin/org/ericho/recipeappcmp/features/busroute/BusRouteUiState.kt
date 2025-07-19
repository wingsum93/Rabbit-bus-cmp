package org.ericho.recipeappcmp.features.busroute

import org.ericho.recipeappcmp.domain.model.RouteItem

data class BusRouteUiState(
    private val busRoutes: List<RouteItem> = emptyList(),
    private val isLoading: Boolean = false,
    private val errorMessage: String? = null
)