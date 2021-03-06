plugins {
    kotlin("multiplatform") version "1.6.10"
    id("org.jetbrains.kotlinx.kover") version "0.5.0"
    id("com.adarshr.test-logger") version "3.2.0"
    id("convention.publication")
}

//apply(from = "./customlogger.gradle.kts")

group = "io.github.chardskarth"
version = "0.0.1"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(BOTH) {
        nodejs()
    }

    sourceSets {
        val commonMain by getting { }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-common"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

repositories {
    gradlePluginPortal() // To use 'maven-publish' and 'signing' plugins in our own plugin
}
