package de.nikey.upgradesticks.api;

import de.nikey.upgradesticks.utils.Menu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class UtilityUSBs {

    public static int getAmountTridentLightning(Player player) {
        Inventory inventory = Menu.invMenu.get(player);
        int amount = 0;
        // Durch das Inventar des Spielers iterieren
        if (inventory != null) {
            for (ItemStack item : inventory.getContents()) {
                if (item != null && item.getType() == Material.PAPER && item.hasItemMeta()) {
                    if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§aLightning Riptide USB")){
                        amount += 1;
                    }
                }
            }
        }
        return amount;
    }

    public static int getAmountLuck(Player player) {
        Inventory inventory = Menu.invMenu.get(player);
        int amount = 0;
        // Durch das Inventar des Spielers iterieren
        if (inventory != null) {
            for (ItemStack item : inventory.getContents()) {
                if (item != null && item.getType() == Material.PAPER && item.hasItemMeta()) {
                    if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§aLuck USB")){
                        amount += 1;
                    }
                }
            }
        }
        return amount;
    }

    public static int getAmountAxeDurability(Player player) {
        Inventory inventory = Menu.invMenu.get(player);
        int amount = 0;
        // Durch das Inventar des Spielers iterieren
        if (inventory != null) {
            for (ItemStack item : inventory.getContents()) {
                if (item != null && item.getType() == Material.PAPER && item.hasItemMeta()) {
                    if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§aAxe Armor Damage USB")){
                        amount += 1;
                    }
                }
            }
        }
        return amount;
    }

    public static int getAmountShieldBreak(Player player) {
        Inventory inventory = Menu.invMenu.get(player);
        int amount = 0;
        // Durch das Inventar des Spielers iterieren
        if (inventory != null) {
            for (ItemStack item : inventory.getContents()) {
                if (item != null && item.getType() == Material.PAPER && item.hasItemMeta()) {
                    if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§aShield Break USB")){
                        amount += 1;
                    }
                }
            }
        }
        return amount;
    }
}
