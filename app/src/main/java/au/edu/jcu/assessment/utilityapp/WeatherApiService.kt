package au.edu.jcu.assessment.utilityapp

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("v1/forecast")
    suspend fun getWeather(
        @Query("latitude") latitude: Double = 1.3521,      // Singapore
        @Query("longitude") longitude: Double = 103.8198,  // Singapore
        @Query("current") current: String = "temperature_2m,weather_code",
        @Query("hourly") hourly: String = "temperature_2m",
        @Query("daily") daily: String = "temperature_2m_max,temperature_2m_min",
        @Query("timezone") timezone: String = "auto",
        @Query("forecast_days") forecast_days: Int = 1
    ): WeatherResponse
}
