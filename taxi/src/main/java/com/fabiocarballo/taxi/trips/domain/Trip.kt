package com.fabiocarballo.taxi.trips.domain

import kotlinx.datetime.Instant
import java.math.BigDecimal
import java.util.*

internal sealed class Trip {

    abstract val tripId: String
    abstract val startedAt: Instant

    data class Cancelled(
        override val tripId: String,
        override val startedAt: Instant
    ) : Trip()

    data class Completed(
        override val tripId: String,
        override val startedAt: Instant,
        val carModel: String,
        val cost: Cost,
        val rating: Int?
    ) : Trip()

    data class Cost(
        val amount: BigDecimal,
        val currency: Currency
    )
}
