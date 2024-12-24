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

    implementation("org.openjfx:javafx-controls:17")
    implementation("org.openjfx:javafx-fxml:17")
    implementation("org.openjfx:javafx-graphics:17")
    implementation("org.jmonkeyengine:jme3-core:3.4.0-stable")
    implementation("org.jmonkeyengine:jme3-desktop:3.4.0-stable")
    implementation("org.jmonkeyengine:jme3-lwjgl:3.4.0-stable")
    implementation("org.jmonkeyengine:jme3-plugins:3.4.0-stable")
}

tasks.test {
    useJUnitPlatform()
}