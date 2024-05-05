package de.nikey.upgradesticks.usbsticks;

import de.nikey.upgradesticks.api.UtilityUSBs;
import io.papermc.paper.event.player.PlayerShieldDisableEvent;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.Random;

public class UtilityStick implements Listener {
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && event.getEntity() instanceof LivingEntity || event.getEntity() instanceof Player) {
            Player attacker = (Player) event.getDamager();
            if (attacker.isRiptiding()) {
                LivingEntity victim = (LivingEntity) event.getEntity();
                Random random = new Random();
                double amount = UtilityUSBs.getAmountTridentLightning(attacker);
                amount = amount*0.08;
                amount = 1/amount;
                int round = (int) Math.round(amount);
                if (round == 1) {
                    if (random.nextInt(2) == 1) {
                        LightningStrike lightningStrike = attacker.getWorld().strikeLightningEffect(victim.getLocation());
                        lightningStrike.setCausingPlayer(attacker);
                        victim.damage(6,attacker);
                    }
                }else {
                    if (random.nextInt(round) == 0) {
                        LightningStrike lightningStrike = attacker.getWorld().strikeLightningEffect(victim.getLocation());
                        lightningStrike.setCausingPlayer(attacker);
                        victim.damage(6,attacker);
                    }
                }
            }

            if (event.getEntity() instanceof LivingEntity) {
                if (attacker.getInventory().getItemInMainHand().getType() == Material.NETHERITE_AXE || attacker.getInventory().getItemInMainHand().getType() == Material.DIAMOND_AXE || attacker.getInventory().getItemInMainHand().getType() == Material.IRON_AXE) {
                    double amount = UtilityUSBs.getAmountAxeDurability(attacker);
                    amount = amount*2.5;
                    amount = amount/100;

                    amount = 1/amount;
                    int round = (int) Math.round(amount);
                    Random random = new Random();
                    if (random.nextInt(round) == 0) {
                        damageRandomArmorPiece((LivingEntity) event.getEntity());
                    }
                }
            }
        }

    }

    @EventHandler
    public void onPlayerToggleSprint(PlayerToggleSprintEvent event) {
        Player player = event.getPlayer();
        int amountLuck = UtilityUSBs.getAmountLuck(player);
        if (amountLuck != 0) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.LUCK,PotionEffect.INFINITE_DURATION,amountLuck));
        }else if (player.hasPotionEffect(PotionEffectType.LUCK) && player.getPotionEffect(PotionEffectType.LUCK).getDuration() == PotionEffect.INFINITE_DURATION){
            player.removePotionEffect(PotionEffectType.LUCK);
        }
    }

    private void damageRandomArmorPiece(LivingEntity player) {
        ItemStack[] armorContents = player.getEquipment().getArmorContents();

        if (armorContents.length == 0) {
            return;
        }

        Random random = new Random();
        ItemStack armorToRepair = armorContents[random.nextInt(armorContents.length)];

        // Repariere das ausgewählte Rüstungsteil um 1 Haltbarkeitspunkt
        short currentDurability = armorToRepair.getDurability();
        short maxDurability = armorToRepair.getType().getMaxDurability();
        if (currentDurability < maxDurability) {
            armorToRepair.setDurability((short) (currentDurability + 5));
        }
    }

    @EventHandler
    public void onPlayerShieldDisable(PlayerShieldDisableEvent event) {
        Player player = event.getPlayer();
        int amount = UtilityUSBs.getAmountShieldBreak(player);
        if (amount != 0) {
            int i = 20/amount;
            Random random = new Random();
            if (random.nextInt(i) == 0 && event.getDamager() instanceof LivingEntity) {
                LivingEntity damager = (LivingEntity) event.getDamager();
                damager.damage(4);
                Vector direction = damager.getLocation().getDirection().multiply(-1);
                direction.add(new Vector(0,0.2,0));
                damager.setVelocity(direction);
                event.setCooldown(20);
            }
        }
    }
}