plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.blood"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.blood"
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

    buildFeatures {
        viewBinding = true;
    }
}

dependencies {
    implementation("androidx.room:room-runtime:2.7.2")
    annotationProcessor("androidx.room:room-compiler:2.7.2")
    implementation ("com.tbuonomo:dotsindicator:4.3")
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.16.0")
    implementation ("io.github.ShawnLin013:number-picker:2.4.13")
    implementation ("com.google.code.gson:gson:2.11.0")
    implementation ("com.github.PhilJay:MPAndroidChart:v3.1.0")
    implementation ("com.google.android.material:material:1.12.0")
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}