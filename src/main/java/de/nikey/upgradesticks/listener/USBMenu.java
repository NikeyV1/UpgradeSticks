package de.nikey.upgradesticks.listener;

import de.nikey.upgradesticks.UpgradeSticks;
import de.nikey.upgradesticks.utils.MenuInventory;
import de.nikey.upgradesticks.ItemStacks.StrenghSticks;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.*;
import java.util.*;

@SuppressWarnings("ALL")
public class USBMenu implements Listener {
    private static FileConfiguration playerDataConfig;
    private static File dataFile;
    public static Map<UUID, List<ItemStack>> playerMenus = new HashMap<>();
    public static HashMap<Player, Inventory > playerInv = new HashMap<>();


    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (event.getBlockPlaced().getType() == Material.CHEST) {
            event.setCancelled(true);
            openMenu(player);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory clickedInventory = event.getClickedInventory();
        Inventory playerInventory = event.getWhoClicked().getInventory();

        // Überprüfe, ob ein Spieler auf ein Inventar klickt
        if (clickedInventory != null) {
            // Überprüfe, ob das geklickte Inventar "inv" ist
            if (event.getView().getTitle().equalsIgnoreCase("USB Menu")) {
                event.setCancelled(true);
                // Überprüfe, ob das geklickte Item ein Papier ist
                if (clickedInventory == playerInv.get(event.getWhoClicked())) {
                    if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.PAPER) {
                        ItemStack currentItem = event.getCurrentItem();
                        if (currentItem.getItemMeta().getDisplayName().contains("§c")) {
                            Inventory inventory = playerInv.get(event.getWhoClicked());
                            inventory.setItem(event.getSlot(),new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            StrenghSticks.DamageStick((Player) event.getWhoClicked());
                            playerInv.replace((Player) event.getWhoClicked(),inventory);
                            savePlayerBackpack(((Player) event.getWhoClicked()).getPlayer());
                        }
                    }
                }else {
                    if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.PAPER) {
                        ItemStack currentItem = event.getCurrentItem();
                        if (currentItem.getItemMeta().getDisplayName().contains("§c")) {
                            Inventory inventory = event.getView().getTopInventory();
                            int first = inventory.first(Material.RED_STAINED_GLASS_PANE);
                            if (first != -1) {
                                currentItem.setAmount(currentItem.getAmount()-1);
                                ItemStack stack = new ItemStack(Material.PAPER);
                                stack.setItemMeta(currentItem.getItemMeta());
                                stack.setAmount(1);
                                Inventory inv = playerInv.get(event.getWhoClicked());
                                inv.setItem(first,stack);
                                playerInv.replace((Player) event.getWhoClicked(),inv);
                                savePlayerBackpack(((Player) event.getWhoClicked()).getPlayer());
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        savePlayerBackpack(player);
    }

    private void openMenu(Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, "USB Menu");
        List<ItemStack> contents = getPlayerBackpackContents(player);
        if (contents != null) {
            inv.setContents(contents.toArray(new ItemStack[0]));
        }
        MenuInventory.USBMenu(inv);
        playerInv.put(player,inv);
        player.openInventory(inv);
    }

    private void savePlayerBackpack(Player player) {
        playerMenus.put(player.getUniqueId(), new ArrayList<>(List.of(playerInv.get(player).getContents())));
    }

    private List<ItemStack> getPlayerBackpackContents(Player player) {
        return playerMenus.getOrDefault(player.getUniqueId(), null);
    }

    public static void loadPlayerData() {
        playerDataConfig = UpgradeSticks.getPlugin().getConfig();
        ConfigurationSection playerData = playerDataConfig.getConfigurationSection("playerMenus");
        if (playerData != null) {
            for (String uuidString : playerData.getKeys(false)) {
                UUID uuid = UUID.fromString(uuidString);
                List<?> contents = playerData.getList(uuidString);
                if (contents != null) {
                    List<ItemStack> backpackContents = new ArrayList<>();
                    for (Object item : contents) {
                        if (item instanceof ItemStack) {
                            backpackContents.add((ItemStack) item);
                        }
                    }
                    playerMenus.put(uuid, backpackContents);
                }
            }
        }
    }

    public static void savePlayerData() {
        for (UUID uuid : playerMenus.keySet()) {
            playerDataConfig.set("playerMenus." + uuid.toString(), playerMenus.get(uuid));
        }
        UpgradeSticks.getPlugin().saveConfig();
    }
}