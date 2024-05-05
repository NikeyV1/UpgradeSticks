package de.nikey.upgradesticks.listener;

import com.destroystokyo.paper.event.player.PlayerLaunchProjectileEvent;
import com.destroystokyo.paper.event.player.PlayerReadyArrowEvent;
import de.nikey.upgradesticks.ItemStacks.MobilitySticks;
import de.nikey.upgradesticks.ItemStacks.SupportSticks;
import io.papermc.paper.event.player.PlayerItemCooldownEvent;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerItemDamageEvent;

import java.util.Random;

public class SupportUSB implements Listener {
    @EventHandler
    public void onEntityRegainHealth(EntityRegainHealthEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            Random random = new Random();
            if (random.nextInt(500) == 100) {
                player.playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
                SupportSticks.HeartRegenerationStick(player);
            }
        }
    }

    @EventHandler
    public void onPlayerLaunchProjectile(EntityShootBowEvent event) {
        if (event.getProjectile() instanceof Arrow && event.getEntity() instanceof Player) {
            Random random = new Random();
            if (random.nextInt(500) == 100) {
                event.getEntity().playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
                SupportSticks.ArrowSaverStick((Player) event.getEntity());
            }

            if (random.nextInt(700) == 163) {
                event.getEntity().playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
                SupportSticks.HomingArrowsStick((Player) event.getEntity());
            }
        }
    }

    @EventHandler
    public void onPlayerItemDamage(PlayerItemDamageEvent event) {
        Random random = new Random();
        if (random.nextInt(2000) == 100) {
            event.getPlayer().playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
            SupportSticks.DurabilitySaverStick(event.getPlayer());
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntity().getKiller() != null) {
            if (event.getEntity().getKiller().getHealth() <= 15) {
                Random random = new Random();
                if (random.nextInt(500) == 100) {
                    event.getEntity().getKiller().playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
                    SupportSticks.LifeRecoveryStick(event.getEntity().getKiller());
                }
            }
        }
    }

    @EventHandler
    public void onPlayerItemCooldown(PlayerItemCooldownEvent event) {
        Random random = new Random();
        if (random.nextInt(200) == 100) {
            event.getPlayer().playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
            SupportSticks.ItemCooldownStick( event.getPlayer());
        }
    }

    @EventHandler
    public void onEntityPotionEffect(EntityPotionEffectEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (event.getCause() == EntityPotionEffectEvent.Cause.POTION_DRINK ||event.getCause() == EntityPotionEffectEvent.Cause.POTION_SPLASH) {
                Random random = new Random();
                if (random.nextInt(120) == 24) {
                    player.playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
                    SupportSticks.PotionDurationStick(player);
                }
            }
        }
    }
}
