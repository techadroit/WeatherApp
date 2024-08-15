plugins {
    alias(commonlibs.plugins.kotlinMultiplatform)
    alias(commonlibs.plugins.androidLibrary)
    alias(commonlibs.plugins.compose.compiler)
    alias(commonlibs.plugins.kotlinSerialization)
}

kotlin {

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                implementation(commonlibs.bundles.network)
                implementation(commonlibs.bundles.lifecycle)
                implementation(commonlibs.kotlin.serialization)
                implementation(commonlibs.koin.core)
//                implementation("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:2.8.0")
                implementation("androidx.lifecycle:lifecycle-viewmodel:2.8.4")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.3.1")


            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(commonlibs.koin.test)
            }
        }
    }
}

android {
    namespace = "com.weather.app"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}