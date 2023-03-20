package fumobot.fish

import dev.kord.common.entity.Snowflake
import dev.kord.core.behavior.interaction.response.respond
import dev.kord.core.event.interaction.ChatInputCommandInteractionCreateEvent
import dev.kord.core.on
import fumobot.library.expansion.Expansion

class FishExpansion: Expansion("fish") {
    override suspend fun load() {
        // TODO: Pre-load fishing data
    }

    override suspend fun init() {
        common.kord.createGuildChatInputCommand(
            Snowflake(759918602756292638L), "pescafumo", "pesque a remo"
        )

        common.kord.on<ChatInputCommandInteractionCreateEvent> {
            if (this.interaction.command.rootName != "pescafumo") return@on

            this.interaction.deferPublicResponse()
                .respond { content = "pesca fumo" }
        }
    }

}