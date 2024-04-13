package de.nikey.upgradesticks.ItemStacks;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class StrenghSticks {
    public static void CloseDamageStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§cDamage USB (Close)");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncreases damage by +7.5% Damage to close targets");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }

    public static void DistantDamageStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§cDamage USB (Distant)");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncreases damage by +7.5% Damage to far-off targets");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }
}
