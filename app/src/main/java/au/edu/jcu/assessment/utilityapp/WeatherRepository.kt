package au.edu.jcu.assessment.utilityapp

import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType

class WeatherRepository {

    private val json = Json { ignoreUnknownKeys = true }

    private val api: WeatherApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com/")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
        retrofit.create(WeatherApiService::class.java)
    }

    suspend fun fetchWeather(): WeatherUiState {
        val response = api.getWeather()
        val current = response.current
        val daily = response.daily

        // 把未来5小时预报挑出来
        val forecast = response.hourly.time
            .zip(response.hourly.temperature_2m)
            .take(5)
            .map { (time, temp) ->
                HourlyForecast(time = time.substringAfter("T"), tempC = temp)
            }

        return WeatherUiState(
            city = "Singapore",
            tempC = current.temperature_2m,
            highC = daily.temperature_2m_max.first(),
            lowC = daily.temperature_2m_min.first(),
            description = describeWeather(current.weather_code),
            forecast = forecast,
            isLoading = false,
            errorMessage = null
        )
    }

    private fun describeWeather(code: Int): String {
        return when (code) {
            0 -> "Clear sky"
            1, 2, 3 -> "Partly cloudy"
            in 40..49 -> "Foggy"
            in 50..59 -> "Drizzle"
            in 60..69 -> "Rain"
            in 70..79 -> "Snow"
            in 80..99 -> "Rain showers"
            else -> "Unknown"
        }
    }
}
