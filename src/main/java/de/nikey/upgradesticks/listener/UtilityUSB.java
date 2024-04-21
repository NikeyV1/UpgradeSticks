package de.nikey.upgradesticks.listener;

import de.nikey.upgradesticks.ItemStacks.UtilitySticks;
import de.nikey.upgradesticks.UpgradeSticks;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRiptideEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Random;

public class UtilityUSB implements Listener {
    @EventHandler
    public void onPlayerRiptide(PlayerRiptideEvent event) {
        Player player = event.getPlayer();
        Random random = new Random();
        if (random.nextInt(3500) == 189) {
            UtilitySticks.TridentLightningStick(player);
        }
    }

    @EventHandler
    public void onPlayerFish(PlayerFishEvent event) {
        Player player = event.getPlayer();
        Random random = new Random();
        if (random.nextInt() == 475 && event.getCaught() != null) {
            UtilitySticks.LuckStick(player);
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        if (damager instanceof Player) {
            Player player = (Player) damager;
            if (player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_AXE || player.getInventory().getItemInMainHand().getType() == Material.NETHERITE_AXE|| player.getInventory().getItemInMainHand().getType() == Material.IRON_AXE) {
                Random random = new Random();
                if (random.nextInt(1000) == 734) {
                    UtilitySticks.AxeDurabilityStick(player);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.isBlocking()) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (player.isBlocking()) {
                        Random random = new Random();
                        if (random.nextInt(30) == 17) {
                            UtilitySticks.ShieldBreakStick(player);
                        }
                    }else {
                        cancel();
                    }
                }
            }.runTaskTimer(UpgradeSticks.getPlugin(),0,20);
        }
    }
}
