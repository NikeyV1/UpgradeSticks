package de.nikey.upgradesticks.listener;

import de.nikey.upgradesticks.ItemStacks.DefenseSticks;
import de.nikey.upgradesticks.ItemStacks.MobilitySticks;
import de.nikey.upgradesticks.ItemStacks.UtilitySticks;
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

        if (clickedInventory != null) {
            if (event.getView().getTitle().equalsIgnoreCase("USB Menu")) {
                event.setCancelled(true);
                //Menü
                if (clickedInventory == playerInv.get(event.getWhoClicked())) {
                    if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.PAPER) {
                        ItemStack currentItem = event.getCurrentItem();
                        if (currentItem.getItemMeta().getDisplayName().contains("§c")) {
                            Inventory inventory = playerInv.get(event.getWhoClicked());
                            inventory.setItem(event.getSlot(),new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§cMain Damage USB (Close)")) {
                                StrenghSticks.CloseDamageStick((Player) event.getWhoClicked());
                            } else if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§cMain Damage USB (Distant)")) {
                                StrenghSticks.DistantDamageStick((Player) event.getWhoClicked());
                            }else if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§cAttack Speed USB")) {
                                StrenghSticks.AttackSpeed((Player) event.getWhoClicked());
                            }else if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§cExplosion Damage USB")) {
                                StrenghSticks.ExplosionDamageStick((Player) event.getWhoClicked());
                            }else if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§cDamage USB")) {
                                StrenghSticks.DamageStick((Player) event.getWhoClicked());
                            }
                            playerInv.replace((Player) event.getWhoClicked(),inventory);
                            savePlayerBackpack(((Player) event.getWhoClicked()).getPlayer());
                        }else if (currentItem.getItemMeta().getDisplayName().contains("§e")) {
                            Inventory inventory = playerInv.get(event.getWhoClicked());
                            inventory.setItem(event.getSlot(),new ItemStack(Material.YELLOW_STAINED_GLASS_PANE));

                            if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§eWalk Speed USB")) {
                                MobilitySticks.WalkSpeedStick((Player) event.getWhoClicked());
                            } else if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§eSwim Speed USB")) {
                                MobilitySticks.SwimSpeedStick((Player) event.getWhoClicked());
                            }else if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§eExperience Move USB")) {
                                MobilitySticks.ExpMoveStick((Player) event.getWhoClicked());
                            }else if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§eHunger Move USB")) {
                                MobilitySticks.HungerMoveStick((Player) event.getWhoClicked());
                            }

                            playerInv.replace((Player) event.getWhoClicked(),inventory);
                            savePlayerBackpack(((Player) event.getWhoClicked()).getPlayer());
                        }else if (currentItem.getItemMeta().getDisplayName().contains("§d")) {
                            Inventory inventory = playerInv.get(event.getWhoClicked());
                            inventory.setItem(event.getSlot(),new ItemStack(Material.PURPLE_STAINED_GLASS_PANE));

                            if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§dArmor USB")) {
                                DefenseSticks.ArmorStick((Player) event.getWhoClicked());
                            } else if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§dArmor Toughness USB")) {
                                DefenseSticks.ArmorToughnessStick((Player) event.getWhoClicked());
                            }else if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§dKnockback Resistance USB")) {
                                DefenseSticks.KnockbackResistanceStick((Player) event.getWhoClicked());
                            }else if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§dDamage Resistance USB")) {
                                DefenseSticks.DamageResistanceStick((Player) event.getWhoClicked());
                            }else if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§dThorns USB")) {
                                DefenseSticks.ThornsStick((Player) event.getWhoClicked());
                            }

                            playerInv.replace((Player) event.getWhoClicked(),inventory);
                            savePlayerBackpack(((Player) event.getWhoClicked()).getPlayer());
                        }else if (currentItem.getItemMeta().getDisplayName().contains("§a")) {
                            Inventory inventory = playerInv.get(event.getWhoClicked());
                            inventory.setItem(event.getSlot(),new ItemStack(Material.LIME_STAINED_GLASS_PANE));

                            if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§aLightning Riptide USB")) {
                                UtilitySticks.TridentLightningStick((Player) event.getWhoClicked());
                            } else if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§aLuck USB")) {
                                UtilitySticks.LuckStick((Player) event.getWhoClicked());
                            }else if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§aAxe Armor Damage USB")) {
                                UtilitySticks.AxeDurabilityStick((Player) event.getWhoClicked());
                            }else if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("§aShield Break USB")) {
                                UtilitySticks.ShieldBreakStick((Player) event.getWhoClicked());
                            }

                            playerInv.replace((Player) event.getWhoClicked(),inventory);
                            savePlayerBackpack(((Player) event.getWhoClicked()).getPlayer());
                        }
                    }
                }else {
                    if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.PAPER) {
                        ItemStack currentItem = event.getCurrentItem();
                        Inventory inventory = event.getView().getTopInventory();
                        if (currentItem.getItemMeta().getDisplayName().contains("§c")) {
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
                        }else if (currentItem.getItemMeta().getDisplayName().contains("§e")) {
                            int first = inventory.first(Material.YELLOW_STAINED_GLASS_PANE);
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
                        }else if (currentItem.getItemMeta().getDisplayName().contains("§d")) {
                            int first = inventory.first(Material.PURPLE_STAINED_GLASS_PANE);
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
                        }else if (currentItem.getItemMeta().getDisplayName().contains("§a")) {
                            int first = inventory.first(Material.LIME_STAINED_GLASS_PANE);
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
