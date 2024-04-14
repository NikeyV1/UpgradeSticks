package de.nikey.upgradesticks.usbsticks;

import de.nikey.upgradesticks.api.DefenseUSBs;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;

import java.util.Random;

public class DefenseStick implements Listener {
    @EventHandler
    public void onPlayerToggleSneak(PlayerToggleSprintEvent event) {
        Player player = event.getPlayer();
        double amountArmor = DefenseUSBs.getAmountArmor(player);
        amountArmor = amountArmor*0.3;

        player.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(amountArmor);

        double amountArmorToughness = DefenseUSBs.getAmountArmorToughness(player);
        amountArmorToughness = amountArmorToughness*0.3;

        player.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).setBaseValue(amountArmorToughness);

        double amountKnockbackResistance = DefenseUSBs.getAmountKnockbackResistance(player);
        amountKnockbackResistance = amountKnockbackResistance *0.3;


        player.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(amountKnockbackResistance);

    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            double a = DefenseUSBs.getAmountDamageResistance(player);
            Random random = new Random();
            if (a == 1) {
                int i = random.nextInt(40);
                if (i == 10) {
                    player.setHealth(player.getHealth()+event.getFinalDamage());
                }
            }else if (a == 2) {
                int i = random.nextInt(20);
                if (i == 10) {
                    player.setHealth(player.getHealth()+event.getFinalDamage());
                }
            }else if (a == 3) {
                int i = random.nextInt(13);
                if (i == 10) {
                    player.setHealth(player.getHealth()+event.getFinalDamage());
                }
            }else if (a == 4) {
                int i = random.nextInt(10);
                if (i == 7) {
                    player.setHealth(player.getHealth()+event.getFinalDamage());
                }
            }else if (a == 5) {
                int i = random.nextInt(8);
                if (i == 5) {
                    player.setHealth(player.getHealth()+event.getFinalDamage());
                }
            }else if (a == 6) {
                int i = random.nextInt(6);
                if (i == 4) {
                    player.setHealth(player.getHealth()+event.getFinalDamage());
                }
            }

            double amountThorns = DefenseUSBs.getAmountThorns(player);
            LivingEntity damager = (LivingEntity) event.getDamager();

            if (amountThorns == 1) {
                int i = random.nextInt(20);
                if (i == 10) {
                    damager.damage(event.getDamage()/2);
                }
            }else if (amountThorns == 2) {
                int i = random.nextInt(10);
                if (i == 2) {
                    damager.damage(event.getDamage()/2);
                }
            }else if (amountThorns == 3) {
                int i = random.nextInt(7);
                if (i == 3) {
                    damager.damage(event.getDamage()/2);
                }
            }else if (amountThorns == 4) {
                int i = random.nextInt(5);
                if (i == 2) {
                    damager.damage(event.getDamage()/2);
                }
            }else if (amountThorns == 5) {
                int i = random.nextInt(4);
                if (i == 3) {
                    damager.damage(event.getDamage()/2);
                }
            }else if (amountThorns == 6) {
                int i = random.nextInt(3);
                if (i == 2) {
                    damager.damage(event.getDamage()/2);
                }
            }
        }
    }
}
