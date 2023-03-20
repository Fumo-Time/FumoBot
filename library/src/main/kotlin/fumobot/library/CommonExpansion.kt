package fumobot.library

import dev.kord.core.Kord
import dev.kord.core.event.gateway.ReadyEvent
import dev.kord.core.on
import dev.kord.gateway.Intents
import dev.kord.gateway.PrivilegedIntent
import fumobot.library.config.loadConfig
import fumobot.library.expansion.ExpansionRegistry
import fumobot.library.expansion.initExpansions

object CommonExpansion {

    lateinit var kord: Kord

    val expansionRegistry: ExpansionRegistry = ExpansionRegistry()

    val config by lazy {
        loadConfig()
    }

    suspend fun init() {
        initDiscord()
        initExpansions()
    }

    @OptIn(PrivilegedIntent::class)
    private suspend fun initDiscord() {
        kord = Kord(config.token)

        kord.on<ReadyEvent> {
            println("literalmente o fumo bot")
        }

        kord.login {
            intents { +Intents.all }

            presence {
                watching("fumos fazendo merda")
            }
        }
    }

}