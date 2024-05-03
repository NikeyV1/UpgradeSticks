package de.nikey.upgradesticks.usbsticks;

import de.nikey.upgradesticks.api.DefenseUSBs;
import de.nikey.upgradesticks.api.SupportUSBs;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;

import java.util.Random;

public class DefenseStick implements Listener {
    @EventHandler
    public void onPlayerToggleSprint(PlayerToggleSprintEvent event) {
            Player player = event.getPlayer();
            double amountArmor = DefenseUSBs.getAmountArmor(player);
            amountArmor = amountArmor*0.75;

            player.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(amountArmor);

            double amountArmorToughness = DefenseUSBs.getAmountArmorToughness(player);

            player.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).setBaseValue(amountArmorToughness);

            double amountKnockbackResistance = DefenseUSBs.getAmountKnockbackResistance(player);
            amountKnockbackResistance = amountKnockbackResistance *0.3;


            player.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(amountKnockbackResistance);

    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            Random random = new Random();
            double amount = DefenseUSBs.getAmountDamageResistance(player);
            if (amount != 0 ) {
                amount = amount*2.5;
                amount = amount/100;

                amount = 1/amount;

                int round = (int) Math.round(amount);

                if (random.nextInt(round) == 1) {
                    player.setHealth(player.getHealth()+event.getFinalDamage());
                }
            }
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && event.getDamager() instanceof LivingEntity) {
            Player player = (Player) event.getEntity();
            Random random = new Random();

            double amount = DefenseUSBs.getAmountThorns(player);
            LivingEntity damager = (LivingEntity) event.getDamager();

            if (amount != 0 ) {
                amount = amount*5;
                amount = amount/100;

                amount = 1/amount;

                int round = (int) Math.round(amount);

                if (random.nextInt(round) == 0) {
                    damager.damage(event.getDamage(),player);
                    damager.playSound(Sound.sound(Key.key("enchant.thorns.hit"), Sound.Source.PLAYER,0.5F,0.5F));
                }
            }
        }
    }
}
