package de.nikey.upgradesticks.api;

import de.nikey.upgradesticks.utils.Menu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MobilityUSBs {
    public static int getAmountWalkSpeed(Player player) {
        Inventory inventory = Menu.invMenu.get(player);
        int amount = 0;
        // Durch das Inventar des Spielers iterieren
        if (inventory != null) {
            for (ItemStack item : inventory.getContents()) {
                if (item != null && item.getType() == Material.PAPER && item.hasItemMeta()) {
                    if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§eWalk Speed USB")){
                        amount += 1;
                    }
                }
            }
        }
        return amount;
    }

    public static int getAmountSwimSpeed(Player player) {
        Inventory inventory = Menu.invMenu.get(player);
        int amount = 0;
        // Durch das Inventar des Spielers iterieren
        if (inventory != null) {
            for (ItemStack item : inventory.getContents()) {
                if (item != null && item.getType() == Material.PAPER && item.hasItemMeta()) {
                    if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§eSwim Speed USB")){
                        amount += 1;
                    }
                }
            }
        }
        return amount;
    }

    public static int getAmountHungerMove(Player player) {
        Inventory inventory = Menu.invMenu.get(player);
        int amount = 0;
        // Durch das Inventar des Spielers iterieren
        if (inventory != null) {
            for (ItemStack item : inventory.getContents()) {
                if (item != null && item.getType() == Material.PAPER && item.hasItemMeta()) {
                    if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§eHunger Move USB")){
                        amount += 1;
                    }
                }
            }
        }
        return amount;
    }

    public static int getAmountExpMove(Player player) {
        Inventory inventory = Menu.invMenu.get(player);
        int amount = 0;
        // Durch das Inventar des Spielers iterieren
        if (inventory != null) {
            for (ItemStack item : inventory.getContents()) {
                if (item != null && item.getType() == Material.PAPER && item.hasItemMeta()) {
                    if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§eExperience Move USB")){
                        amount += 1;
                    }
                }
            }
        }
        return amount;
    }
}
