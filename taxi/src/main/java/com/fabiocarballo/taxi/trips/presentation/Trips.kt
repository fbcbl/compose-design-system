package com.fabiocarballo.taxi.trips.presentation

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.fabiocarballo.designsystem.components.headers.Header
import com.fabiocarballo.designsystem.components.icons.Icon
import com.fabiocarballo.designsystem.components.list.item.StandardListItem
import com.fabiocarballo.designsystem.components.progress.Loader
import com.fabiocarballo.designsystem.foundation.Theme
import com.fabiocarballo.designsystem.foundation.text.Text
import com.fabiocarballo.taxi.R
import com.fabiocarballo.taxi.trips.data.LocalTripsApi
import com.fabiocarballo.taxi.trips.data.TripsRepository
import com.fabiocarballo.taxi.trips.domain.Trip
import kotlinx.datetime.toJavaInstant
import java.math.BigDecimal
import java.text.NumberFormat
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

@Composable
internal fun Trips() {
    val context = LocalContext.current

    val viewModel = remember {
        val localTripsApi = LocalTripsApi(context)
        val repository = TripsRepository(localTripsApi)
        TripsViewModel(repository)
    }

    val viewState by viewModel.viewState.collectAsState(ViewState.Loading)


    Trips(
        viewState = viewState,
        onTripClick = {
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
        }
    )
}

@Composable
internal fun Trips(
    viewState: ViewState,
    onTripClick: (Trip) -> Unit
) {
    Column {
        Header {
            Text(text = stringResource(id = R.string.trips_title))
        }

        when (viewState) {
            is ViewState.Trips -> {
                LazyColumn {
                    items(viewState.trips) { trip ->
                        Trip(
                            trip = trip,
                            onTripClick = onTripClick
                        )
                    }
                }
            }
            is ViewState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Loader()
                }
            }
        }
    }
}

@Composable
internal fun Trip(
    trip: Trip,
    onTripClick: (Trip) -> Unit
) {
    StandardListItem(
        modifier = Modifier.clickable { onTripClick(trip) },
        main = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = dateTimeFormatter.format(trip.startedAt.toJavaInstant()))
                    when (trip) {
                        is Trip.Completed ->
                            Text(
                                text = trip.carModel,
                                color = Theme.colors.contentSecondary
                            )
                        is Trip.Cancelled ->
                            Text(
                                text = stringResource(id = R.string.trip_cancelled),
                                color = Theme.colors.contentSecondary
                            )
                    }
                }

                Spacer(Modifier.weight(1f))

                if (trip is Trip.Completed) {
                    Column(
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(text = format(trip.cost.amount, trip.cost.currency))

                        trip.rating?.let {
                            Rating(userRating = trip.rating)
                        }
                    }
                }
            }
        },
        end = {
            Image(
                painter = painterResource(id = R.drawable.ic_chevron),
                contentDescription = null
            )
        }
    )
}

@Composable
private fun Rating(
    userRating: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        (1..5).forEach { rating ->
            Icon(
                painter = painterResource(id = R.drawable.ic_star_filled),
                contentDescription = null,
                tint = if (rating <= userRating) Theme.colors.contentPrimary else Theme.colors.contentDisabled,
                modifier = Modifier.size(Theme.sizing.scale600)
            )
        }
    }
}

private val dateTimeFormatter: DateTimeFormatter =
    DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
        .withZone(ZoneId.systemDefault())

private fun format(amount: BigDecimal, currency: Currency): String {
    val format = NumberFormat.getCurrencyInstance()
    format.currency = currency

    return format.format(amount)
}
