package com.weather.app.data.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastWeatherResponse (
    val location: Location,
    val current: Current,
    val forecast: Forecast
)

@Serializable
data class Forecast (
    val forecastday: List<Forecastday>
)

@Serializable
data class Forecastday (
    val date: String,

    @SerialName("date_epoch")
    val dateEpoch: Long,

    val day: Day,
    val astro: Astro,
    val hour: List<Hour>
)

@Serializable
data class Astro (
    val sunrise: String,
    val sunset: String,
    val moonrise: String,
    val moonset: String,

    @SerialName("moon_phase")
    val moonPhase: String,

    @SerialName("moon_illumination")
    val moonIllumination: Long,

    @SerialName("is_moon_up")
    val isMoonUp: Long,

    @SerialName("is_sun_up")
    val isSunUp: Long
)

@Serializable
data class Day (
    @SerialName("maxtemp_c")
    val maxtempC: Double,

    @SerialName("maxtemp_f")
    val maxtempF: Double,

    @SerialName("mintemp_c")
    val mintempC: Double,

    @SerialName("mintemp_f")
    val mintempF: Double,

    @SerialName("avgtemp_c")
    val avgtempC: Double,

    @SerialName("avgtemp_f")
    val avgtempF: Double,

    @SerialName("maxwind_mph")
    val maxwindMph: Double,

    @SerialName("maxwind_kph")
    val maxwindKph: Double,

    @SerialName("totalprecip_mm")
    val totalprecipMm: Double,

    @SerialName("totalprecip_in")
    val totalprecipIn: Double,

    @SerialName("totalsnow_cm")
    val totalsnowCM: Double,

    @SerialName("avgvis_km")
    val avgvisKM: Double,

    @SerialName("avgvis_miles")
    val avgvisMiles: Double,

    val avghumidity: Double,

    @SerialName("daily_will_it_rain")
    val dailyWillItRain: Double,

    @SerialName("daily_chance_of_rain")
    val dailyChanceOfRain: Double,

    @SerialName("daily_will_it_snow")
    val dailyWillItSnow: Double,

    @SerialName("daily_chance_of_snow")
    val dailyChanceOfSnow: Double,

    val condition: Condition,
    val uv: Double
)

@Serializable
data class Hour (
    @SerialName("time_epoch")
    val timeEpoch: Long,

    val time: String,

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
    val windDegree: Double,

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

    @SerialName("snow_cm")
    val snowCM: Double,

    val humidity: Double,
    val cloud: Double,

    @SerialName("feelslike_c")
    val feelslikeC: Double,

    @SerialName("feelslike_f")
    val feelslikeF: Double,

    @SerialName("windchill_c")
    val windchillC: Double,

    @SerialName("windchill_f")
    val windchillF: Double,

    @SerialName("heatindex_c")
    val heatindexC: Double,

    @SerialName("heatindex_f")
    val heatindexF: Double,

    @SerialName("dewpoint_c")
    val dewpointC: Double,

    @SerialName("dewpoint_f")
    val dewpointF: Double,

    @SerialName("will_it_rain")
    val willItRain: Long,

    @SerialName("chance_of_rain")
    val chanceOfRain: Long,

    @SerialName("will_it_snow")
    val willItSnow: Long,

    @SerialName("chance_of_snow")
    val chanceOfSnow: Long,

    @SerialName("vis_km")
    val visKM: Double,

    @SerialName("vis_miles")
    val visMiles: Double,

    @SerialName("gust_mph")
    val gustMph: Double,

    @SerialName("gust_kph")
    val gustKph: Double,

    val uv: Double
)