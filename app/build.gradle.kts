repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

plugins {
    id("fumobot.kotlin-application-conventions")
}

dependencies {
    implementation("dev.kord:kord-core:0.8.0-M17")
}

application {
    mainClass.set("fumobot.app.AppKt")
}
