package fumobot.library.config

data class DiscordConfig(
    val token: String
)

fun loadConfig(): DiscordConfig = DiscordConfig("NjUwNDUwNjU3MjExNDQ5MzY2.Gg9PPy.1U2dqImKAP-CgW7h0geuMTHuvUEF_3ZBg5hoY0")