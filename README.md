# 📱 Mobile Test Automation Framework - Appium & Java

![Appium](https://img.shields.io/badge/Appium-3%2b-green.svg?style=for-the-badge&logo=appium&logoColor=white)
![Java](https://img.shields.io/badge/Java-11%2b-orange.svg?style=for-the-badge)
![Design Pattern](https://img.shields.io/badge/Pattern-Page%20Object%20Model%20(POM)-green.svg?style=for-the-badge)
![Reporting](https://img.shields.io/badge/Reports-Extent%20Reports-red.svg?style=for-the-badge)
![TestNG](https://img.shields.io/badge/Testng-7%2b-blue.svg?style=for-the-badge)
![Platform](https://img.shields.io/badge/Platform-Android-lightgreen.svg?style=for-the-badge&logo=android&logoColor=white)
![Platform](https://img.shields.io/badge/Platform-iOS-silver.svg?style=for-the-badge&logo=ios&logoColor=white)
---

## 📌 Executive Summary

This repository contains an end-to-end Mobile Test Automation Framework built for Android/iOS applications using **Java**, **Appium**, and **TestNG**.

The project represents a structural refactoring of the legacy repository [`Appium_MobileTesting`](https://github.com/jluisvacan/Appium_MobileTesting). It transitions procedural test scripts into a **scalable, modular, and maintainable Page Object Model (POM)** design pattern integrated with **ExtentReports** for rich execution reporting.

---

## 🛠️ Tech Stack & Dependencies

- **Programming Language:** Java (JDK 11+)
- **Mobile Automation:** Appium Java Client
- **Testing Framework:** TestNG
- **Design Pattern**  Page Object Model (POM)
- **Build & Dependency Management:** Apache Maven
- **Reporting & Insights:** ExtentReports Framework
- **Inspectors & Emulators** Appium Inspector, Android Studio / Android Emulator

---

## 🏗️ Architecture & Design Pattern

### Page Object Model (POM) Implementation
To ensure high maintainability, code reusability, and separation of concerns:
- **Pages / Views Layer:** Encapsulates UI elements (locators) and user actions specific to each screen.
- **Tests Layer:** Contains business logic flows, test scenarios, assertions, and execution parameters.
- **Base / Utils Layer:** Manages driver initialization, explicit waits, screenshots, and report configuration.

```
Appium_Framework/
├── src/
│   ├── main/java/com/academy/
│   │   ├── pages/             # Page Object classes (Android / iOS locators & actions)
│   │   │   ├── android/       # Android specific page objects
│   │   │   └── ios/           # iOS specific page objects
│   │   ├── resources/         # Configuration properties (IP, Port, Device Name, Browser)
│   │   └── utils/             # Core utilities (ExtentReports, Driver Setup Helpers)
│   └── test/java/com/academy/
│       ├── android/           # Test classes for Android test scenarios
│       ├── ios/               # Test classes for iOS test scenarios
│       ├── resources/         # Target APK / IPA application binaries
│       ├── testData/          # Data providers for Data-Driven Testing (DDT)
│       └── testUtils/         # Test listeners, base test configurations & driver management
├── reports/                   # ExtentReports generated HTML artifacts
├── testNGSuites/              # XML suite configurations for test execution
├── pom.xml                    # Maven dependencies and build management
└── README.md                  # Project documentation
```

---

## 🚀 Getting Started & Execution

### Prerequisites

1. **Java Development Kit (JDK 11+)** installed and `JAVA_HOME` configured.
2. **Appium Server (3.x)** installed and running (`appium`).
3. **Android SDK / Android Studio** configured with `ANDROID_HOME`.
4. **Android Emulator** or physical device with USB Debugging enabled.

### Installation & Setup

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/jluisvacan/Appium_MobileTesting.git
   cd Appium_MobileTesting
    ```

2. **Execute Test Suite via Maven::**
   ```bash
   mvn clean test
   ```
   
## 📊 Test Reporting & Insights
After test execution, ExtentReports automatically generates an interactive HTML report.
- **Report Path**: ./reports/index.html (or project root build folder)

  - **Report Features**:

    - Pass / Fail status breakdown with execution timestamps.

    - Granular logs for every page interaction.

    - Detailed error messages and trace logs for failed assertions.