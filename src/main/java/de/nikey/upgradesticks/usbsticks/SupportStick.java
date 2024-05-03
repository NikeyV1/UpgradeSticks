package de.nikey.upgradesticks.usbsticks;

import de.nikey.upgradesticks.UpgradeSticks;
import de.nikey.upgradesticks.api.DefenseUSBs;
import de.nikey.upgradesticks.api.StrenghtUSBs;
import de.nikey.upgradesticks.api.SupportUSBs;
import io.papermc.paper.event.player.PlayerItemCooldownEvent;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import org.bukkit.Particle;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Random;

public class SupportStick implements Listener {
    @EventHandler
    public void onEntityRegainHealth(EntityRegainHealthEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();

            double amount = SupportUSBs.getAmountHeartRegeneration(player);
            amount = amount*20;
            amount = amount/100 +1;

            event.setAmount(event.getAmount() * amount);
        }
    }

    @EventHandler
    public void onPlayerItemCooldown(PlayerItemCooldownEvent event) {
        Player player = event.getPlayer();
        double amount = SupportUSBs.getAmountItemCooldown(player);

        if (amount != 0 ) {
            amount = amount * 15;
            amount = amount / 100;

            if (amount > 1) {
                event.setCooldown(2);
            } else {
                amount = 1 / amount -1;
                amount = amount*event.getCooldown();
                int round = (int) Math.round(amount);
                event.setCooldown(round);
            }
        }
    }

    @EventHandler
    public void onEntityPotionEffect(EntityPotionEffectEvent event) {
        if (event.getEntity() instanceof Player && event.getCause() != EntityPotionEffectEvent.Cause.PLUGIN && event.getCause() != EntityPotionEffectEvent.Cause.EXPIRATION) {
            Player player = (Player) event.getEntity();
            double amount = SupportUSBs.getAmountPotionDuration(player);
            if (amount != 0) {
                amount = amount*15;
                amount = amount/100 +1;
                PotionEffect newEffect = event.getNewEffect();

                PotionEffect potionEffect = new PotionEffect(newEffect.getType(), (int) (newEffect.getDuration()*amount),newEffect.getAmplifier(),newEffect.isAmbient(),newEffect.hasParticles());

                event.setOverride(false);
                player.addPotionEffect(potionEffect);
            }

        }
    }

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (event.getEntity() instanceof Arrow && event.getEntity().getShooter() instanceof Player) {
            Player player = (Player) event.getEntity().getShooter();
            Arrow arrow = (Arrow) event.getEntity();
            Random random = new Random();
            double amount = SupportUSBs.getAmountHomingArrows(player);
            if (amount != 0 ) {
                amount = amount*7.5;
                amount = amount/100;

                amount = 1/amount;

                int round = (int) Math.round(amount);

                if (random.nextInt(round) == 0) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            aimArrow(arrow);
                        }
                    }.runTaskTimer(UpgradeSticks.getPlugin(), 0,5);
                }
            }
        }
    }

    private void aimArrow(Arrow arrow) {
        if (!arrow.isOnGround() && !arrow.isDead()) {
            for (Entity entity : arrow.getNearbyEntities(4, 4, 4)) {
                if (entity instanceof LivingEntity && !(entity.equals(arrow.getShooter()))) {
                    LivingEntity target = (LivingEntity) entity;
                    if (target.getLocation().distance(arrow.getLocation()) <= 6) {
                        Vector direction = target.getEyeLocation().toVector().subtract(arrow.getLocation().toVector()).normalize();
                        arrow.setVelocity(direction.multiply(1.2));
                        arrow.getWorld().spawnParticle(Particle.END_ROD,arrow.getLocation(),4);
                        break;
                    }
                }
            }
        }
    }

    @EventHandler
    public void onEntityShootBow(EntityShootBowEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();

            double amount = SupportUSBs.getAmountArrowSaver(player);
            if (amount != 0 ) {
                amount = amount*7.5;
                amount = amount/100;

                amount = 1/amount;

                int round = (int) Math.round(amount);
                Random random = new Random();

                if (random.nextInt(round) == 0) {
                    event.setConsumeItem(false);
                    player.updateInventory();
                }
            }
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntity().getKiller() != null) {
            Player player = event.getEntity().getKiller();
            double amount = SupportUSBs.getAmountLifeRecovery(player);
            if (amount != 0) {
                amount =  amount*4;
                amount = amount/100;
                amount = amount*player.getMaxHealth();
                player.setHealth(player.getHealth() + amount);
            }
        }
    }

    @EventHandler
    public void onPlayerItemDamage(PlayerItemDamageEvent event) {
        Player player = event.getPlayer();

        double amount = SupportUSBs.getAmountDurabilitySaver(player);
        if (amount != 0 ) {
            amount = amount*10;
            amount = amount/100;

            amount = 1/amount;

            int round = (int) Math.round(amount);
            Random random = new Random();

            if (random.nextInt(round) == 0) {
                event.setCancelled(true);
            }
        }
    }
}
