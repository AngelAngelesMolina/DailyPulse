# DailyPulse

DailyPulse is a modern news application built with **Kotlin Multiplatform (KMP)**, designed to provide a seamless news reading experience across Android and iOS.

## 🚀 Features

- **Multiplatform Support**: Shared business logic and UI across Android and iOS using Kotlin Multiplatform.
- **News Feed**: Browse the latest articles with detailed information including titles, descriptions, and images.
- **Offline First**: Cached articles using **SQLDelight** for a smooth experience even without an active internet connection.
- **Modern UI**: Built entirely with **Jetpack compose** and **Swift ui**.
- **Clean Architecture**: Organized into `domain`, `data`, and `presentation` layers for maintainability and scalability.

## 📸 Screenshots

| Articles | Sources | About Device |
| :---: | :---: | :---: |
| ![Articles Screen](https://github.com/user-attachments/assets/936460ed-034e-4bce-8de0-3fb270b7115a) | ![Sources Screen](https://github.com/user-attachments/assets/ddc48906-f0f7-414e-a8db-49b978d22803) | ![About Device Screen](https://github.com/user-attachments/assets/5ee62e0c-f280-4ee1-932e-9108c6ccd397) |


## 🛠️ Tech Stack

- **UI**: [Jetpack compose & Swift UI](https://www.jetbrains.com/lp/compose-multiplatform/)
- **Networking**: [Ktor](https://ktor.io/)
- **Dependency Injection**: [Koin](https://insert-koin.io/)
- **Database**: [SQLDelight](https://cashapp.github.io/sqldelight/)
- **Image Loading**: [Coil3](https://coil-kt.github.io/coil/)
- **Concurrency**: [Kotlinx Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
- **Serialization**: [Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization)
- **Date/Time**: [Kotlinx Datetime](https://github.com/Kotlin/kotlinx-datetime)

## 📁 Project Structure

The project follows a standard Kotlin Multiplatform structure:

- `composeApp/src/commonMain`: Contains shared Compose UI, ViewModels, Use Cases, and Repository interfaces.
- `composeApp/src/androidMain`: Android-specific configurations and platform implementations (e.g., Database drivers).
- `composeApp/src/iosMain`: iOS-specific platform implementations.

## ⚙️ Getting Started

### Prerequisites

- Android Studio Ladybug or later.
- Xcode (for running the iOS application).
- JDK 17+.

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/DailyPulse.git
   ```
2. Open the project in Android Studio.
3. Sync project with Gradle files.

### Running the App

- **Android**: Select `composeApp` and run on an emulator or physical device.
- **iOS**: Run the `iosApp` target from Android Studio (using the KMP plugin) or open the `iosApp` folder in Xcode.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
