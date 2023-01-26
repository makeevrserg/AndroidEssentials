
pluginManagement {
    includeBuild("build-logic")
    repositories {
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://plugins.gradle.org/m2/")
        maven("https://jitpack.io")
        gradlePluginPortal()
        mavenCentral()
        jcenter()
        google()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://plugins.gradle.org/m2/")
        maven("https://jitpack.io")
        gradlePluginPortal()
        mavenCentral()
        jcenter()
        google()
    }
}
rootProject.name = "MobileX"
include(":examples:app")
include(":examples:desktop")
include(":examples:shared")
include(":core-compose")
include(":ktx-core")
include(":mvi")
include(":orbit-mvi")
include(":di-container")
include(":paging")
include(":rvadapter")
// uitext
include(":uitext:uitext-core")
include(":uitext:uitext-mr")
include(":uitext:uitext-compose")