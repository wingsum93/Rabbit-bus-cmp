package org.ericho.recipeappcmp.domain.model

import kotlinx.datetime.Instant
import kotlinx.datetime.toInstant
import org.ericho.recipeappcmp.data.model.ETAApiItem

data class ETAItem(
    val company: String,
    val route: String,
    val direction: String,
    val serviceType: Int,
    val sequence: Int,
    val stopId: String,
    val destTc: String,
    val destSc: String,
    val destEn: String,
    val etaSequence: Int,
    val etaTime: Instant?,       // 有些 API 可能為 null，建議 nullable
    val remarkTc: String?,
    val remarkSc: String?,
    val remarkEn: String?,
    val updatedAt: Instant
)

fun ETAApiItem.toETAItem(): ETAItem {
    return ETAItem(
        company = company,
        route = route,
        direction = direction,
        serviceType = serviceType,
        sequence = sequence,
        stopId = stopId,
        destTc = destTc,
        destSc = destSc,
        destEn = destEn,
        etaSequence = etaSequence,
        etaTime = eta.takeIf { it.isNotBlank() }?.toInstant(),
        remarkTc = remarkTc.ifBlank { null },
        remarkSc = remarkSc.ifBlank { null },
        remarkEn = remarkEn.ifBlank { null },
        updatedAt = dataTimestamp.toInstant()
    )
}