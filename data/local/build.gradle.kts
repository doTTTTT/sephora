plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android.room)

    alias(libs.plugins.kotlin.android)

    alias(libs.plugins.google.ksp)
}

android {
    namespace = "fr.dot.sephora.library.local"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    kotlinOptions {
        jvmTarget = "11"
    }

    room {
        schemaDirectory("$projectDir/schemas")
    }
}

dependencies {

    implementation(libs.bundles.room)
    ksp(libs.room.compiler)

    implementation(libs.koin.core)

    implementation(projects.data.core)

    implementation(projects.library.domain)

}