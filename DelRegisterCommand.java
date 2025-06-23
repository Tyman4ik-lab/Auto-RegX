package com.yourname.autoregx.commands;

import com.yourname.autoregx.AutoRegX;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DelRegisterCommand implements CommandExecutor {
    private final AutoRegX plugin;
    public DelRegisterCommand(AutoRegX plugin) { this.plugin = plugin; }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player p = (Player) sender;
        var cfg = plugin.getCfg();
        if (!cfg.contains("users." + p.getUniqueId())) {
            p.sendMessage(ChatColor.RED + "Вы не зарегистрированы.");
            return true;
        }
        cfg.set("users." + p.getUniqueId(), null);
        plugin.saveConfig();
        p.sendMessage(ChatColor.GREEN + "Ваша регистрация удалена.");
        return true;
    }
}
