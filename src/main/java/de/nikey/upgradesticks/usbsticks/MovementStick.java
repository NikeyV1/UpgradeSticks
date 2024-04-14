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

        amount =  amount*8;
        amount = amount/100 +1;
        player.setWalkSpeed((float) (0.2*amount));
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
            int amount = MobilityUSBs.getAmountHungerMove(player);
            Random random = new Random();
            if (amount == 1) {
                int i = random.nextInt(1000);
                if (i == 500) {
                    player.setFoodLevel(player.getFoodLevel()+1);
                }
            }else if (amount == 2) {
                int i = random.nextInt(500);
                if (i == 90) {
                    player.setFoodLevel(player.getFoodLevel()+1);
                }
            }else if (amount == 3) {
                int i = random.nextInt(333);
                if (i == 260) {
                    player.setFoodLevel(player.getFoodLevel()+1);
                }
            }else if (amount == 4) {
                int i = random.nextInt(250);
                if (i == 160) {
                    player.setFoodLevel(player.getFoodLevel()+1);
                }
            }else if (amount == 5) {
                int i = random.nextInt(200);
                if (i == 160) {
                    player.setFoodLevel(player.getFoodLevel()+1);
                }
            }else if (amount == 6) {
                int i = random.nextInt(167);
                if (i == 160) {
                    player.setFoodLevel(player.getFoodLevel()+1);
                }
            }

            int a = MobilityUSBs.getAmountExpMove(player);
            if (a == 1) {
                int i = random.nextInt(1000);
                if (i == 100) {
                    player.giveExp(1);
                }
            }else if (a == 2) {
                int i = random.nextInt(500);
                if (i == 60) {
                    player.giveExp(1);
                }
            }else if (a == 3) {
                int i = random.nextInt(333);
                if (i == 30) {
                    player.giveExp(1);
                }
            }else if (a == 4) {
                int i = random.nextInt(250);
                if (i == 30) {
                    player.giveExp(1);
                }
            }else if (a == 5) {
                int i = random.nextInt(200);
                if (i == 20) {
                    player.giveExp(1);
                }
            }else if (a == 6) {
                int i = random.nextInt(167);
                if (i == 20) {
                    player.giveExp(1);
                }
            }
        }
    }
}
