package com.jackbaron.bifrost;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

class ConnectCommand extends Command {
    private String name;

    ConnectCommand(String name, String alias) {
        super(name, null, alias);
        this.name = name;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            BaseComponent[] msg = Chat.errorMessage("This command can only be run by a player!");
            sender.sendMessage(msg);

            return;
        }

        if (!sender.hasPermission("bifrost.use")) {
            BaseComponent[] msg = Chat.errorMessage("You do not have permission to do that!");
            sender.sendMessage(msg);

            return;
        }

        ProxiedPlayer player = (ProxiedPlayer) sender;
        if (player.getServer().getInfo().getName().equalsIgnoreCase(this.name)) {
            BaseComponent[] msg = Chat.errorMessage("You are already connected to this server!");
            sender.sendMessage(msg);

            return;
        }

        ServerInfo target = ProxyServer.getInstance().getServerInfo(this.name);
        player.connect(target, (status, throwable) -> {
            if (!status) {
                BaseComponent[] msg = Chat.errorMessage("Failed to connect to server!");
                sender.sendMessage(msg);
            }
        });
    }
}
