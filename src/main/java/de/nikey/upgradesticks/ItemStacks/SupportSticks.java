package de.nikey.upgradesticks.ItemStacks;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class SupportSticks{

    public static void HeartRegenerationStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§dHeart Regeneration USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncrease Heart regeneration");
        lore.add("§f+20%");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }

    public static void ArrowSaverStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§dArrow Saver USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fDecreases amount of arrows used");
        lore.add("§f-15%");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }

    public static void DurabilitySaverStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§dDurability Saver USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fDecreases amount of durability used");
        lore.add("§f-20%");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }

    public static void LifeRecoveryStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§dLife Recovery USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fRegenerate hearts by defeating mobs");
        lore.add("§f+4%");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }

    public static void HomingArrowsStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§dLife Recovery USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fRegenerate hearts by defeating mobs");
        lore.add("§f+4%");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }

}
