package de.nikey.upgradesticks;

import de.nikey.upgradesticks.listener.*;
import de.nikey.upgradesticks.usbsticks.DefenseStick;
import de.nikey.upgradesticks.usbsticks.MovementStick;
import de.nikey.upgradesticks.usbsticks.StrengthStick;
import de.nikey.upgradesticks.usbsticks.UtilityStick;
import de.nikey.upgradesticks.utils.Menu;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class UpgradeSticks extends JavaPlugin {

    private static UpgradeSticks plugin;

    @Override
    public void onEnable() {
        plugin = this;
        Menu.loadMenu1();
        Menu.loadMenu2();

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Menu(),this);
        pm.registerEvents(new StrengthStick(),this);
        pm.registerEvents(new StrenghtUSB(),this);
        pm.registerEvents(new MobilityUSB(),this);
        pm.registerEvents(new MovementStick(),this);
        pm.registerEvents(new DefenseUSB(),this);
        pm.registerEvents(new DefenseStick(),this);
        pm.registerEvents(new UtilityUSB(),this);
        pm.registerEvents(new UtilityStick(),this);
        pm.registerEvents(new SupportUSB(),this);


    }

    @Override
    public void onDisable() {
        Menu.saveMenu1();
        Menu.saveMenu2();
    }

    public static UpgradeSticks getPlugin() {
        return plugin;
    }
}
