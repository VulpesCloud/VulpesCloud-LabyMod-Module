package de.vulpescloud.modules.labymod.velocity

import net.labymod.serverapi.core.model.feature.DiscordRPC
import net.labymod.serverapi.server.velocity.LabyModPlayer

object DiscordRPCUtils {

    fun testRPC(labyModPlayer: LabyModPlayer) {
        val discordRPC = DiscordRPC.createWithStart("Test", System.currentTimeMillis())

        labyModPlayer.sendDiscordRPC(discordRPC)
    }
}
