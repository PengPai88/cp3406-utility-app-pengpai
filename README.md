# Weather Utility App

An "at-a-glance" weather app for Singapore, built for **Assessment 1: Utility App**.
It uses **Jetpack Compose**, **Material Design 3**, and fetches live weather data from **Open-Meteo**.

---

## Features

- **Main screen**: Current temperature, weather description, high/low, and next 5 hours forecast
- **Settings screen**: Toggle between Celsius (°C) and Fahrenheit (°F)
- Bottom navigation between Utility and Settings
- Loading spinner while fetching data
- Error message with Retry button if the request fails

---

## Tech Stack

- **Language**: Kotlin
- **UI**: Jetpack Compose, Material Design 3
- **Architecture**: MVVM (ViewModel + StateFlow)
- **Networking**: Retrofit + Kotlinx Serialization + OkHttp
- **Data source**: [Open-Meteo](https://open-meteo.com/) (free, no API key required)


---


## Project Structure
<img width="408" height="327" alt="image" src="https://github.com/user-attachments/assets/50570f32-c99e-4ebf-b8bc-4c89e04d9d0b" />


---

## Getting Started

### How to Run

1. Clone this repository
2. Open in Android Studio
3. Wait for Gradle sync to finish
4. Run on an emulator or physical device (API 26+)
5. Make sure the device has internet access

---

## Composables

### UtilityApp()
- Contains the screen layout using a Scaffold
- Toggles content between Utility and Settings via bottom navigation

### UtilityScreen()
- Displays current weather (temperature, description, high/low)
- Shows next 5 hours forecast in a LazyRow
- Handles loading, error, and success states

### SettingsScreen()
- Toggle between Celsius and Fahrenheit
- Applies the unit change immediately on the main screen

---

## Key Concepts Covered

| Week | Concept                        | Used In                          |
|------|--------------------------------|----------------------------------|
| 1    | Kotlin + Android Studio         | MainActivity.kt                  |
| 2    | Jetpack Compose Layouts         | UtilityApp(), UtilityScreen(), SettingsScreen() |
| 3    | Material Design 3               | Theme, Card, TopAppBar, NavigationBar |
| 4    | ViewModel + StateFlow          | WeatherViewModel.kt, WeatherUiState.kt |
| 5    | Retrofit + Web API             | WeatherApiService.kt, WeatherRepository.kt, WeatherDto.kt |

---
## Screenshots

<img width="1080" height="2376" alt="image" src="https://github.com/user-attachments/assets/7bdd7972-dd93-486d-ad71-d26f456380a9" />


---

## Notes

- Weather data is retrieved from Open-Meteo. Different weather apps may show slightly different values because they use different data providers.
- Settings are in-memory only (restarting the app resets to Celsius), as per the assessment requirements.

---


