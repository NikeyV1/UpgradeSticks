package de.nikey.upgradesticks.ItemStacks;

import io.papermc.paper.event.player.PlayerItemCooldownEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class SupportSticks implements Listener {

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
        lore.add("§f-7.5%");
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
        lore.add("§f-10%");
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
        itemMeta.setDisplayName("§dHoming Arrows USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fCauses arrows to track targets");
        lore.add("§f+10%");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }

    public static void ItemCooldownStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§dItem Cooldown USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fDecreases item cooldown time");
        lore.add("§f-15%");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }

    public static void PotionDurationStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§dPotion Duration USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncreases potion duration");
        lore.add("§f+15%");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }
}
