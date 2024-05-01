package de.nikey.upgradesticks.usbsticks;

import de.nikey.upgradesticks.api.StrenghtUSBs;
import de.nikey.upgradesticks.api.SupportUSBs;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;

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
    public void onEntityShootBow(EntityShootBowEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();

            double amount = SupportUSBs.getAmountArrowSaver(player);
            if (amount != 0 ) {
                amount = amount*12.5;
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
