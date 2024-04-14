package de.nikey.upgradesticks;

import de.nikey.upgradesticks.ItemStacks.MobilitySticks;
import de.nikey.upgradesticks.listener.DefenseUSB;
import de.nikey.upgradesticks.listener.MobilityUSB;
import de.nikey.upgradesticks.listener.StrenghtUSB;
import de.nikey.upgradesticks.listener.USBMenu;
import de.nikey.upgradesticks.usbsticks.MovementStick;
import de.nikey.upgradesticks.usbsticks.StrengthStick;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class UpgradeSticks extends JavaPlugin {

    private static UpgradeSticks plugin;

    @Override
    public void onEnable() {
        plugin = this;
        USBMenu.loadPlayerData();;

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new USBMenu(),this);
        pm.registerEvents(new StrengthStick(),this);
        pm.registerEvents(new StrenghtUSB(),this);
        pm.registerEvents(new MobilityUSB(),this);
        pm.registerEvents(new MovementStick(),this);
        pm.registerEvents(new DefenseUSB(),this);

    }

    @Override
    public void onDisable() {
        USBMenu.savePlayerData();
    }

    public static UpgradeSticks getPlugin() {
        return plugin;
    }
}
