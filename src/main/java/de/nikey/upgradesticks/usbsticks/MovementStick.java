package de.nikey.upgradesticks.usbsticks;

import de.nikey.upgradesticks.api.MobilityUSBs;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;

import java.util.Random;

public class MovementStick implements Listener {
    @EventHandler
    public void onPlayerSprint(PlayerToggleSprintEvent event) {
        Player player = event.getPlayer();
        double amount = MobilityUSBs.getAmountWalkSpeed(player);

        amount =  amount*10;
        amount = amount/100 +1;
        amount = 0.2*amount;
        player.setWalkSpeed((float) (amount));
    }
    @EventHandler
    void onMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        if (player.isSwimming() && player.isInWater()){
            double amount = MobilityUSBs.getAmountSwimSpeed(player);
            if (amount != 0) {
                amount = amount*10;
                amount = amount/100;

                player.setVelocity(player.getLocation().getDirection().multiply(amount));
            }
        }else {
            double amount = MobilityUSBs.getAmountHungerMove(player);
            amount = amount*0.001;
            amount = 1/amount;
            Random random = new Random();
            int i = random.nextInt((int) amount);
            if (i == 6) {
                player.setFoodLevel(player.getFoodLevel()+1);
            }

            double a = MobilityUSBs.getAmountExpMove(player);
            a = a*0.001;
            a = 1/a;
            int r = random.nextInt((int) a);
            if (r == 4) {
                player.giveExp(1);
            }
        }
    }
}
