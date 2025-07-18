package org.ericho.recipeappcmp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T>(
    @SerialName("type")
    val type: String? = null,
    @SerialName("version")
    val version: String? = null,
    @SerialName("generated_timestamp")
    val datatimestamp: String? = null,
    @SerialName("data")
    val data: T? = null,
)