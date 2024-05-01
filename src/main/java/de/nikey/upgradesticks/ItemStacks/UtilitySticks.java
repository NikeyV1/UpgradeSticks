package de.nikey.upgradesticks.ItemStacks;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class UtilitySticks {

    public static void TridentLightningStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§aLightning Riptide USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncrease chance to strike lightning when damaging player with riptide");
        lore.add("§f+8%");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }

    public static void LuckStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§aLuck USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncrease luck level");
        lore.add("§f+1");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }

    public static void AxeDurabilityStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§aAxe Armor Damage USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncrease chance for an axe damaging armor");
        lore.add("§f+2.5%");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }

    public static void ShieldBreakStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§aShield Break USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncrease chance to damage players breaking your shield");
        lore.add("§f+5%");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }
}
