package de.nikey.upgradesticks.listener;

import de.nikey.upgradesticks.ItemStacks.DefenseSticks;
import de.nikey.upgradesticks.ItemStacks.StrenghSticks;
import de.nikey.upgradesticks.UpgradeSticks;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class DefenseUSB implements Listener {
    @EventHandler
    public void onArmorDamage(PlayerItemDamageEvent event) {

        String name = event.getItem().getType().name().toLowerCase();
        if (name.contains("helmet") || name.contains("chestplate") || name.contains("leggings") || name.contains("boots")) {
            Random random = new Random();
            if (random.nextInt(1700) == 333) {
                event.getPlayer().playSound(Sound.sound(Key.key("entity.guardian.ambient"), Sound.Source.AMBIENT,1,1));
                DefenseSticks.ArmorStick(event.getPlayer());
            }

            if (random.nextInt(1600) == 875) {
                event.getPlayer().playSound(Sound.sound(Key.key("entity.guardian.ambient"), Sound.Source.AMBIENT,1,1));
                DefenseSticks.ArmorToughnessStick(event.getPlayer());
            }
        }
    }

    @EventHandler
    public void onEntityPotionEffect(EntityPotionEffectEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (player.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
                        Random random = new Random();
                        if (random.nextInt(1400) ==987) {
                            player.playSound(Sound.sound(Key.key("entity.guardian.ambient"), Sound.Source.AMBIENT,1,1));
                            DefenseSticks.DamageResistanceStick(player);
                        }
                    }else {
                        cancel();
                    }
                }
            }.runTaskTimer(UpgradeSticks.getPlugin(),0,20);
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (player.getEquipment().getHelmet() != null && player.getEquipment().getChestplate() != null && player.getEquipment().getLeggings() != null &&player.getEquipment().getBoots() != null ) {
                Random random = new Random();
                if (random.nextInt(1200) == 76) {
                    player.playSound(Sound.sound(Key.key("entity.guardian.ambient"), Sound.Source.AMBIENT,1,1));
                    DefenseSticks.KnockbackResistanceStick(player);
                }
            }
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();
        Player killer = entity.getKiller();
        if (entity.getKiller() != null) {
            if (entity instanceof Guardian) {
                Random random = new Random();
                int i = random.nextInt(140);
                if (i == 76) {
                    killer.playSound(Sound.sound(Key.key("entity.guardian.ambient"), Sound.Source.AMBIENT,1,1));
                    DefenseSticks.ThornsStick(killer);
                }
            }
        }
    }
}
