package de.nikey.upgradesticks.usbsticks;

import de.nikey.upgradesticks.UpgradeSticks;
import de.nikey.upgradesticks.api.DefenseUSBs;
import de.nikey.upgradesticks.api.StrenghtUSBs;
import de.nikey.upgradesticks.api.SupportUSBs;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import org.bukkit.Particle;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
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
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (event.getEntity() instanceof Arrow && event.getEntity().getShooter() instanceof Player) {
            Player player = (Player) event.getEntity().getShooter();
            Arrow arrow = (Arrow) event.getEntity();
            Random random = new Random();
            double amount = SupportUSBs.getAmountHomingArrows(player);
            if (amount != 0 ) {
                amount = amount*10;
                amount = amount/100;

                amount = 1/amount;

                int round = (int) Math.round(amount);

                if (random.nextInt(round) == 0) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            aimArrow(arrow);
                        }
                    }.runTaskLater(UpgradeSticks.getPlugin(), 3);
                }
            }
        }
    }

    private void aimArrow(Arrow arrow) {
        if (!arrow.isOnGround() && !arrow.isDead()) {
            for (Entity entity : arrow.getNearbyEntities(6, 6, 6)) {
                if (entity instanceof LivingEntity && !(entity.equals(arrow.getShooter()))) {
                    LivingEntity target = (LivingEntity) entity;
                    if (target.getLocation().distance(arrow.getLocation()) <= 10) { // Adjust the range as needed
                        Vector direction = target.getEyeLocation().toVector().subtract(arrow.getLocation().toVector()).normalize();
                        arrow.setVelocity(direction.multiply(1.3));
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
