plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":api"))
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0")
    implementation("io.insert-koin:koin-android:3.0.1-beta-2")
    implementation("io.insert-koin:koin-android-ext:3.0.1-beta-2")
}

android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "tech.watanave.kmm_playground.androidApp"
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
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