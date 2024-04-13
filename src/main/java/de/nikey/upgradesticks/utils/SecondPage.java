package de.nikey.upgradesticks.utils;

import de.nikey.upgradesticks.UpgradeSticks;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class SecondPage implements Listener {

    private static FileConfiguration playerDataConfig;
    public static Map<UUID, List<ItemStack>> playerMenus = new HashMap<>();
    private static Inventory inv = Bukkit.createInventory(null, 27, "USB Menu #2");


    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        savePlayerBackpack(player);
    }

    private void openMenu(Player player) {
        List<ItemStack> contents = getPlayerBackpackContents(player);
        if (contents != null) {
            inv.setContents(contents.toArray(new ItemStack[0]));
        }
        MenuInventory.USBMenu(inv);
        player.openInventory(inv);
    }

    private void savePlayerBackpack(Player player) {
        playerMenus.put(player.getUniqueId(), new ArrayList<>(List.of(inv.getContents())));
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
