package de.nikey.upgradesticks.ItemStacks;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class DefenseSticks {

    public static void ArmorStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§7Armor USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncrease Armor");
        lore.add("§f+0.75");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        if (player.getInventory().firstEmpty() != -1) {
            player.getInventory().addItem(stack);
        }else {
            player.getWorld().dropItem(player.getLocation(),stack);
        }
    }

    public static void ArmorToughnessStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§7Armor Toughness USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncrease Armor Toughness");
        lore.add("§f+1");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        if (player.getInventory().firstEmpty() != -1) {
            player.getInventory().addItem(stack);
        }else {
            player.getWorld().dropItem(player.getLocation(),stack);
        }
    }

    public static void KnockbackResistanceStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§7Knockback Resistance USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncrease Knockback Resistance");
        lore.add("§f+0.3");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        if (player.getInventory().firstEmpty() != -1) {
            player.getInventory().addItem(stack);
        }else {
            player.getWorld().dropItem(player.getLocation(),stack);
        }
    }

    public static void DamageResistanceStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§7Damage Resistance USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncrease chance for attacks not dealing damage");
        lore.add("§f+2.5%");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        if (player.getInventory().firstEmpty() != -1) {
            player.getInventory().addItem(stack);
        }else {
            player.getWorld().dropItem(player.getLocation(),stack);
        }
    }

    public static void ThornsStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§7Thorns USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncrease chance for thorns");
        lore.add("§f+5%");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        if (player.getInventory().firstEmpty() != -1) {
            player.getInventory().addItem(stack);
        }else {
            player.getWorld().dropItem(player.getLocation(),stack);
        }
    }

}
