package com.fabiocarballo.taxi.trips

import app.cash.turbine.test
import com.fabiocarballo.taxi.trips.data.TripsApi
import com.fabiocarballo.taxi.trips.data.TripsRepository
import com.fabiocarballo.taxi.trips.domain.Trip
import com.fabiocarballo.taxi.trips.presentation.TripsViewModel
import com.fabiocarballo.taxi.trips.presentation.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import kotlinx.datetime.Instant
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.math.BigDecimal
import java.util.*
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class TripsViewModelTest {

    private val testCoroutineDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testCoroutineDispatcher)
    }

    @After
    fun teardown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `shows trips after successful load`() {
        val instant1 = Instant.fromEpochMilliseconds(1638474761747)
        val instant2 = Instant.fromEpochMilliseconds(1638474780932)

        val fakeTripsApi = FakeTripsApi(
            response = TripsApi.TripsResponse(
                trips = listOf(
                    TripsApi.Trip.Cancelled(
                        id = "my-id-1234",
                        createdAt = instant1
                    ),
                    TripsApi.Trip.Completed(
                        id = "my-id-5678",
                        createdAt = instant2,
                        amount = BigDecimal(10.50),
                        currency = "EUR",
                        rating = 4,
                        carModel = "Toyota Auris"
                    )
                )
            )
        )

        val viewModel = createViewModel(tripsApi = fakeTripsApi)

        runBlockingTest {
            viewModel.viewState.test {
                assertEquals(
                    expected = ViewState.Trips(
                        trips = listOf(
                            Trip.Cancelled(
                                tripId = "my-id-1234",
                                startedAt = instant1
                            ),
                            Trip.Completed(
                                tripId = "my-id-5678",
                                startedAt = instant2,
                                cost = Trip.Cost(
                                    amount = BigDecimal(10.50),
                                    currency = Currency.getInstance("EUR")
                                ),
                                rating = 4,
                                carModel = "Toyota Auris"
                            )
                        )
                    ),
                    actual = awaitItem()
                )
            }
        }
    }

    @Test
    fun `show error after failed load`() {
        val fakeTripsApi = FakeTripsApi(response = null)

        val viewModel = createViewModel(tripsApi = fakeTripsApi)

        runBlockingTest {
            viewModel.viewState.test {
                assertEquals(
                    expected = ViewState.Error,
                    actual = awaitItem()
                )
            }
        }
    }

    private fun createViewModel(
        tripsApi: FakeTripsApi = FakeTripsApi(response = null)
    ): TripsViewModel =
        TripsViewModel(
            tripsRepository = TripsRepository(
                tripsApi = tripsApi
            )
        )
}
