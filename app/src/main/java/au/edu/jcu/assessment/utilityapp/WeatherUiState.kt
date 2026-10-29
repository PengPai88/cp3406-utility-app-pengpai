package au.edu.jcu.assessment.utilityapp

data class HourlyForecast(
    val time: String,
    val tempC: Double
)

data class WeatherUiState(
    val city: String = "Singapore",
    val tempC: Double = 0.0,
    val highC: Double = 0.0,
    val lowC: Double = 0.0,
    val description: String = "Loading...",
    val isCelsius: Boolean = true,
    val isLoading: Boolean = true,
    val errorMessage: String? = null,
    val forecast: List<HourlyForecast> = emptyList()
)
