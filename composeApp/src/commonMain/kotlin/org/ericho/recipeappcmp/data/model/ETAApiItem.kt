package org.ericho.recipeappcmp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ETAApiItem(
    @SerialName("co")
    val company: String, // e.g. "KMB"

    @SerialName("route")
    val route: String,   // e.g. "1A"

    @SerialName("dir")
    val direction: String, // "O" (Outbound) / "I" (Inbound)

    @SerialName("service_type")
    val serviceType: Int,  // e.g. 1

    @SerialName("seq")
    val sequence: Int,     // Stop sequence

    @SerialName("stop")
    val stopId: String,    // Stop reference

    @SerialName("dest_tc")
    val destTc: String,    // e.g. "尖沙咀碼頭"

    @SerialName("dest_sc")
    val destSc: String,    // e.g. "尖沙咀码头"

    @SerialName("dest_en")
    val destEn: String,    // e.g. "STAR FERRY"

    @SerialName("eta_seq")
    val etaSequence: Int,  // e.g. 1 (ETA order)

    @SerialName("eta")
    val eta: String,       // e.g. "2022-11-29T15:48:00+08:00"

    @SerialName("rmk_tc")
    val remarkTc: String,

    @SerialName("rmk_sc")
    val remarkSc: String,

    @SerialName("rmk_en")
    val remarkEn: String,

    @SerialName("data_timestamp")
    val dataTimestamp: String
)