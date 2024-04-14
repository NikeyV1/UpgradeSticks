package de.nikey.upgradesticks.usbsticks;

import de.nikey.upgradesticks.api.StrenghtUSBs;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;

public class StrengthStick implements Listener {
    @EventHandler
    public void onPlayerToggleSprint(PlayerToggleSprintEvent event) {
        Player player = event.getPlayer();
        double amount = StrenghtUSBs.getAmountAttackSpeed(player);
        amount =  amount*5;
        amount = amount/100;
        amount=amount*1.5;

        player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(4+amount);
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            if (player.getLocation().distance(event.getEntity().getLocation()) < 5) {
                double amount = StrenghtUSBs.getAmountDamageClose(player);

                amount =  amount*7.5;
                amount = amount/100 +1;
                event.setDamage(event.getDamage() * amount);
            }else {
                double amount = StrenghtUSBs.getAmountDamageFar(player);

                amount =  amount*7.5;
                amount = amount/100 +1;
                event.setDamage(event.getDamage() * amount);
            }
        } else if (event.getDamager() instanceof Projectile) {
            Projectile proj = (Projectile) event.getDamager();
            if (proj.getShooter() instanceof Player) {
                Player shooter = (Player) proj.getShooter();
                if (shooter.getLocation().distance(event.getEntity().getLocation()) > 5) {
                    double amount = StrenghtUSBs.getAmountDamageFar(shooter);

                    amount =  amount*7.5;
                    amount = amount/100 +1;
                    event.setDamage(event.getDamage() * amount);
                }
            }
        }
    }
}
