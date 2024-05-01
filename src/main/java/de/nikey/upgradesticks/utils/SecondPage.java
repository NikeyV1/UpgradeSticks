package de.nikey.upgradesticks.utils;

import de.nikey.upgradesticks.ItemStacks.*;
import de.nikey.upgradesticks.UpgradeSticks;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class SecondPage implements Listener {
    private static FileConfiguration playerDataConfig;
    public static Map<String, List<ItemStack>> playerMenus = new HashMap<>();
    public static HashMap<Player, Inventory > playerInv = new HashMap<>();


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory clickedInventory = event.getClickedInventory();

        if (clickedInventory != null) {
            if (event.getView().getTitle().equalsIgnoreCase("USB Menu 2")) {
                event.setCancelled(true);
                //Menü
                if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.MAGENTA_GLAZED_TERRACOTTA) {
                    //USBMenu.openMenu((Player) event.getWhoClicked());
                }
                if (clickedInventory == playerInv.get(event.getWhoClicked())) {
                    if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.PAPER) {
                        ItemStack currentItem = event.getCurrentItem();
                        if (currentItem.getItemMeta().getDisplayName().contains("§c")) {
                            Inventory inventory = playerInv.get(event.getWhoClicked());
                            inventory.setItem(event.getSlot(),new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                            if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§dHeart Regeneration USB")) {
                                SupportSticks.HeartRegenerationStick((Player) event.getWhoClicked());
                            } else if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§dArrow Saver USB")) {
                                SupportSticks.ArrowSaverStick((Player) event.getWhoClicked());
                            }else if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§dDurability Saver USB")) {
                                SupportSticks.DurabilitySaverStick((Player) event.getWhoClicked());
                            }else if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§dLife Recovery USB")) {
                                SupportSticks.LifeRecoveryStick((Player) event.getWhoClicked());
                            }else if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§dHoming Arrows USB")) {
                                SupportSticks.HomingArrowsStick((Player) event.getWhoClicked());
                            }else if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§dItem Cooldown USB")) {
                                SupportSticks.ItemCooldownStick((Player) event.getWhoClicked());
                            }else if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§dPotion Duration USB")) {
                                SupportSticks.PotionDurationStick((Player) event.getWhoClicked());
                            }
                            playerInv.put((Player) event.getWhoClicked(),inventory);
                            savePlayerBackpack(((Player) event.getWhoClicked()).getPlayer());
                        }
                    }
                }else {
                    if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.PAPER) {
                        ItemStack currentItem = event.getCurrentItem();
                        Inventory inventory = event.getView().getTopInventory();
                        if (currentItem.getItemMeta().getDisplayName().contains("§7")) {
                            int first = inventory.first(Material.GRAY_STAINED_GLASS_PANE);
                            if (first != -1) {
                                currentItem.setAmount(currentItem.getAmount() - 1);
                                ItemStack stack = new ItemStack(Material.PAPER);
                                stack.setItemMeta(currentItem.getItemMeta());
                                stack.setAmount(1);
                                Inventory inv = playerInv.get(event.getWhoClicked());
                                inv.setItem(first, stack);
                                playerInv.put((Player) event.getWhoClicked(), inv);
                                savePlayerBackpack((Player) event.getWhoClicked());
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

    public static void openMenu(Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, "USB Menu 2");
        List<ItemStack> contents = getPlayerBackpackContents(player);
        if (contents != null) {
            inv.setContents(contents.toArray(new ItemStack[0]));
        }
        MenuInventory.secondPage(inv);
        playerInv.put(player,inv);
        player.openInventory(inv);
    }

    private void savePlayerBackpack(Player player) {
        playerMenus.put(player.getName(), new ArrayList<>(List.of(playerInv.get(player).getContents())));
    }

    private static List<ItemStack> getPlayerBackpackContents(Player player) {
        return playerMenus.getOrDefault(player.getName(), null);
    }

    public static void loadPlayerData() {
        playerDataConfig = UpgradeSticks.getPlugin().getConfig();
        ConfigurationSection playerData = playerDataConfig.getConfigurationSection("playerMenus");
        if (playerData != null) {
            for (String playerName : playerData.getKeys(false)) {
                List<?> contents = playerData.getList(playerName);
                if (contents != null) {
                    List<ItemStack> backpackContents = new ArrayList<>();
                    for (Object item : contents) {
                        if (item instanceof ItemStack) {
                            backpackContents.add((ItemStack) item);
                        }
                    }
                    playerMenus.put(playerName, backpackContents);
                }
            }
        }
    }

    public static void savePlayerData() {
        for (String playerName : playerMenus.keySet()) {
            playerDataConfig.set("playerMenus." + playerName, playerMenus.get(playerName));
        }
        UpgradeSticks.getPlugin().saveConfig();
    }
}
