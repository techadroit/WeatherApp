package com.weather.app.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CityWeatherResponse(
    val location: Location,
    val current: Current
)

@Serializable
data class Current(
    @SerialName("last_updated_epoch")
    val lastUpdatedEpoch: Long,

    @SerialName("last_updated")
    val lastUpdated: String,

    @SerialName("temp_c")
    val tempC: Double,

    @SerialName("temp_f")
    val tempF: Double,

    @SerialName("is_day")
    val isDay: Long,

    val condition: Condition,

    @SerialName("wind_mph")
    val windMph: Double,

    @SerialName("wind_kph")
    val windKph: Double,

    @SerialName("wind_degree")
    val windDegree: Long,

    @SerialName("wind_dir")
    val windDir: String,

    @SerialName("pressure_mb")
    val pressureMB: Double,

    @SerialName("pressure_in")
    val pressureIn: Double,

    @SerialName("precip_mm")
    val precipMm: Double,

    @SerialName("precip_in")
    val precipIn: Double,

    val humidity: Long,
    val cloud: Long,

    @SerialName("feelslike_c")
    val feelslikeC: Double,

    @SerialName("feelslike_f")
    val feelslikeF: Double,

    @SerialName("vis_km")
    val visKM: Double,

    @SerialName("vis_miles")
    val visMiles: Double,

    val uv: Double,

    @SerialName("gust_mph")
    val gustMph: Double,

    @SerialName("gust_kph")
    val gustKph: Double
)

@Serializable
data class Condition(
    val text: String,
    val icon: String,
    val code: Long
)

@Serializable
data class Location(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,

    @SerialName("tz_id")
    val tzID: String,

    @SerialName("localtime_epoch")
    val localtimeEpoch: Long,

    val localtime: String
)
