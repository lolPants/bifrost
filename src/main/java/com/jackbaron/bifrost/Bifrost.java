package com.jackbaron.bifrost;

import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

import java.util.Map;

public class Bifrost extends Plugin {
    @Override
    public void onEnable() {
        PluginManager manager = getProxy().getPluginManager();

        Map<String, ServerInfo> servers = getProxy().getServers();
        for (Map.Entry<String, ServerInfo> entry : servers.entrySet()) {
            ServerInfo info = entry.getValue();

            String name = info.getName();
            String alias = name.substring(0, 1);

            manager.registerCommand(this, new ConnectCommand(name, alias));
        }
    }
}
