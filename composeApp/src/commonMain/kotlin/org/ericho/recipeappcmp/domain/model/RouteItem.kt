package org.ericho.recipeappcmp.domain.model

import org.ericho.recipeappcmp.data.model.RouteApiItem

data class RouteItem(
    val route: String,
    val bound: String,
    val serviceType: String,
    val origEn: String,
    val origTc: String,
    val origSc: String,
    val destEn: String,
    val destTc: String,
    val destSc: String
)

fun RouteApiItem.toRouteItem(): RouteItem {
    return RouteItem(
        route = route.orEmpty(),
        bound = bound.orEmpty(),
        serviceType = service_type.orEmpty(),
        origEn = orig_en.orEmpty(),
        origTc = orig_tc.orEmpty(),
        origSc = orig_sc.orEmpty(),
        destEn = dest_en.orEmpty(),
        destTc = dest_tc.orEmpty(),
        destSc = dest_sc.orEmpty()
    )
}