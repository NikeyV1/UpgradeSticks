package de.nikey.upgradesticks.usbsticks;

import de.nikey.upgradesticks.api.StrenghtUSB;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class StrenghStick implements Listener {
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            int amount = StrenghtUSB.getAmount(player);
            amount = (int) (amount*7.5);
            amount = amount/100 +1;
            event.setDamage(event.getDamage() * amount);
        }
    }
}
