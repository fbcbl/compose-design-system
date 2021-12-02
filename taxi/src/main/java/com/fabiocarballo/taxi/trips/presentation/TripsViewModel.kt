package com.fabiocarballo.taxi.trips.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fabiocarballo.taxi.trips.data.TripsRepository
import com.fabiocarballo.taxi.trips.domain.Trip
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.time.Instant
import java.util.*

internal class TripsViewModel(
    private val tripsRepository: TripsRepository
) : ViewModel() {

    private val _viewState: MutableStateFlow<ViewState> = MutableStateFlow(ViewState.Loading)
    val viewState: Flow<ViewState> = _viewState

    init {
        viewModelScope.launch {
            runCatching { tripsRepository.getTrips() }
                .onSuccess {
                    _viewState.value = ViewState.Trips(it)
                }
                .onFailure {
                    _viewState.value = ViewState.Error
                }
        }
    }
}

internal sealed class ViewState {

    object Loading : ViewState()

    object Error : ViewState()

    data class Trips(
        val trips: List<Trip>
    ) : ViewState()
}

