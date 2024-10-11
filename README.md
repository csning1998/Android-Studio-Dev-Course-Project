# Android Studio Project Setup and Disclaimer

## Disclaimer

This repository contains an Android Studio project intended for educational purposes only. The content and code provided herein are shared in good faith for reference by my classmates. By accessing and using this repository, you agree to the following terms:

1. **Use at Your Own Risk**: I ain't liable for any negative outcomes, such as academic penalties or loss of grades, resulting from the use or misuse of this project. Users should exercise caution and review the code independently before submission.

2. **No Warranty**: The project is provided "as-is" without any warranty or guarantee of any kind, express or implied. This includes, but is not limited to, the suitability of the code for any particular purpose, completeness, or compliance with course requirements.

3. **Academic Integrity**: By using this repository, you agree NOT TO plagiarize or submit this code as your own work. Any copying or close derivation of this code for academic evaluation must comply with your institution’s academic integrity policies.

4. **Responsibility**: Users are FULLY RESPONSIBLE for their own use of this project and are encouraged to cite or reference the repository properly when necessary. The author disclaims all responsibility for any disputes or issues that arise from misuse or violation of academic guidelines.

## Project Setup Guide

This section provides instructions to set up the Android Studio project on Windows, macOS, and Linux (Ubuntu). Follow the steps according to your operating system.

### Prerequisites
- **Java Development Kit (JDK)**: Version 17 or later
- **Android Studio**: Latest stable version
- **Git**: For cloning the repository

### General Setup Steps

1. **Clone the Repository**
   ```bash
   git clone https://github.com/csning1998/Android-Studio-Dev-Course-Project.git
   cd Course-Android-Studio-Practice
   ``` 
   
2. **Open the Project in Android Studio**
   - Launch Android Studio.
   - Click on `File` > `Open` and navigate to the cloned repository.
   - Select the root directory of the project and click `OK`.
   
3. **Sync Project with Gradle Files**
   - If prompted, click `Sync Now` to synchronize the project with the Gradle files.

## Environmental Setup

The following setup process is written for those who haven't set up the developmental environment.

### Windows Setup

1. **Install JDK**: Download and install the JDK from [Oracle's official website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
   
2. **Install Android Studio**: Download and install the latest version of Android Studio from [developer.android.com](https://developer.android.com/studio).

3. **Configure Environment Variables**:
   - Set the `JAVA_HOME` variable to point to your JDK installation directory.
   - Add `JAVA_HOME\bin` to the `PATH` environment variable.

4. **Run the Project**: 
   - Open the project in Android Studio.
   - Click the `Run` button or use `Shift + F10` to build and run the project on an emulator or connected device.

### macOS Setup

1. **Install JDK**: You can use Homebrew to install JDK:
   ```bash
   brew install openjdk@11
   ```
   Then, set the JAVA_HOME environment variable:
   ```bash
   export JAVA_HOME=/usr/local/opt/openjdk@11/libexec/openjdk.jdk/Contents/Home
   ```
   
2. **Install Android Studio**: Download the `.dmg` file from [developer.android.com](https://developer.android.com/studio) and drag it to your `Applications` folder.

3. **Run the Project**: 
   - Open Android Studio from your `Applications` folder.
   - Open the project and sync with Gradle as instructed above.
   - Click the `Run` button or use `Control + R` to run the project.

### Linux (Ubuntu) Setup

1. **Install JDK**: Use the following commands to install OpenJDK:
   ```bash
   sudo apt update
   sudo apt install openjdk-17-jdk
   ```
   Verify the installation:
   ```bash
   java -version
   ```

2. **Install Android Studio**:
   - Download the Android Studio `.tar.gz` package from [developer.android.com](https://developer.android.com/studio).
   - Extract the package:
     ```bash
     tar -xvf android-studio-ide-*.tar.gz
     ```
   - Navigate to the extracted folder and run:
     ```bash
     cd android-studio/bin
     ./studio.sh
     ```

3. **Run the Project**:
   - Open the project in Android Studio.
   - Click the `Run` button or use `Shift + F10` to build and run the project.

## Contribution Guidelines

If you would like to contribute to this project, please follow the standard Git workflow:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes and commit them (`git commit -m 'Add some feature'`).
4. Push to your branch (`git push origin feature-branch`).
5. Open a pull request.
