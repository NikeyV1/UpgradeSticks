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
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("ALL")
public class Menu implements Listener {

    public static HashMap<Player, ItemStack[]> menuContents = new HashMap<>();
    public static HashMap<Player, Inventory> invMenu = new HashMap<>();
    public static HashMap<Player, ItemStack[]> menuContents2 = new HashMap<>();
    public static HashMap<Player, Inventory> invMenu2 = new HashMap<>();

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.CHEST) {
            openMenu(event.getPlayer());
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        Inventory inv = Bukkit.createInventory(null,36,"USB Menu");
        if (menuContents.get(player) != null) {
            inv.setContents(menuContents.get(player));
        }
        MenuInventory.USBMenu(inv);
        invMenu.put(player,inv);

        Inventory inventory = Bukkit.createInventory(null,36,"USB Menu 2");
        if (menuContents2.get(player) != null) {
            inventory.setContents(menuContents2.get(player));
        }
        MenuInventory.secondPage(inventory);
        invMenu2.put(player,inventory);

    }

    public static void openMenu(Player player) {
        Inventory inv = Bukkit.createInventory(null,36,"USB Menu");
        if (menuContents.get(player) != null) {
            inv.setContents(menuContents.get(player));
        }
        MenuInventory.USBMenu(inv);
        invMenu.put(player,inv);
        player.openInventory(inv);
    }

    public static void openSecondPage(Player player) {
        Inventory inv = Bukkit.createInventory(null,36,"USB Menu 2");
        if (menuContents2.get(player) != null) {
            inv.setContents(menuContents2.get(player));
        }
        MenuInventory.secondPage(inv);
        invMenu2.put(player,inv);
        player.openInventory(inv);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        Inventory inv = Bukkit.createInventory(null,36,"USB Menu");
        if (menuContents.get(player) != null) {
            inv.setContents(menuContents.get(player));
        }
        MenuInventory.USBMenu(inv);
        invMenu.put(player,inv);

        Inventory inventory = Bukkit.createInventory(null,36,"USB Menu 2");
        if (menuContents2.get(player) != null) {
            inventory.setContents(menuContents2.get(player));
        }
        MenuInventory.secondPage(inventory);

        invMenu2.put(player,inventory);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        ItemStack item = event.getCurrentItem();
        Inventory clickedInventory = event.getClickedInventory();
        if (clickedInventory != null) {
            if (event.getView().getTitle().equalsIgnoreCase("USB Menu") || event.getView().getTitle().equalsIgnoreCase("USB Menu 2")) {
                event.setCancelled(true);
                //Menü
                if (clickedInventory == invMenu.get(event.getWhoClicked())) {
                    if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.MAGENTA_GLAZED_TERRACOTTA) {
                        openSecondPage((Player) event.getWhoClicked());
                    }

                    if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.PAPER) {
                        if (item.getItemMeta().getDisplayName().contains("§c")) {
                            Inventory inventory = invMenu.get(event.getWhoClicked());
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

                            invMenu.put((Player) event.getWhoClicked(),inventory);
                            menuContents.put((Player) event.getWhoClicked(), inventory.getContents());

                        }else if (item.getItemMeta().getDisplayName().contains("§e")) {
                            Inventory inventory = invMenu.get(event.getWhoClicked());
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

                            invMenu.put((Player) event.getWhoClicked(),inventory);
                            menuContents.put((Player) event.getWhoClicked(), inventory.getContents());

                        }else if (item.getItemMeta().getDisplayName().contains("§d")) {
                            Inventory inventory = invMenu.get(event.getWhoClicked());
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
                            invMenu.put((Player) event.getWhoClicked(),inventory);
                            menuContents.put((Player) event.getWhoClicked(), inventory.getContents());
                        }

                        else if (item.getItemMeta().getDisplayName().contains("§a")) {
                            Inventory inventory = invMenu.get(event.getWhoClicked());
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

                            invMenu.put((Player) event.getWhoClicked(),inventory);
                            menuContents.put((Player) event.getWhoClicked(), inventory.getContents());

                        }
                    }

                } else if (clickedInventory == invMenu2.get(event.getWhoClicked())) {
                    if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.MAGENTA_GLAZED_TERRACOTTA) {
                        openMenu((Player) event.getWhoClicked());
                    }

                    if (item.getItemMeta().getDisplayName().contains("§7")) {
                        Inventory inventory = invMenu2.get(event.getWhoClicked());
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

                        invMenu2.put((Player) event.getWhoClicked(),inventory);
                        menuContents2.put((Player) event.getWhoClicked(), inventory.getContents());

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
                                    Inventory inv = invMenu.get(event.getWhoClicked());
                                    inv.setItem(first,stack);
                                    invMenu.replace((Player) event.getWhoClicked(),inv);
                                    menuContents.put((Player) event.getWhoClicked(), inventory.getContents());
                                }
                            }else if (currentItem.getItemMeta().getDisplayName().contains("§e")) {
                                int first = inventory.first(Material.YELLOW_STAINED_GLASS_PANE);
                                if (first != -1) {
                                    currentItem.setAmount(currentItem.getAmount()-1);
                                    ItemStack stack = new ItemStack(Material.PAPER);
                                    stack.setItemMeta(currentItem.getItemMeta());
                                    stack.setAmount(1);
                                    Inventory inv = invMenu.get(event.getWhoClicked());
                                    inv.setItem(first,stack);
                                    invMenu.replace((Player) event.getWhoClicked(),inv);
                                    menuContents.put((Player) event.getWhoClicked(), inventory.getContents());
                                }
                            }else if (currentItem.getItemMeta().getDisplayName().contains("§d")) {
                                int first = inventory.first(Material.PURPLE_STAINED_GLASS_PANE);
                                if (first != -1) {
                                    currentItem.setAmount(currentItem.getAmount()-1);
                                    ItemStack stack = new ItemStack(Material.PAPER);
                                    stack.setItemMeta(currentItem.getItemMeta());
                                    stack.setAmount(1);
                                    Inventory inv = invMenu.get(event.getWhoClicked());
                                    inv.setItem(first,stack);
                                    invMenu.replace((Player) event.getWhoClicked(),inv);
                                    menuContents.put((Player) event.getWhoClicked(), inventory.getContents());
                                }
                            }else if (currentItem.getItemMeta().getDisplayName().contains("§a")) {
                                int first = inventory.first(Material.LIME_STAINED_GLASS_PANE);
                                if (first != -1) {
                                    currentItem.setAmount(currentItem.getAmount()-1);
                                    ItemStack stack = new ItemStack(Material.PAPER);
                                    stack.setItemMeta(currentItem.getItemMeta());
                                    stack.setAmount(1);
                                    Inventory inv = invMenu.get(event.getWhoClicked());
                                    inv.setItem(first,stack);
                                    invMenu.replace((Player) event.getWhoClicked(),inv);
                                    menuContents.put((Player) event.getWhoClicked(), inventory.getContents());
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
                                    Inventory inv = invMenu2.get(event.getWhoClicked());
                                    inv.setItem(first,stack);
                                    invMenu2.replace((Player) event.getWhoClicked(),inv);
                                    menuContents2.put((Player) event.getWhoClicked(), inventory.getContents());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase("USB Menu 2")) {
            Inventory inventory = event.getInventory();
            invMenu2.put((Player) event.getPlayer(),inventory);
        } else if (event.getView().getTitle().equalsIgnoreCase("USB Menu")) {
            Inventory inventory = event.getInventory();
            invMenu.put((Player) event.getPlayer(),inventory);
        }
    }


    public static void saveMenu1() {
        FileConfiguration config = UpgradeSticks.getPlugin().getConfig();
        for (Player player : menuContents.keySet()) {
            config.set("menu1."+ player.getName(),menuContents.get(player));
        }
        UpgradeSticks.getPlugin().saveConfig();
    }

    public static void saveMenu2() {
        FileConfiguration config = UpgradeSticks.getPlugin().getConfig();
        for (Player player : menuContents2.keySet()) {
            config.set("menu2."+ player.getName(),menuContents2.get(player));
        }
        UpgradeSticks.getPlugin().saveConfig();
    }

    public static void loadMenu1() {
        FileConfiguration config = UpgradeSticks.getPlugin().getConfig();
        ConfigurationSection playerData = config.getConfigurationSection("menu1.");
        if (playerData != null) {
            for (String playerName : playerData.getKeys(false)) {
                Player player = Bukkit.getPlayer(playerName);
                List<?> contents = playerData.getList(playerName);
                if (contents != null) {
                    List<ItemStack> menu = new ArrayList<>();
                    for (Object item : contents) {
                        if (item instanceof ItemStack) {
                            menu.add((ItemStack) item);
                        }
                    }

                    ItemStack[] stacks = menu.toArray(new ItemStack[0]);
                    menuContents.put(player,stacks);
                }
            }
        }
    }

    public static void loadMenu2() {
        FileConfiguration config = UpgradeSticks.getPlugin().getConfig();
        ConfigurationSection playerData = config.getConfigurationSection("menu2.");
        if (playerData != null) {
            for (String playerName : playerData.getKeys(false)) {
                Player player = Bukkit.getPlayer(playerName);
                List<?> contents = playerData.getList(playerName);
                if (contents != null) {
                    List<ItemStack> menu = new ArrayList<>();
                    for (Object item : contents) {
                        if (item instanceof ItemStack) {
                            menu.add((ItemStack) item);
                        }
                    }

                    ItemStack[] stacks = menu.toArray(new ItemStack[0]);
                    menuContents2.put(player,stacks);
                }
            }
        }
    }
}
