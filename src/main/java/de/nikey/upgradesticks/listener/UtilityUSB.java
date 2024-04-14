package de.nikey.upgradesticks.listener;

import de.nikey.upgradesticks.ItemStacks.UtilitySticks;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRiptideEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.util.Vector;

import java.util.Random;

public class UtilityUSB implements Listener {
    @EventHandler
    public void onPlayerRiptide(PlayerRiptideEvent event) {
        Player player = event.getPlayer();
        Random random = new Random();
        if (random.nextInt(200) == 189) {
            UtilitySticks.TridentLightningStick(player);
        }

    }

}
