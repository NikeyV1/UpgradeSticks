package de.nikey.upgradesticks.listener;

import com.destroystokyo.paper.event.player.PlayerPickupExperienceEvent;
import de.nikey.upgradesticks.ItemStacks.MobilitySticks;
import de.nikey.upgradesticks.ItemStacks.StrenghSticks;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class MobilityUSB implements Listener {

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();
        Player killer = entity.getKiller();
        if (entity.getKiller() != null) {
            if (entity instanceof Dolphin) {
                Random random = new Random();
                int i = random.nextInt(150);
                if (i == 70) {
                    killer.playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
                    MobilitySticks.SwimSpeedStick(killer);
                }
            }else if (entity instanceof PufferFish) {
                Random random = new Random();
                int i = random.nextInt(150);
                if (i == 70) {
                    killer.playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
                    MobilitySticks.SwimSpeedStick(killer);
                }
            }else if (entity instanceof Turtle) {
                Random random = new Random();
                int i = random.nextInt(150);
                if (i == 70) {
                    killer.playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
                    MobilitySticks.SwimSpeedStick(killer);
                }
            }else if (entity instanceof Cat) {
                Random random = new Random();
                int i = random.nextInt(175);
                if (i == 70) {
                    killer.playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
                    MobilitySticks.WalkSpeedStick(killer);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location from = event.getFrom();
        Location to = event.getTo();
        if (from.getX() != to.getX()) {
            Random random = new Random();
            int i = random.nextInt(12000);
            if (i == 3400) {
                player.playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
                MobilitySticks.WalkSpeedStick(player);
            }
        } else if (from.getZ() != to.getZ()) {
            Random random = new Random();
            int i = random.nextInt(12000);
            if (i == 3005) {
                player.playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
                MobilitySticks.WalkSpeedStick(player);
            }
        }
    }

    @EventHandler
    public void onPlayerItemConsume(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (item.getType().isEdible()) {
            Random random = new Random();
            if (random.nextInt(200) == 100) {
                player.playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
                MobilitySticks.HungerMoveStick(player);
            }
        }
    }

    @EventHandler
    public void onPlayerPickupExperience(PlayerPickupExperienceEvent event) {
        Player player = event.getPlayer();
        Random random = new Random();
        if (random.nextInt(350) == 100) {
            player.playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
            MobilitySticks.ExpMoveStick(player);
        }
    }
}
