package au.edu.jcu.assessment.utilityapp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val current: CurrentWeather,
    val hourly: HourlyWeather,
    val daily: DailyWeather
)

@Serializable
data class CurrentWeather(
    val temperature_2m: Double,
    val weather_code: Int
)

@Serializable
data class HourlyWeather(
    val time: List<String>,
    val temperature_2m: List<Double>
)

@Serializable
data class DailyWeather(
    val temperature_2m_max: List<Double>,
    val temperature_2m_min: List<Double>
)
