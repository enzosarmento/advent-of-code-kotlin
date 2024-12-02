plugins {
    kotlin("jvm") version "2.1.0"
    application
}

application {
    mainClass = providers.gradleProperty("day").map { "Day${it}Kt" }
}

sourceSets {
    main {
        kotlin.srcDir("src")
    }
}

tasks {
    wrapper {
        gradleVersion = "8.11.1"
    }
}
