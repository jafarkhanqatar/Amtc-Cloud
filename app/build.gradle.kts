plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")  // ✅ Fix for missing kapt
}

android {
    namespace = "com.example.amtccloud"  // ✅ Fix for missing namespace
    compileSdk = 34  // Targeting Android 14
    buildToolsVersion = "34.0.0"

    defaultConfig {
        applicationId = "com.example.amtccloud"
        minSdk = 30  // Minimum Android 11
        targetSdk = 34  // Targeting Android 14
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    // Core dependencies
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.2")

    // Material Design 3
    implementation("com.google.android.material:material:1.11.0")

    // Kotlin Coroutines for async operations
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // ExoPlayer for video streaming
    implementation("androidx.media3:media3-exoplayer:1.1.1")
    implementation("androidx.media3:media3-ui:1.1.1")

    // ✅ Fix missing Android TV Leanback dependencies (Use correct version)
    implementation("androidx.leanback:leanback:1.0.0")

    // ✅ Fix missing Glide dependency for image loading
    implementation("com.github.bumptech.glide:glide:4.15.1")
    kapt("com.github.bumptech.glide:compiler:4.15.1")

    // ✅ Fix missing Fragment dependency
    implementation("androidx.fragment:fragment-ktx:1.6.2")
}

