package au.edu.jcu.assessment.utilityapp

data class HourlyForecast(
    val time: String,
    val tempC: Double
)

data class WeatherUiState(
    val city: String = "Singapore",
    val tempC: Double = 24.5,
    val highC: Double = 31.0,
    val lowC: Double = 26.0,
    val description: String = "Partly cloudy",
    val isCelsius: Boolean = true,
    val forecast: List<HourlyForecast> = listOf(
        HourlyForecast("Now", 24.5),
        HourlyForecast("15:00", 26.0),
        HourlyForecast("16:00", 27.0),
        HourlyForecast("17:00", 26.5),
        HourlyForecast("18:00", 25.0)
    )
)
