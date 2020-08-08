package com.jackbaron.bifrost;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;

class Chat {
    static BaseComponent[] message(String msg) {
        return new ComponentBuilder(">>> ").color(ChatColor.BLUE).bold(true)
                .append(msg).color(ChatColor.GRAY).bold(false)
                .create();
    }

    static BaseComponent[] errorMessage(String msg) {
        return new ComponentBuilder(">>> ").color(ChatColor.RED).bold(true)
                .append(msg).color(ChatColor.GRAY).bold(false)
                .create();
    }
}
