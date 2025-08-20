plugins {
    kotlin("jvm") version "2.2.0"
}

group = "io.github.loadeddock"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://mvn.devos.one/releases")
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.github.dockyardmc:dockyard:0.10.6")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}