package com.yourname.autoregx.commands;

import com.yourname.autoregx.AutoRegX;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LinfoCommand implements CommandExecutor {
    private final AutoRegX plugin;
    public LinfoCommand(AutoRegX plugin) { this.plugin = plugin; }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player p = (Player) sender;
        var info = plugin.getLoginInfo(p);
        p.sendMessage(ChatColor.AQUA + "Последний вход: " + info.lastLogin);
        p.sendMessage(ChatColor.AQUA + "IP: " + info.ip);
        p.sendMessage(ChatColor.AQUA + "Страна: " + info.country);
        p.sendMessage(ChatColor.AQUA + "Город: " + info.city);
        p.sendMessage(ChatColor.AQUA + "Смена пароля: " + info.lastPassChange);
        return true;
    }
