package com.fabiocarballo.taxi.trips

import com.fabiocarballo.taxi.trips.data.TripsApi

internal class FakeTripsApi(
    private val response: TripsApi.TripsResponse?
) : TripsApi {

    override suspend fun getTrips(): TripsApi.TripsResponse = response ?: error("Failed to fetch!")
}
