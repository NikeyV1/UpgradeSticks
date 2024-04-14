package de.nikey.upgradesticks.ItemStacks;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MobilitySticks {

    public static void WalkSpeedStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§eWalk Speed USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncrease movement speed by +8%");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }

    public static void SwimSpeedStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§eSwim Speed USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncrease swimming speed by +10%");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }

    public static void HungerMoveStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§eHunger Move USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncrease chance to gain 1 hunger back by 0.001%");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }

    public static void ExpMoveStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§eExperience Move USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncrease chance to gain 1 experience by 0.001% ");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }
}
