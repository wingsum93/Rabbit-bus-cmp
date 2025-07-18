package org.ericho.recipeappcmp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
class RouteApiItem(
    @SerialName("route")
    val route: String? = null,
    @SerialName("bound")
    val bound: String? = null,
    @SerialName("service_type")
    val service_type: String? = null,
    @SerialName("orig_en")
    val orig_en: String? = null,
    @SerialName("orig_tc")
    val orig_tc: String? = null,
    @SerialName("orig_sc")
    val orig_sc: String? = null,
    @SerialName("dest_en")
    val dest_en: String? = null,
    @SerialName("dest_tc")
    val dest_tc: String? = null,
    @SerialName("dest_sc")
    val dest_sc: String? = null
)