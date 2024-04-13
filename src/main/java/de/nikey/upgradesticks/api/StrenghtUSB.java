package de.nikey.upgradesticks.api;

import de.nikey.upgradesticks.ItemStacks.StrenghSticks;
import de.nikey.upgradesticks.listener.USBMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("ALL")
public class StrenghtUSB {
    public static int getAmount(Player player) {
        Inventory inventory = USBMenu.playerInv.get(player);
        int amount = 0;

        // Durch das Inventar des Spielers iterieren
        for (ItemStack item : inventory.getContents()) {
            if (item != null && item.getType() == Material.PAPER && item.hasItemMeta()) {
                if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§cDamage USB (Close)")){
                    amount += 1;
                }
            }
        }
        return amount;
    }
}
