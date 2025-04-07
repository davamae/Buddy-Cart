plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
    // Remove the secrets plugin since we're not using it
}

android {
    namespace = "com.example.buddycart"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.buddycart"
        minSdk = 35
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Read the API key from local.properties. This property isn't a Gradle extra by default,
        // so we use 'findProperty' to try to get it.
        val mapsApiKey = project.findProperty("MAPS_API_KEY") as? String ?: "YOUR_DEFAULT_API_KEY"
        manifestPlaceholders["MAPS_API_KEY"] = mapsApiKey
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("com.google.android.gms:play-services-maps:19.1.0")
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.firestore)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
