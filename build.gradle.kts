plugins {
    kotlin("jvm") version "2.1.10"
    id("com.gradleup.shadow") version "9.0.0-beta13"
}

group = "de.vulpescloud"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://repo.vulpescloud.de/snapshots/")
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://dist.labymod.net/api/v1/maven/release/")
}

dependencies {
    compileOnly("de.vulpescloud:VulpesCloud-api:2.0.0-ALPHA")
    compileOnly("de.vulpescloud:VulpesCloud-node:2.0.0-ALPHA")
    compileOnly("de.vulpescloud:VulpesCloud-bridge:2.0.0-ALPHA")

    compileOnly("com.velocitypowered:velocity-api:3.4.0-SNAPSHOT")
    annotationProcessor("com.velocitypowered:velocity-api:3.4.0-SNAPSHOT")

    implementation("net.labymod.serverapi:server-velocity:1.0.6")
    implementation("net.labymod.serverapi:server-common:1.0.6")
    implementation("net.labymod.serverapi:server-api:1.0.6")
}

kotlin {
    jvmToolchain(21)
}

tasks.shadowJar {
    archiveFileName.set("VulpesCloud-LabyMod-Module.jar")
}