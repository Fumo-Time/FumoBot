plugins {
    id("fumobot.kotlin-application-conventions")
}

dependencies {
    implementation(project(":library"))
    implementation(project(":expansions:fish"))
    implementation("dev.kord:kord-core:0.8.0-M17")
}

application {
    mainClass.set("fumobot.app.AppKt")
}
