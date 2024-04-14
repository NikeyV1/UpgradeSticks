package de.nikey.upgradesticks.api;

import de.nikey.upgradesticks.listener.USBMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DefenseUSBs {

    public static int getAmountArmor(Player player) {
        Inventory inventory = USBMenu.playerInv.get(player);
        int amount = 0;
        // Durch das Inventar des Spielers iterieren
        if (inventory != null) {
            for (ItemStack item : inventory.getContents()) {
                if (item != null && item.getType() == Material.PAPER && item.hasItemMeta()) {
                    if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§dArmor USB")){
                        amount += 1;
                    }
                }
            }
        }
        return amount;
    }

    public static int getAmountArmorToughness(Player player) {
        Inventory inventory = USBMenu.playerInv.get(player);
        int amount = 0;
        // Durch das Inventar des Spielers iterieren
        if (inventory != null) {
            for (ItemStack item : inventory.getContents()) {
                if (item != null && item.getType() == Material.PAPER && item.hasItemMeta()) {
                    if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§dArmor Toughness USB")){
                        amount += 1;
                    }
                }
            }
        }
        return amount;
    }

    public static int getAmountKnockbackResistance(Player player) {
        Inventory inventory = USBMenu.playerInv.get(player);
        int amount = 0;
        // Durch das Inventar des Spielers iterieren
        if (inventory != null) {
            for (ItemStack item : inventory.getContents()) {
                if (item != null && item.getType() == Material.PAPER && item.hasItemMeta()) {
                    if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§dKnockback Resistance USB")){
                        amount += 1;
                    }
                }
            }
        }
        return amount;
    }

    public static int getAmountDamageResistance(Player player) {
        Inventory inventory = USBMenu.playerInv.get(player);
        int amount = 0;
        // Durch das Inventar des Spielers iterieren
        if (inventory != null) {
            for (ItemStack item : inventory.getContents()) {
                if (item != null && item.getType() == Material.PAPER && item.hasItemMeta()) {
                    if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§dDamage Resistance USB")){
                        amount += 1;
                    }
                }
            }
        }
        return amount;
    }
}