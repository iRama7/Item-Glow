package rama.itemglow;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import org.inventivetalent.glow.GlowAPI;

public class ItemDropEvent implements Listener {

    private ItemGlow plugin;

    private Team team_gryffin;
    private Team team_azada;

    public ItemDropEvent(ItemGlow plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void itemDropEvent (ItemSpawnEvent e){

        ScoreboardManager scoreboardManager = plugin.getServer().getScoreboardManager();
        if(scoreboardManager == null){
            return;
        }

        if(e.getEntity().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&6⚜ Espada de Gryffindor ⚜"))) {
            try {
                this.team_gryffin = scoreboardManager.getMainScoreboard().registerNewTeam("team_gryffin");
            } catch (IllegalArgumentException er) {
                this.team_gryffin = scoreboardManager.getMainScoreboard().getTeam("team_gryffin");
            }
            this.team_gryffin.setColor(ChatColor.DARK_PURPLE);
            team_gryffin.addEntry(e.getEntity().getUniqueId().toString());

        }else if(e.getEntity().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&6Azada de Joe"))){
            try {
                this.team_azada = scoreboardManager.getMainScoreboard().registerNewTeam("team_azada");
            } catch (IllegalArgumentException er) {
                this.team_azada = scoreboardManager.getMainScoreboard().getTeam("team_azada");
            }
            this.team_azada.setColor(ChatColor.GRAY);
            team_azada.addEntry(e.getEntity().getUniqueId().toString());
        }

        e.getEntity().setGlowing(true);
    }
}


