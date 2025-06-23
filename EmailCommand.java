package com.yourname.autoregx.commands;

import com.yourname.autoregx.AutoRegX;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EmailCommand implements CommandExecutor {
    private final AutoRegX plugin;
    public EmailCommand(AutoRegX plugin) { this.plugin = plugin; }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage(ChatColor.YELLOW + "Использование: /email <адрес>");
            return true;
        }
        String email = args[0];
        // Логика отправки пароля на email
        plugin.sendPasswordByEmail(sender.getName(), email);
        sender.sendMessage(ChatColor.GREEN + "Пароль отправлен на ваш email.");
        return true;
    }
}
