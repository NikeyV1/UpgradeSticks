package de.nikey.upgradesticks.api;

import de.nikey.upgradesticks.utils.Menu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SupportUSBs {
    public static int getAmountHeartRegeneration(Player player) {
        Inventory inventory = Menu.invMenu.get(player);
        int amount = 0;
        // Durch das Inventar des Spielers iterieren
        if (inventory != null) {
            for (ItemStack item : inventory.getContents()) {
                if (item != null && item.getType() == Material.PAPER && item.hasItemMeta()) {
                    if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§dHeart Regeneration USB")){
                        amount += 1;
                    }
                }
            }
        }
        return amount;
    }


    public static int getAmountArrowSaver(Player player) {
        Inventory inventory = Menu.invMenu.get(player);
        int amount = 0;
        // Durch das Inventar des Spielers iterieren
        if (inventory != null) {
            for (ItemStack item : inventory.getContents()) {
                if (item != null && item.getType() == Material.PAPER && item.hasItemMeta()) {
                    if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§dArrow Saver USB")){
                        amount += 1;
                    }
                }
            }
        }
        return amount;
    }


    public static int getAmountDurabilitySaver(Player player) {
        Inventory inventory = Menu.invMenu.get(player);
        int amount = 0;
        // Durch das Inventar des Spielers iterieren
        if (inventory != null) {
            for (ItemStack item : inventory.getContents()) {
                if (item != null && item.getType() == Material.PAPER && item.hasItemMeta()) {
                    if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§dDurability Saver USB")){
                        amount += 1;
                    }
                }
            }
        }
        return amount;
    }


    public static int getAmountLifeRecovery(Player player) {
        Inventory inventory = Menu.invMenu.get(player);
        int amount = 0;
        // Durch das Inventar des Spielers iterieren
        if (inventory != null) {
            for (ItemStack item : inventory.getContents()) {
                if (item != null && item.getType() == Material.PAPER && item.hasItemMeta()) {
                    if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§dLife Recovery USB")){
                        amount += 1;
                    }
                }
            }
        }
        return amount;
    }

    public static int getAmountHomingArrows(Player player) {
        Inventory inventory = Menu.invMenu.get(player);
        int amount = 0;
        // Durch das Inventar des Spielers iterieren
        if (inventory != null) {
            for (ItemStack item : inventory.getContents()) {
                if (item != null && item.getType() == Material.PAPER && item.hasItemMeta()) {
                    if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§dHoming Arrows USB")){
                        amount += 1;
                    }
                }
            }
        }
        return amount;
    }

    public static int getAmountItemCooldown(Player player) {
        Inventory inventory = Menu.invMenu.get(player);
        int amount = 0;
        // Durch das Inventar des Spielers iterieren
        if (inventory != null) {
            for (ItemStack item : inventory.getContents()) {
                if (item != null && item.getType() == Material.PAPER && item.hasItemMeta()) {
                    if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§dItem Cooldown USB")){
                        amount += 1;
                    }
                }
            }
        }
        return amount;
    }

    public static int getAmountPotionDuration(Player player) {
        Inventory inventory = Menu.invMenu.get(player);
        int amount = 0;
        // Durch das Inventar des Spielers iterieren
        if (inventory != null) {
            for (ItemStack item : inventory.getContents()) {
                if (item != null && item.getType() == Material.PAPER && item.hasItemMeta()) {
                    if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§dPotion Duration USB")){
                        amount += 1;
                    }
                }
            }
        }
        return amount;
    }
}
