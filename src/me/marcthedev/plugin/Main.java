package me.marcthedev.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Logger;

public class Main extends JavaPlugin implements Listener {

    private Logger log = Bukkit.getLogger();

    public void onEnable() {
        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists()) {
            getLogger().info("Config.yml not found, creating!");
            saveDefaultConfig();
        } else {
            getLogger().info("Config.yml found, loading!");
        }
        log.info("Yay plugin works!");
    }

    public void onDisable() {
        log.info("");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;
        String error = "You do not have permission!";

        if(cmd.getName().equalsIgnoreCase("test")) {
            if(p.hasPermission("test.permission")) {
                p.sendMessage(getConfig().getString("test-text"));
                return true;
            }
            else {
                p.sendMessage(ChatColor.RED + error);
                return true;
            }
        }
        return true;
    }
}
