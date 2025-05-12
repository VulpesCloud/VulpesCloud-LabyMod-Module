package de.vulpescloud.modules.labymod.velocity

import net.labymod.serverapi.core.model.feature.DiscordRPC
import net.labymod.serverapi.core.packet.clientbound.game.feature.DiscordRPCPacket
import net.labymod.serverapi.server.velocity.LabyModProtocolService
import java.util.UUID

object DiscordRPCUtils {

    fun testRPC(uuid: UUID) {
        val discordRPC = DiscordRPC.createWithStart("Test", System.currentTimeMillis())

        LabyModProtocolService.get().getPlayer(uuid)!!.sendDiscordRPC(discordRPC)

        LabyModProtocolService.get().labyModProtocol().sendPacket(uuid, DiscordRPCPacket(discordRPC))
    }

}
