package de.nikey.upgradesticks.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static org.bukkit.Bukkit.getServer;

public class USBMenü implements Listener {
    public static Map<Player, Inventory> playerMenus = new HashMap<>();

    public static File dataFile;

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory clickedInventory = event.getClickedInventory();

        if (clickedInventory != null && clickedInventory.equals(playerMenus.get(player))) {
            event.setCancelled(true);

            ItemStack clickedItem = event.getCurrentItem();
            if (clickedItem != null && clickedItem.getType() == Material.PAPER) {
                player.getInventory().addItem(clickedItem);
                clickedInventory.removeItem(clickedItem);
            }
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (event.getBlockPlaced().getType() == Material.CHEST) {
            event.setCancelled(true);
            openMenu(player);
        }
    }

    public void openMenu(Player player) {
        Inventory menu = Bukkit.createInventory(null, 9, "USB Menu");
        player.openInventory(menu);
        playerMenus.put(player, menu);
    }

    public static void loadDataFile() {
        dataFile = new File("plugins/UpgradeSticks", "inventories.dat");

        if (!dataFile.exists()) {
            return;
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(dataFile))) {
            playerMenus = (Map<Player, Inventory>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveDataFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(dataFile))) {
            outputStream.writeObject(playerMenus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
