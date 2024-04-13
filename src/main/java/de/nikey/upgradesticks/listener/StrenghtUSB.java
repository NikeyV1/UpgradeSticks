package de.nikey.upgradesticks.listener;

import de.nikey.upgradesticks.ItemStacks.StrenghSticks;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Random;

public class StrenghtUSB implements Listener {
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();
        Player killer = entity.getKiller();
        if (entity.getKiller() != null) {
            if (entity instanceof Warden) {
                Random random = new Random();
                int i = random.nextInt(3);
                if (i == 2) {
                    StrenghSticks.CloseDamageStick(killer);
                }
            } else if (entity instanceof Zombie) {
                Random random = new Random();
                int i = random.nextInt(400);
                if (i == 220) {
                    StrenghSticks.CloseDamageStick(killer);
                }
            }else if (entity instanceof Skeleton) {
                Random random = new Random();
                int i = random.nextInt(350);
                if (i == 220) {
                    StrenghSticks.DistantDamageStick(killer);
                }
            }else if (entity instanceof Pillager) {
                Random random = new Random();
                int i = random.nextInt(120);
                if (i == 50) {
                    StrenghSticks.DistantDamageStick(killer);
                }
            }
        }
    }



}
