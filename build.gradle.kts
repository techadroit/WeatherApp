plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(commonlibs.plugins.androidApplication).apply(false)
    alias(commonlibs.plugins.androidLibrary).apply(false)
    alias(commonlibs.plugins.kotlinAndroid).apply(false)
    alias(commonlibs.plugins.kotlinMultiplatform).apply(false)
    alias(commonlibs.plugins.compose.compiler)
}


tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
