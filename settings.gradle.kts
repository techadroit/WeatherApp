pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("commonlibs") {
            from(files("./catalogs/common.versions.toml"))
        }
        create("androidLibs"){
            from(files("./catalogs/android.versions.toml"))
        }
    }
}

rootProject.name = "WeatherApp"
include(":androidApp")
include(":shared")