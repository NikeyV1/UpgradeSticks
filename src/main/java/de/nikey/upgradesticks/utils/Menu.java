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
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("ALL")
public class Menu implements Listener {

    public static HashMap<String, Inventory> invMenu = new HashMap<>();
    public static HashMap<String, Inventory> invMenu2 = new HashMap<>();

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.CHEST) {
            openMenu(event.getPlayer());
            event.setCancelled(true);
        }
    }

    //@EventHandler
    //    public void onPlayerJoin(PlayerJoinEvent event) {
    //        Player player = event.getPlayer();
    //
    //
    //        Inventory inv = Bukkit.createInventory(null,36,"USB Menu");
    //        if (menuContents.get(player) != null) {
    //            inv.setContents(menuContents.get(player));
    //        }
    //        MenuInventory.USBMenu(inv);
    //        invMenu.put(player,inv);
    //
    //        Inventory inventory = Bukkit.createInventory(null,36,"USB Menu 2");
    //        if (menuContents2.get(player) != null) {
    //            inventory.setContents(menuContents2.get(player));
    //        }
    //        MenuInventory.secondPage(inventory);
    //        invMenu2.put(player,inventory);
    //    }

    public static void openMenu(Player player) {
        Inventory inventory = Bukkit.createInventory(null,36,"USB Menu");
        if (invMenu.get(player.getName()) != null && invMenu.get(player.getName()).getContents() != null) {
            inventory.setContents(invMenu.get(player.getName()).getContents());
        }else {
            player.sendMessage("P");
            MenuInventory.USBMenu(inventory);
        }
        invMenu.put(player.getName(),inventory);
        player.openInventory(inventory);
    }

    public static void openSecondPage(Player player) {
        Inventory inventory = Bukkit.createInventory(null,36,"USB Menu 2");
        if (invMenu2.get(player.getName()) != null &&invMenu2.get(player.getName()).getContents() != null) {
            inventory.setContents(invMenu2.get(player.getName()).getContents());
        }else {
            MenuInventory.secondPage(inventory);
        }
        invMenu2.put(player.getName(),inventory);
        player.openInventory(inventory);
    }

    //@EventHandler
    //    public void onPlayerQuit(PlayerQuitEvent event) {
    //        saveMenu1();
    //        saveMenu2();
    //    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        ItemStack item = event.getCurrentItem();
        Inventory clickedInventory = event.getClickedInventory();
        if (clickedInventory != null) {
            if (event.getView().getTitle().equalsIgnoreCase("USB Menu") || event.getView().getTitle().equalsIgnoreCase("USB Menu 2")) {
                event.setCancelled(true);
                //Menü
                if (clickedInventory == invMenu.get(event.getWhoClicked().getName())) {
                    if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.MAGENTA_GLAZED_TERRACOTTA) {
                        openSecondPage((Player) event.getWhoClicked());
                    }

                    if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.PAPER) {
                        if (item.getItemMeta().getDisplayName().contains("§c")) {
                            Inventory inventory = invMenu.get(event.getWhoClicked().getName());
                            inventory.setItem(event.getSlot(),new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§cMain Damage USB (Close)")) {
                                StrenghSticks.CloseDamageStick((Player) event.getWhoClicked());
                            } else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§cMain Damage USB (Distant)")) {
                                StrenghSticks.DistantDamageStick((Player) event.getWhoClicked());
                            }else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§cAttack Speed USB")) {
                                StrenghSticks.AttackSpeed((Player) event.getWhoClicked());
                            }else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§cExplosion Damage USB")) {
                                StrenghSticks.ExplosionDamageStick((Player) event.getWhoClicked());
                            }else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§cDamage USB")) {
                                StrenghSticks.DamageStick((Player) event.getWhoClicked());
                            }

                            invMenu.put(event.getWhoClicked().getName(),inventory);

                        }else if (item.getItemMeta().getDisplayName().contains("§e")) {
                            Inventory inventory = invMenu.get(event.getWhoClicked().getName());
                            inventory.setItem(event.getSlot(),new ItemStack(Material.YELLOW_STAINED_GLASS_PANE));

                            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§eWalk Speed USB")) {
                                MobilitySticks.WalkSpeedStick((Player) event.getWhoClicked());
                            } else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§eSwim Speed USB")) {
                                MobilitySticks.SwimSpeedStick((Player) event.getWhoClicked());
                            }else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§eExperience Move USB")) {
                                MobilitySticks.ExpMoveStick((Player) event.getWhoClicked());
                            }else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§eHunger Move USB")) {
                                MobilitySticks.HungerMoveStick((Player) event.getWhoClicked());
                            }

                            invMenu.put(event.getWhoClicked().getName(),inventory);

                        }else if (item.getItemMeta().getDisplayName().contains("§d")) {
                            Inventory inventory = invMenu.get(event.getWhoClicked().getName());
                            inventory.setItem(event.getSlot(),new ItemStack(Material.PURPLE_STAINED_GLASS_PANE));
                            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§dHeart Regeneration USB")) {
                                SupportSticks.HeartRegenerationStick((Player) event.getWhoClicked());
                            } else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§dArrow Saver USB")) {
                                SupportSticks.ArrowSaverStick((Player) event.getWhoClicked());
                            }else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§dDurability Saver USB")) {
                                SupportSticks.DurabilitySaverStick((Player) event.getWhoClicked());
                            }else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§dLife Recovery USB")) {
                                SupportSticks.LifeRecoveryStick((Player) event.getWhoClicked());
                            }else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§dHoming Arrows USB")) {
                                SupportSticks.HomingArrowsStick((Player) event.getWhoClicked());
                            }else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§dItem Cooldown USB")) {
                                SupportSticks.ItemCooldownStick((Player) event.getWhoClicked());
                            }else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§dPotion Duration USB")) {
                                SupportSticks.PotionDurationStick((Player) event.getWhoClicked());
                            }
                            invMenu.put(event.getWhoClicked().getName(),inventory);
                        }

                        else if (item.getItemMeta().getDisplayName().contains("§a")) {
                            Inventory inventory = invMenu.get(event.getWhoClicked().getName());
                            inventory.setItem(event.getSlot(),new ItemStack(Material.LIME_STAINED_GLASS_PANE));

                            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§aLightning Riptide USB")) {
                                UtilitySticks.TridentLightningStick((Player) event.getWhoClicked());
                            } else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§aLuck USB")) {
                                UtilitySticks.LuckStick((Player) event.getWhoClicked());
                            }else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§aAxe Armor Damage USB")) {
                                UtilitySticks.AxeDurabilityStick((Player) event.getWhoClicked());
                            }else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§aShield Break USB")) {
                                UtilitySticks.ShieldBreakStick((Player) event.getWhoClicked());
                            }

                            invMenu.put(event.getWhoClicked().getName(),inventory);

                        }
                    }

                } else if (clickedInventory == invMenu2.get(event.getWhoClicked().getName())) {
                    if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.MAGENTA_GLAZED_TERRACOTTA) {
                        openMenu((Player) event.getWhoClicked());
                    }

                    if (item.getItemMeta().getDisplayName().contains("§7")) {
                        Inventory inventory = invMenu2.get(event.getWhoClicked().getName());
                        inventory.setItem(event.getSlot(),new ItemStack(Material.GRAY_STAINED_GLASS_PANE));

                        if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§7Armor USB")) {
                            DefenseSticks.ArmorStick((Player) event.getWhoClicked());
                        } else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§7Armor Toughness USB")) {
                            DefenseSticks.ArmorToughnessStick((Player) event.getWhoClicked());
                        }else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§7Knockback Resistance USB")) {
                            DefenseSticks.KnockbackResistanceStick((Player) event.getWhoClicked());
                        }else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§7Damage Resistance USB")) {
                            DefenseSticks.DamageResistanceStick((Player) event.getWhoClicked());
                        }else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§7Thorns USB")) {
                            DefenseSticks.ThornsStick((Player) event.getWhoClicked());
                        }

                        invMenu2.put(event.getWhoClicked().getName(),inventory);

                    }


                }else {
                    if (event.getView().getTitle().equalsIgnoreCase("USB Menu")) {
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
                                    Inventory inv = invMenu.get(event.getWhoClicked().getName());
                                    inv.setItem(first,stack);
                                    invMenu.replace(event.getWhoClicked().getName(),inv);
                                }
                            }else if (currentItem.getItemMeta().getDisplayName().contains("§e")) {
                                int first = inventory.first(Material.YELLOW_STAINED_GLASS_PANE);
                                if (first != -1) {
                                    currentItem.setAmount(currentItem.getAmount()-1);
                                    ItemStack stack = new ItemStack(Material.PAPER);
                                    stack.setItemMeta(currentItem.getItemMeta());
                                    stack.setAmount(1);
                                    Inventory inv = invMenu.get(event.getWhoClicked().getName());
                                    inv.setItem(first,stack);
                                    invMenu.replace(event.getWhoClicked().getName(),inv);
                                }
                            }else if (currentItem.getItemMeta().getDisplayName().contains("§d")) {
                                int first = inventory.first(Material.PURPLE_STAINED_GLASS_PANE);
                                if (first != -1) {
                                    currentItem.setAmount(currentItem.getAmount()-1);
                                    ItemStack stack = new ItemStack(Material.PAPER);
                                    stack.setItemMeta(currentItem.getItemMeta());
                                    stack.setAmount(1);
                                    Inventory inv = invMenu.get(event.getWhoClicked().getName());
                                    inv.setItem(first,stack);
                                    invMenu.replace(event.getWhoClicked().getName(),inv);
                                }
                            }else if (currentItem.getItemMeta().getDisplayName().contains("§a")) {
                                int first = inventory.first(Material.LIME_STAINED_GLASS_PANE);
                                if (first != -1) {
                                    currentItem.setAmount(currentItem.getAmount()-1);
                                    ItemStack stack = new ItemStack(Material.PAPER);
                                    stack.setItemMeta(currentItem.getItemMeta());
                                    stack.setAmount(1);
                                    Inventory inv = invMenu.get(event.getWhoClicked().getName());
                                    inv.setItem(first,stack);
                                    invMenu.replace(event.getWhoClicked().getName(),inv);
                                }
                            }
                        }
                    } else if (event.getView().getTitle().equalsIgnoreCase("USB Menu 2")) {
                        if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.PAPER) {
                            Inventory inventory = event.getView().getTopInventory();
                            if (item.getItemMeta().getDisplayName().contains("§7")) {
                                int first = inventory.first(Material.GRAY_STAINED_GLASS_PANE);
                                if (first != -1) {
                                    item.setAmount(item.getAmount()-1);
                                    ItemStack stack = new ItemStack(Material.PAPER);
                                    stack.setItemMeta(item.getItemMeta());
                                    stack.setAmount(1);
                                    Inventory inv = invMenu2.get(event.getWhoClicked().getName());
                                    inv.setItem(first,stack);
                                    invMenu2.replace(event.getWhoClicked().getName(),inv);
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    public static void saveMenu1() {
        FileConfiguration config = UpgradeSticks.getPlugin().getConfig();
        for (String player : invMenu.keySet()) {
            config.set("menu1."+ player,invMenu.get(player).getContents());
        }
        UpgradeSticks.getPlugin().saveConfig();
    }

    public static void saveMenu2() {
        FileConfiguration config = UpgradeSticks.getPlugin().getConfig();
        for (String player : invMenu2.keySet()) {
            config.set("menu2."+ player,invMenu2.get(player).getContents());
        }
        UpgradeSticks.getPlugin().saveConfig();
    }

    public static void loadMenu1() {
        FileConfiguration config = UpgradeSticks.getPlugin().getConfig();
        ConfigurationSection playerData = config.getConfigurationSection("menu1.");
        if (playerData != null) {
            for (String playerName : playerData.getKeys(false)) {
                List<?> contents = playerData.getList(playerName);
                if (contents != null) {
                    List<ItemStack> menu = new ArrayList<>();
                    for (Object item : contents) {
                        if (item instanceof ItemStack) {
                            menu.add((ItemStack) item);
                        }
                    }

                    ItemStack[] stacks = menu.toArray(new ItemStack[0]);
                    Inventory inv = Bukkit.createInventory(null,36);
                    inv.setContents(stacks);
                    if (playerName != null) {
                        invMenu.put(playerName,inv);
                    }
                }
            }
        }
    }

    public static void loadMenu2() {
        FileConfiguration config = UpgradeSticks.getPlugin().getConfig();
        ConfigurationSection playerData = config.getConfigurationSection("menu2.");
        if (playerData != null) {
            for (String playerName : playerData.getKeys(false)) {
                List<?> contents = playerData.getList(playerName);
                if (contents != null) {
                    List<ItemStack> menu = new ArrayList<>();
                    for (Object item : contents) {
                        if (item instanceof ItemStack) {
                            menu.add((ItemStack) item);
                        }
                    }

                    ItemStack[] stacks = menu.toArray(new ItemStack[0]);
                    Inventory inv = Bukkit.createInventory(null,36);
                    inv.setContents(stacks);
                    if (playerName != null) {
                        invMenu2.put(playerName,inv);
                    }
                }
            }
        }
    }
}
