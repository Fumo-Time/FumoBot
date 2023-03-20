plugins {
    id("fumobot.kotlin-application-conventions")
}

dependencies {
    compileOnly("dev.kord:kord-core:0.8.0-M17")

    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.10")
}