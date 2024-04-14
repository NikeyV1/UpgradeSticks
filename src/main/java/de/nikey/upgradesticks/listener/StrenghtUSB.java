package de.nikey.upgradesticks.listener;

import de.nikey.upgradesticks.ItemStacks.StrenghSticks;
import de.nikey.upgradesticks.UpgradeSticks;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class StrenghtUSB implements Listener {
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();
        Player killer = entity.getKiller();
        if (entity.getKiller() != null) {
            if (entity instanceof Warden) {
                Random random = new Random();
                int i = random.nextInt(3);
                if (i == 2) {
                    killer.playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
                    StrenghSticks.CloseDamageStick(killer);
                }
            } else if (entity instanceof Zombie) {
                Random random = new Random();
                int i = random.nextInt(400);
                if (i == 220) {
                    killer.playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
                    StrenghSticks.CloseDamageStick(killer);
                }
            }else if (entity instanceof Skeleton) {
                Random random = new Random();
                int i = random.nextInt(350);
                if (i == 220) {
                    killer.playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
                    StrenghSticks.DistantDamageStick(killer);
                }
            }else if (entity instanceof Pillager) {
                Random random = new Random();
                int i = random.nextInt(120);
                if (i == 50) {
                    killer.playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
                    StrenghSticks.DistantDamageStick(killer);
                }
            }
        }
    }

    @EventHandler
    public void onPotionSplash(PotionSplashEvent event) {
        for (LivingEntity entity : event.getAffectedEntities()) {
            if (entity instanceof Player) {
                Player player = (Player) entity;
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (player.hasPotionEffect(PotionEffectType.SPEED)) {
                            Random random = new Random();
                            int i = random.nextInt(3000);
                            if (i == 500) {
                                player.playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
                                StrenghSticks.AttackSpeed(player);
                            }
                        }else {
                            cancel();
                        }
                    }
                }.runTaskTimer(UpgradeSticks.getPlugin(),0,20);
            }
        }
    }
}
