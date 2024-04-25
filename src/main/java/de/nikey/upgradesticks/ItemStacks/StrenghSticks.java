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
        itemMeta.setDisplayName("§cMain Damage USB (Close)");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncrease damage by +7.5% Damage to close targets");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }

    public static void DistantDamageStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§cMain Damage USB (Distant)");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncrease damage by +7.5% Damage to far-off targets");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }

    public static void ExplosionDamageStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§cExplosion Damage USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncrease damage by +7.5% Damage from explosions");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }

    public static void AttackSpeed(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§cAttack Speed USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncrease attack speed by +7.5%");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }

    public static void DamageStick(Player player) {
        ItemStack stack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.setDisplayName("§cDamage USB");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§fIncrease damage from everything by +5%");
        itemMeta.setLore(lore);
        stack.setItemMeta(itemMeta);
        player.getInventory().addItem(stack);
    }
}
