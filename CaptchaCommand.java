package com.yourname.autoregx.commands;

import com.yourname.autoregx.AutoRegX;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CaptchaCommand implements CommandExecutor {
    private final AutoRegX plugin;
    public CaptchaCommand(AutoRegX plugin) { this.plugin = plugin; }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player p = (Player) sender;
        String code = plugin.getPendingCaptcha(p);
        if (args.length != 1) {
            p.sendMessage(ChatColor.YELLOW + "Использование: /captcha <код>");
            return true;
        }
        if (args[0].equals(code)) {
            plugin.verifyCaptcha(p);
            p.sendMessage(ChatColor.GREEN + "Капча пройдена.");
        } else {
            p.sendMessage(ChatColor.RED + "Неверный код капчи.");
        }
        return true;
    }
