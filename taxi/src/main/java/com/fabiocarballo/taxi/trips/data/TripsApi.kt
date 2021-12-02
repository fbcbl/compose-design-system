package com.fabiocarballo.taxi.trips.data

import android.content.Context
import com.fabiocarballo.taxi.R
import kotlinx.coroutines.delay
import kotlinx.datetime.Instant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.math.BigDecimal

interface TripsApi {

    suspend fun getTrips(): TripsResponse

    @Serializable
    data class TripsResponse(
        val trips: List<Trip>
    )

    @Serializable
    sealed class Trip {

        @Serializable
        @SerialName("cancelled")
        data class Cancelled(
            val id: String,
            @SerialName("created_at")
            val createdAt: Instant
        ) : Trip()

        @Serializable
        @SerialName("completed")
        data class Completed(
            val id: String,
            @SerialName("created_at")
            val createdAt: Instant,
            @Serializable(with = BigDecimalSerializer::class)
            val amount: BigDecimal,
            val currency: String,
            val rating: Int?,
            @SerialName("car_model")
            val carModel: String
        ) : Trip()
    }
}


private class BigDecimalSerializer : KSerializer<BigDecimal> {

    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("decimal", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): BigDecimal {
        val plainString = decoder.decodeString()
        return BigDecimal(plainString)
    }

    override fun serialize(encoder: Encoder, value: BigDecimal) {
        encoder.encodeString(value.toPlainString())
    }
}

internal class LocalTripsApi(
    private val context: Context
) : TripsApi {

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    override suspend fun getTrips(): TripsApi.TripsResponse {
        val tripsJsonStream = context.resources.openRawResource(R.raw.trips)
        val jsonContent = inputStreamToString(tripsJsonStream)
        delay(2000L) // fake delay
        return json.decodeFromString(jsonContent)
    }

    private fun inputStreamToString(inputStream: InputStream): String {
        val bytes = ByteArray(inputStream.available())
        inputStream.read(bytes, 0, bytes.size)
        return String(bytes)
    }
}
