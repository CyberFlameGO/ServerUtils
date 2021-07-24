package net.frankheijden.serverutils.bungee.listeners;

import net.frankheijden.serverutils.bungee.entities.BungeeCommandSender;
import net.frankheijden.serverutils.bungee.entities.BungeePlugin;
import net.frankheijden.serverutils.common.listeners.PlayerListener;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class BungeePlayerListener extends PlayerListener<BungeePlugin, BungeeCommandSender> implements Listener {

    public BungeePlayerListener(BungeePlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onServerConnect(ServerConnectEvent event) {
        if (event.getReason() != ServerConnectEvent.Reason.JOIN_PROXY) return;
        handleUpdate(plugin.getChatProvider().get(event.getPlayer()));
    }
}
