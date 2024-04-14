package de.nikey.upgradesticks.listener;

import de.nikey.upgradesticks.ItemStacks.DefenseSticks;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class DefenseUSB implements Listener {
    @EventHandler
    public void onArmorDamage(PlayerItemDamageEvent event) {

        String name = event.getItem().getType().name().toLowerCase();
        if (name.contains("helmet") || name.contains("chestplate") || name.contains("leggings") || name.contains("boots")) {
            Random random = new Random();
            if (random.nextInt(1000) == 333) {
                event.getPlayer().playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
                DefenseSticks.ArmorStick(event.getPlayer());
            }

            if (random.nextInt(950) == 875) {
                event.getPlayer().playSound(Sound.sound(Key.key("entity.experience_orb.pickup"), Sound.Source.AMBIENT,1,1));
                DefenseSticks.ArmorToughnessStick(event.getPlayer());
            }
        }
    }

    @EventHandler
    public void onEntityPotionEffect(EntityPotionEffectEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
        }
    }
}
