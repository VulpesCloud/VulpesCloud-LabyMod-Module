package de.vulpescloud.modules.labymod.velocity

import com.velocitypowered.api.event.EventManager
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.connection.PluginMessageEvent
import com.velocitypowered.api.event.connection.PostLoginEvent
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.plugin.PluginContainer
import com.velocitypowered.api.proxy.Player
import com.velocitypowered.api.proxy.ProxyServer
import jakarta.inject.Inject
import net.labymod.serverapi.server.velocity.LabyModProtocolService
import org.slf4j.LoggerFactory

@Plugin(id = "vulpescloud-proxy", name = "VulpesCloud-Proxy", authors = ["TheCGuy"])
@Suppress("unused")
class VelocityEntrypoint
@Inject
constructor(
    private val eventManager: EventManager,
    private val proxyServer: ProxyServer,
    private val pluginsContainer: PluginContainer,
) {
    private val logger = LoggerFactory.getLogger("VulpesCloud-LabyMod-Module")

    @Subscribe
    fun onProxyInitializeEvent(event: ProxyInitializeEvent) {
        LabyModProtocolService.initialize(this, proxyServer, logger)
    }

    @Subscribe
    fun onPlayerPostLogin(event: PostLoginEvent) {
        logger.info("Trying RPC for ${event.player.username} (${event.player.uniqueId})")
        // DiscordRPCUtils.testRPC(event.player.uniqueId)
    }

    @Subscribe
    fun onPluginMessageEvent(event: PluginMessageEvent) {
        logger.info("Plugin message received! IdentifierId: ${event.identifier.id}")
        if (event.identifier.id.equals("labymod:neo")) {
            logger.info("Identifier is labymod:neo")
            if (event.source is Player) {
                logger.info("Source is player")
                val player = event.source as Player
                DiscordRPCUtils.testRPC(player.uniqueId)
            }
        }
    }

}
