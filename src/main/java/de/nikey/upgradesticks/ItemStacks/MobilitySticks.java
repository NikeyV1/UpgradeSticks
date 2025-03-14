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
        lore.add("§fIncreases walk speed");
        lore.add("§f+10%");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        if (player.getInventory().firstEmpty() != -1) {
            player.getInventory().addItem(stack);
        }else {
            player.getWorld().dropItem(player.getLocation(),stack);
        }
    }

    public static void SwimSpeedStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§eSwim Speed USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncreases swimming speed");
        lore.add("§f+10%");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        if (player.getInventory().firstEmpty() != -1) {
            player.getInventory().addItem(stack);
        }else {
            player.getWorld().dropItem(player.getLocation(),stack);
        }
    }

    public static void HungerMoveStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§eHunger Move USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncreases chance to gain 1 hunger back");
        lore.add("§f+0.001%");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        if (player.getInventory().firstEmpty() != -1) {
            player.getInventory().addItem(stack);
        }else {
            player.getWorld().dropItem(player.getLocation(),stack);
        }
    }

    public static void ExpMoveStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§eExperience Move USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncreases chance to gain 1 experience point");
        lore.add("§f+0.001%");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        if (player.getInventory().firstEmpty() != -1) {
            player.getInventory().addItem(stack);
        }else {
            player.getWorld().dropItem(player.getLocation(),stack);
        }
    }
}
