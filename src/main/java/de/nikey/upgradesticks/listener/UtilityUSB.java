package de.nikey.upgradesticks.listener;

import de.nikey.upgradesticks.ItemStacks.UtilitySticks;
import de.nikey.upgradesticks.UpgradeSticks;
import io.papermc.paper.event.player.PlayerShieldDisableEvent;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerRiptideEvent;

import java.util.Random;

public class UtilityUSB implements Listener {
    @EventHandler
    public void onPlayerRiptide(PlayerRiptideEvent event) {
        Player player = event.getPlayer();
        Random random = new Random();
        if (random.nextInt(680) == 189) {
            UtilitySticks.TridentLightningStick(player);
            player.playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
        }
    }

    @EventHandler
    public void onPlayerFish(PlayerFishEvent event) {
        Player player = event.getPlayer();
        Random random = new Random();
        if (random.nextInt() == 475 && event.getCaught() != null) {
            UtilitySticks.LuckStick(player);
            player.playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        if (damager instanceof Player) {
            Player player = (Player) damager;

            if (player.getInventory().getItemInMainHand().getType() == Material.MACE && event.getCause()){

            }

            if (player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_AXE || player.getInventory().getItemInMainHand().getType() == Material.NETHERITE_AXE|| player.getInventory().getItemInMainHand().getType() == Material.IRON_AXE) {
                Random random = new Random();
                if (random.nextInt(1000) == 734) {
                    UtilitySticks.AxeDurabilityStick(player);
                    player.playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
                }
            }
        }
    }

    @EventHandler
    public void onPlayerShieldDisable(PlayerShieldDisableEvent event) {
        Random random = new Random();
        if (random.nextInt(250) == 56) {
            UtilitySticks.ShieldBreakStick(event.getPlayer());
            event.getPlayer().playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
        }
    }


}
