plugins {
    alias(libs.plugins.android.application)
    kotlin("plugin.serialization") version "1.9.24"
}

android {
    namespace = "com.example.proyecto_ejercicio_mensual"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.proyecto_ejercicio_mensual"
        minSdk = 29
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)

    implementation("org.jetbrains.kotlin:kotlinx-serealization-json:1.6.3")
    implementation("com.squareup.retrofit2:converter-kotilnx-serialization:2.11.0")
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
}