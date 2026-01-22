plugins {
    id("com.android.library")   // ← مهم جداً
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.secureguard.sdk"  // ← namespace للموديول
    compileSdk = 34

    defaultConfig {
        minSdk = 21
        targetSdk = 34
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
        debug {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")
}
