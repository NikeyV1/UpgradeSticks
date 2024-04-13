package de.nikey.upgradesticks;

import de.nikey.upgradesticks.listener.StrenghtUSB;
import de.nikey.upgradesticks.listener.USBMenu;
import de.nikey.upgradesticks.usbsticks.StrenghStick;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class UpgradeSticks extends JavaPlugin {

    private static UpgradeSticks plugin;

    @Override
    public void onEnable() {
        plugin = this;
        USBMenu.loadPlayerData();;

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new USBMenu(),this);
        pm.registerEvents(new StrenghStick(),this);

    }

    @Override
    public void onDisable() {
        USBMenu.savePlayerData();
    }

    public static UpgradeSticks getPlugin() {
        return plugin;
    }
}
