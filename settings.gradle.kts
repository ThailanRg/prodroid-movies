pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "prodroid"
include(":app")
include(":movie")
include(":core:android")
include(":core:kotlin")
include(":core:network")
include(":core:design-system")
include(":core:navigation")
include(":feature:movies")
include(":feature:movie")