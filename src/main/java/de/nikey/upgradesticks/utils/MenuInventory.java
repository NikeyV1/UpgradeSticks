package de.nikey.upgradesticks.utils;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuInventory {
    public static void USBMenu(Inventory inv){
        ItemStack YellowGlass = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
        ItemMeta yellowMeta = YellowGlass.getItemMeta();
        yellowMeta.setDisplayName("§c");
        YellowGlass.setItemMeta(yellowMeta);

        ItemStack GreenGlass = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        ItemMeta greenMeta = GreenGlass.getItemMeta();
        greenMeta.setDisplayName("§c");
        GreenGlass.setItemMeta(greenMeta);

        ItemStack PurpleGlass = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        ItemMeta purpleMeta = PurpleGlass.getItemMeta();
        purpleMeta.setDisplayName("§c");
        PurpleGlass.setItemMeta(purpleMeta);

        ItemStack RedGlass = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta redMeta = RedGlass.getItemMeta();
        redMeta.setDisplayName("§c");
        RedGlass.setItemMeta(redMeta);

        ItemStack a = new ItemStack(Material.MAGENTA_GLAZED_TERRACOTTA);
        ItemMeta m = a.getItemMeta();
        m.setDisplayName("Second Page");
        a.setItemMeta(m);
        //Invsetup

        for (int i = 0; i < inv.getSize(); i++) {
            if (inv.getItem(i) == null) {
                // Setze das Item nur, wenn der Slot leer ist
                switch(i) {
                    case 0:
                    case 9:
                    case 18:
                    case 1:
                    case 10:
                    case 19:
                    case 27:
                    case 28:
                        inv.setItem(i, YellowGlass);
                        break;
                    case 2:
                    case 3:
                    case 11:
                    case 12:
                    case 20:
                    case 21:
                    case 29:
                    case 30:
                        inv.setItem(i, GreenGlass);
                        break;
                    case 4:
                    case 5:
                    case 13:
                    case 14:
                    case 22:
                    case 23:
                    case 31:
                    case 32:
                        inv.setItem(i, RedGlass);
                        break;
                    case 6:
                    case 7:
                    case 15:
                    case 16:
                    case 24:
                    case 25:
                    case 33:
                    case 34:
                        inv.setItem(i, PurpleGlass);
                        break;
                    case 8:
                    case 17:
                    case 26:
                    case 35:
                        inv.setItem(i, a);
                        break;
                }
            }
        }

    }
    public static void secondPage(Inventory inv){
        ItemStack BlueGlass = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta blueMeta = BlueGlass.getItemMeta();
        blueMeta.setDisplayName("§c");
        BlueGlass.setItemMeta(blueMeta);

        ItemStack Brownlass = new ItemStack(Material.BROWN_STAINED_GLASS_PANE);
        ItemMeta brownMeta = Brownlass.getItemMeta();
        brownMeta.setDisplayName("§c");
        Brownlass.setItemMeta(brownMeta);

        ItemStack GrayGlass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta grayMeta = GrayGlass.getItemMeta();
        grayMeta.setDisplayName("§c");
        GrayGlass.setItemMeta(grayMeta);

        ItemStack CyanGlass = new ItemStack(Material.CYAN_STAINED_GLASS_PANE);
        ItemMeta cyanMeta = CyanGlass.getItemMeta();
        cyanMeta.setDisplayName("§c");
        CyanGlass.setItemMeta(cyanMeta);

        ItemStack a = new ItemStack(Material.MAGENTA_GLAZED_TERRACOTTA);
        ItemMeta m = a.getItemMeta();
        m.setDisplayName("First Page");
        a.setItemMeta(m);

        for (int i = 0; i < inv.getSize(); i++) {
            if (inv.getItem(i) == null) {
                // Setze das Item nur, wenn der Slot leer ist
                switch(i) {
                    case 0:
                    case 9:
                    case 18:
                    case 1:
                    case 10:
                    case 19:
                    case 27:
                    case 28:
                        inv.setItem(i, BlueGlass);
                        break;
                    case 2:
                    case 3:
                    case 11:
                    case 12:
                    case 20:
                    case 21:
                    case 29:
                    case 30:
                        inv.setItem(i, Brownlass);
                        break;
                    case 4:
                    case 5:
                    case 13:
                    case 14:
                    case 22:
                    case 23:
                    case 31:
                    case 32:
                        inv.setItem(i, GrayGlass);
                        break;
                    case 6:
                    case 7:
                    case 15:
                    case 16:
                    case 24:
                    case 25:
                    case 33:
                    case 34:
                        inv.setItem(i, CyanGlass);
                        break;
                    case 8:
                    case 17:
                    case 26:
                    case 35:
                        inv.setItem(i, a);
                        break;
                }
            }
        }
    }
}
