package rama.itemglow;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static rama.itemglow.ItemGlow.scoreboardManager;

public class PlayerJoinEvent implements Listener {

    @EventHandler
    public void event(org.bukkit.event.player.PlayerJoinEvent e){
        scoreboardManager.addPlayer(e.getPlayer());
    }
}
