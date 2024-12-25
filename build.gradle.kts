plugins {
    id("org.jetbrains.kotlin.jvm") version "1.8.0"
    id("java")
}

group = "fr.sandro642.github"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}