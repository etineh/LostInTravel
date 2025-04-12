
# LostInTravel App

## Setup and Run Instructions

1. **Clone the repository**:
   ```bash
   git clone https://github.com/etineh/LostInTravel_.git
   ```

2. **Open the project in Android Studio**:
   - Make sure you have Android Studio installed (preferably the latest stable version).
   - Open the `LostInTravel` folder in Android Studio.

3. **Install dependencies**:
   - Ensure all dependencies are synced and the project builds successfully:
     ```bash
     ./gradlew build
     ```

4. **Set up the required Firebase project** (for Google sign-in):
   - Follow the instructions to set up Firebase for your project: [Firebase Setup](https://firebase.google.com/docs/android/setup)
   - Add the `google-services.json` to your `app` folder.

5. **Run the project**:
   - Connect a physical Android device (preferrably) or start an emulator.
   - Run the app from Android Studio using the "Run" button or via terminal:
     ```bash
     ./gradlew installDebug
     ```

---

## Architecture and Design Choices

- **MVVM Architecture**: The app uses the **Model-View-ViewModel (MVVM)** architecture to separate concerns and ensure that the UI (View) is separated from the business logic (ViewModel). This helps in managing the app's state effectively.

- **Jetpack Compose**: The app leverages **Jetpack Compose** for the UI, allowing for a more declarative and reactive approach to building the user interface.

- **ViewModel**: The ViewModel handles the business logic, and the UI observes the `State` for updates. It decouples the UI from the data layer and ensures proper handling of configuration changes.

- **ActivityResultLauncher API**: Used for managing the Google Sign-In flow, providing a cleaner approach than `onActivityResult()`.

- **Reusable Components**: The app is built with rich, reusable components that can be used in any activity when required, making the code easy to maintain.

- **Dark Theme**: The app supports a modern **dark theme**, allowing users to switch between light and dark modes based on system preferences.

---

## Trade-offs and Limitations

- **Destination API**: The destination API mentioned in the test document wasn’t found in the official API documentation. So instead, I used the `RecommendedPlaces: [Place]` endpoint, which returned a null or empty list. As a temporary solution, I seeded it with local data until the issue is resolved.
  
- **Google Sign-In Dependency**: The app's reliance on Google sign-in requires Firebase integration, which adds additional setup overhead for new developers.
  
- **Two Activity Approach**: The app use two activity (`MainActivity` and `HomeActivity`). The `MainActivity` handles the welcome screen, which redirect to `HomeActivity` upon successful login via Google-signin.

- **Limited Testing**: Although the app follows MVVM and uses the ViewModel for UI-state management, testing could be improved in areas such as **UI testing** with **Jetpack Compose** and unit tests for view models.

- **Device Compatibility**: The app primarily targets modern Android devices (API level 24+), so some older devices may face issues with features like dark mode or Google sign-in.

---

## Future Improvements

- **Offline Support**: Implementing local caching with **Room Database** or **DataStore** to store user preferences and travel data for offline usage.

- **Push Notifications**: Adding support for **Firebase Cloud Messaging** (FCM) to send push notifications for updates.

- **Advanced Search**: Enhancing the search functionality to allow users to filter data required for users.

- **Multiple Language Support**: Expanding the app to support multiple languages to cater to a wider audience.

- **Analytics Integration**: Adding analytics to track user behavior and improve features based on actual usage patterns.

