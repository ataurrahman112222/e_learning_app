plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.dev.eapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dev.eapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


// Kotlin extensions
    implementation ("androidx.core:core-ktx:1.6.0")
    implementation ("androidx.appcompat:appcompat:1.3.1")

    // RecyclerView
    implementation ("androidx.recyclerview:recyclerview:1.2.1")

    // Material Design
    implementation ("com.google.android.material:material:1.4.0")

    // ViewModel and LiveData (for managing UI-related data)
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")

    // Room database
    implementation ("androidx.room:room-runtime:2.3.0")
    implementation ("androidx.room:room-compiler:2.3.0")

    // Kotlin coroutines for asynchronous tasks
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1")

    // Constraint Layout
    implementation ("androidx.constraintlayout:constraintlayout:2.0.4")
}