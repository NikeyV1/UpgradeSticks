package de.nikey.upgradesticks;

import de.nikey.upgradesticks.listener.USBMenü;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class UpgradeSticks extends JavaPlugin {

    private static UpgradeSticks plugin;

    @Override
    public void onEnable() {
        plugin = this;
        USBMenü.loadDataFile();
        USBMenü.playerMenus = new HashMap<>();

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new USBMenü(),this);

    }

    @Override
    public void onDisable() {
        USBMenü.saveDataFile();
    }

    public static UpgradeSticks getPlugin() {
        return plugin;
    }
}
