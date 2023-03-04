package fumobot.app

import dev.kord.core.Kord

suspend fun main() {
    val kord = Kord("token")
    kord.login()
}
