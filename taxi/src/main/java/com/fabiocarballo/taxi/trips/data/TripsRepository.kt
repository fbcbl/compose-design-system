package com.fabiocarballo.taxi.trips.data

import com.fabiocarballo.taxi.trips.domain.Trip
import java.util.*

internal class TripsRepository(
    private val tripsApi: TripsApi
) {

    suspend fun getTrips(): List<Trip> {
        val response = tripsApi.getTrips()

        return response.trips.map { trip ->
            when (trip) {
                is TripsApi.Trip.Completed -> {
                    Trip.Completed(
                        tripId = trip.id,
                        startedAt = trip.createdAt,
                        carModel = trip.carModel,
                        cost = Trip.Cost(
                            amount = trip.amount,
                            currency = Currency.getInstance(trip.currency)
                        ),
                        rating = trip.rating
                    )
                }

                is TripsApi.Trip.Cancelled -> {
                    Trip.Cancelled(
                        tripId = trip.id,
                        startedAt = trip.createdAt
                    )
                }
            }
        }
    }
}
