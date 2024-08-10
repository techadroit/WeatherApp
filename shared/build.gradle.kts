plugins {
    alias(commonlibs.plugins.kotlinMultiplatform)
    alias(commonlibs.plugins.androidLibrary)
    alias(commonlibs.plugins.compose.compiler).apply(false)
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
//                implementation(commonlibs.bundles.koin)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
//                implementation(commonlibs.koin.test)
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