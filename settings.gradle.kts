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

rootProject.name = "Sephora"
include(":app")
include(":library:actions")
include(":data:core")
include(":data:remote")
include(":data:local")
include(":library:domain")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":feature:main")
