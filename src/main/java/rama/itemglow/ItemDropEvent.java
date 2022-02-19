package rama.itemglow;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class ItemDropEvent implements Listener {

    private ItemGlow plugin;

    private Team team_AQUA;
    private Team team_BLACK;
    private Team team_BLUE;
    private Team team_DARK_AQUA;
    private Team team_DARK_BLUE;
    private Team team_DARK_GRAY;
    private Team team_DARK_GREEN;
    private Team team_DARK_PURPLE;
    private Team team_DARK_RED;
    private Team team_GOLD;
    private Team team_GRAY;
    private Team team_GREEN;
    private Team team_LIGHT_PURPLE;
    private Team team_RED;
    private Team team_WHITE;
    private Team team_YELLOW;

    public ItemDropEvent(ItemGlow plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void itemDropEvent (ItemSpawnEvent e) {

        for (String string : plugin.getConfig().getConfigurationSection("Items").getKeys(false)) {
            String item_name = plugin.getConfig().getString("Items." + string + ".item-name");
            String glow_color = plugin.getConfig().getString("Items." + string + ".glow-color");
                if (e.getEntity().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', item_name))) {

                    ScoreboardManager scoreboardManager = plugin.getServer().getScoreboardManager();

                    switch (glow_color) {
                        case "AQUA":
                            try {
                                this.team_AQUA = scoreboardManager.getMainScoreboard().registerNewTeam("team_AQUA");
                            } catch (IllegalArgumentException er) {
                                this.team_AQUA = scoreboardManager.getMainScoreboard().getTeam("team_AQUA");
                            }
                            this.team_AQUA.setColor(ChatColor.AQUA);
                            team_AQUA.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "BLACK":
                            try {
                                this.team_BLACK = scoreboardManager.getMainScoreboard().registerNewTeam("team_BLACK");
                            } catch (IllegalArgumentException er) {
                                this.team_BLACK = scoreboardManager.getMainScoreboard().getTeam("team_BLACK");
                            }
                            this.team_BLACK.setColor(ChatColor.BLACK);
                            team_BLACK.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "BLUE":
                            try {
                                this.team_BLUE = scoreboardManager.getMainScoreboard().registerNewTeam("team_BLUE");
                            } catch (IllegalArgumentException er) {
                                this.team_BLUE = scoreboardManager.getMainScoreboard().getTeam("team_BLUE");
                            }
                            this.team_BLUE.setColor(ChatColor.BLUE);
                            team_BLUE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_AQUA":
                            try {
                                this.team_DARK_AQUA = scoreboardManager.getMainScoreboard().registerNewTeam("team_DARK_AQUA");
                            } catch (IllegalArgumentException er) {
                                this.team_DARK_AQUA = scoreboardManager.getMainScoreboard().getTeam("team_DARK_AQUA");
                            }
                            this.team_DARK_AQUA.setColor(ChatColor.DARK_AQUA);
                            team_DARK_AQUA.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_BLUE":
                            try {
                                this.team_DARK_BLUE = scoreboardManager.getMainScoreboard().registerNewTeam("team_DARK_BLUE");
                            } catch (IllegalArgumentException er) {
                                this.team_DARK_BLUE = scoreboardManager.getMainScoreboard().getTeam("team_DARK_BLUE");
                            }
                            this.team_DARK_BLUE.setColor(ChatColor.DARK_BLUE);
                            team_DARK_BLUE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_GRAY":
                            try {
                                this.team_DARK_GRAY = scoreboardManager.getMainScoreboard().registerNewTeam("team_DARK_GRAY");
                            } catch (IllegalArgumentException er) {
                                this.team_DARK_GRAY = scoreboardManager.getMainScoreboard().getTeam("team_DARK_GRAY");
                            }
                            this.team_DARK_GRAY.setColor(ChatColor.DARK_GRAY);
                            team_DARK_GRAY.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_GREEN":
                            try {
                                this.team_DARK_GREEN = scoreboardManager.getMainScoreboard().registerNewTeam("team_DARK_GREEN");
                            } catch (IllegalArgumentException er) {
                                this.team_DARK_GREEN = scoreboardManager.getMainScoreboard().getTeam("team_DARK_GREEN");
                            }
                            this.team_DARK_GREEN.setColor(ChatColor.DARK_GREEN);
                            team_DARK_GREEN.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_PURPLE":
                            try {
                                this.team_DARK_PURPLE = scoreboardManager.getMainScoreboard().registerNewTeam("team_DARK_PURPLE");
                            } catch (IllegalArgumentException er) {
                                this.team_DARK_PURPLE = scoreboardManager.getMainScoreboard().getTeam("team_DARK_PURPLE");
                            }
                            this.team_DARK_PURPLE.setColor(ChatColor.DARK_PURPLE);
                            team_DARK_PURPLE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_RED":
                            try {
                                this.team_DARK_RED = scoreboardManager.getMainScoreboard().registerNewTeam("team_DARK_RED");
                            } catch (IllegalArgumentException er) {
                                this.team_DARK_RED = scoreboardManager.getMainScoreboard().getTeam("team_DARK_RED");
                            }
                            this.team_DARK_RED.setColor(ChatColor.DARK_RED);
                            team_DARK_RED.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "GOLD":
                            try {
                                this.team_GOLD = scoreboardManager.getMainScoreboard().registerNewTeam("team_GOLD");
                            } catch (IllegalArgumentException er) {
                                this.team_GOLD = scoreboardManager.getMainScoreboard().getTeam("team_GOLD");
                            }
                            this.team_GOLD.setColor(ChatColor.GOLD);
                            team_GOLD.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "GRAY":
                            try {
                                this.team_GRAY = scoreboardManager.getMainScoreboard().registerNewTeam("team_GRAY");
                            } catch (IllegalArgumentException er) {
                                this.team_GRAY = scoreboardManager.getMainScoreboard().getTeam("team_GRAY");
                            }
                            this.team_GRAY.setColor(ChatColor.GRAY);
                            team_GRAY.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "GREEN":
                            try {
                                this.team_GREEN = scoreboardManager.getMainScoreboard().registerNewTeam("team_GREEN");
                            } catch (IllegalArgumentException er) {
                                this.team_GREEN = scoreboardManager.getMainScoreboard().getTeam("team_GREEN");
                            }
                            this.team_GREEN.setColor(ChatColor.GREEN);
                            team_GREEN.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "LIGHT_PURPLE":
                            try {
                                this.team_LIGHT_PURPLE = scoreboardManager.getMainScoreboard().registerNewTeam("team_LIGHT_PURPLE");
                            } catch (IllegalArgumentException er) {
                                this.team_LIGHT_PURPLE = scoreboardManager.getMainScoreboard().getTeam("team_LIGHT_PURPLE");
                            }
                            this.team_LIGHT_PURPLE.setColor(ChatColor.LIGHT_PURPLE);
                            team_LIGHT_PURPLE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "RED":
                            try {
                                this.team_RED = scoreboardManager.getMainScoreboard().registerNewTeam("team_RED");
                            } catch (IllegalArgumentException er) {
                                this.team_RED = scoreboardManager.getMainScoreboard().getTeam("team_RED");
                            }
                            this.team_RED.setColor(ChatColor.RED);
                            team_RED.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "WHITE":
                            try {
                                this.team_WHITE = scoreboardManager.getMainScoreboard().registerNewTeam("team_WHITE");
                            } catch (IllegalArgumentException er) {
                                this.team_WHITE = scoreboardManager.getMainScoreboard().getTeam("team_WHITE");
                            }
                            this.team_WHITE.setColor(ChatColor.WHITE);
                            team_WHITE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "YELLOW":
                            try {
                                this.team_YELLOW = scoreboardManager.getMainScoreboard().registerNewTeam("team_YELLOW");
                            } catch (IllegalArgumentException er) {
                                this.team_YELLOW = scoreboardManager.getMainScoreboard().getTeam("team_YELLOW");
                            }
                            this.team_YELLOW.setColor(ChatColor.YELLOW);
                            team_YELLOW.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                    }
                }else if(item_name.equalsIgnoreCase("")){
                    ScoreboardManager scoreboardManager = plugin.getServer().getScoreboardManager();
                    switch (glow_color) {
                        case "AQUA":
                            try {
                                this.team_AQUA = scoreboardManager.getMainScoreboard().registerNewTeam("team_AQUA");
                            } catch (IllegalArgumentException er) {
                                this.team_AQUA = scoreboardManager.getMainScoreboard().getTeam("team_AQUA");
                            }
                            this.team_AQUA.setColor(ChatColor.AQUA);
                            team_AQUA.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "BLACK":
                            try {
                                this.team_BLACK = scoreboardManager.getMainScoreboard().registerNewTeam("team_BLACK");
                            } catch (IllegalArgumentException er) {
                                this.team_BLACK = scoreboardManager.getMainScoreboard().getTeam("team_BLACK");
                            }
                            this.team_BLACK.setColor(ChatColor.BLACK);
                            team_BLACK.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "BLUE":
                            try {
                                this.team_BLUE = scoreboardManager.getMainScoreboard().registerNewTeam("team_BLUE");
                            } catch (IllegalArgumentException er) {
                                this.team_BLUE = scoreboardManager.getMainScoreboard().getTeam("team_BLUE");
                            }
                            this.team_BLUE.setColor(ChatColor.BLUE);
                            team_BLUE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_AQUA":
                            try {
                                this.team_DARK_AQUA = scoreboardManager.getMainScoreboard().registerNewTeam("team_DARK_AQUA");
                            } catch (IllegalArgumentException er) {
                                this.team_DARK_AQUA = scoreboardManager.getMainScoreboard().getTeam("team_DARK_AQUA");
                            }
                            this.team_DARK_AQUA.setColor(ChatColor.DARK_AQUA);
                            team_DARK_AQUA.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_BLUE":
                            try {
                                this.team_DARK_BLUE = scoreboardManager.getMainScoreboard().registerNewTeam("team_DARK_BLUE");
                            } catch (IllegalArgumentException er) {
                                this.team_DARK_BLUE = scoreboardManager.getMainScoreboard().getTeam("team_DARK_BLUE");
                            }
                            this.team_DARK_BLUE.setColor(ChatColor.DARK_BLUE);
                            team_DARK_BLUE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_GRAY":
                            try {
                                this.team_DARK_GRAY = scoreboardManager.getMainScoreboard().registerNewTeam("team_DARK_GRAY");
                            } catch (IllegalArgumentException er) {
                                this.team_DARK_GRAY = scoreboardManager.getMainScoreboard().getTeam("team_DARK_GRAY");
                            }
                            this.team_DARK_GRAY.setColor(ChatColor.DARK_GRAY);
                            team_DARK_GRAY.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_GREEN":
                            try {
                                this.team_DARK_GREEN = scoreboardManager.getMainScoreboard().registerNewTeam("team_DARK_GREEN");
                            } catch (IllegalArgumentException er) {
                                this.team_DARK_GREEN = scoreboardManager.getMainScoreboard().getTeam("team_DARK_GREEN");
                            }
                            this.team_DARK_GREEN.setColor(ChatColor.DARK_GREEN);
                            team_DARK_GREEN.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_PURPLE":
                            try {
                                this.team_DARK_PURPLE = scoreboardManager.getMainScoreboard().registerNewTeam("team_DARK_PURPLE");
                            } catch (IllegalArgumentException er) {
                                this.team_DARK_PURPLE = scoreboardManager.getMainScoreboard().getTeam("team_DARK_PURPLE");
                            }
                            this.team_DARK_PURPLE.setColor(ChatColor.DARK_PURPLE);
                            team_DARK_PURPLE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_RED":
                            try {
                                this.team_DARK_RED = scoreboardManager.getMainScoreboard().registerNewTeam("team_DARK_RED");
                            } catch (IllegalArgumentException er) {
                                this.team_DARK_RED = scoreboardManager.getMainScoreboard().getTeam("team_DARK_RED");
                            }
                            this.team_DARK_RED.setColor(ChatColor.DARK_RED);
                            team_DARK_RED.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "GOLD":
                            try {
                                this.team_GOLD = scoreboardManager.getMainScoreboard().registerNewTeam("team_GOLD");
                            } catch (IllegalArgumentException er) {
                                this.team_GOLD = scoreboardManager.getMainScoreboard().getTeam("team_GOLD");
                            }
                            this.team_GOLD.setColor(ChatColor.GOLD);
                            team_GOLD.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "GRAY":
                            try {
                                this.team_GRAY = scoreboardManager.getMainScoreboard().registerNewTeam("team_GRAY");
                            } catch (IllegalArgumentException er) {
                                this.team_GRAY = scoreboardManager.getMainScoreboard().getTeam("team_GRAY");
                            }
                            this.team_GRAY.setColor(ChatColor.GRAY);
                            team_GRAY.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "GREEN":
                            try {
                                this.team_GREEN = scoreboardManager.getMainScoreboard().registerNewTeam("team_GREEN");
                            } catch (IllegalArgumentException er) {
                                this.team_GREEN = scoreboardManager.getMainScoreboard().getTeam("team_GREEN");
                            }
                            this.team_GREEN.setColor(ChatColor.GREEN);
                            team_GREEN.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "LIGHT_PURPLE":
                            try {
                                this.team_LIGHT_PURPLE = scoreboardManager.getMainScoreboard().registerNewTeam("team_LIGHT_PURPLE");
                            } catch (IllegalArgumentException er) {
                                this.team_LIGHT_PURPLE = scoreboardManager.getMainScoreboard().getTeam("team_LIGHT_PURPLE");
                            }
                            this.team_LIGHT_PURPLE.setColor(ChatColor.LIGHT_PURPLE);
                            team_LIGHT_PURPLE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "RED":
                            try {
                                this.team_RED = scoreboardManager.getMainScoreboard().registerNewTeam("team_RED");
                            } catch (IllegalArgumentException er) {
                                this.team_RED = scoreboardManager.getMainScoreboard().getTeam("team_RED");
                            }
                            this.team_RED.setColor(ChatColor.RED);
                            team_RED.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "WHITE":
                            try {
                                this.team_WHITE = scoreboardManager.getMainScoreboard().registerNewTeam("team_WHITE");
                            } catch (IllegalArgumentException er) {
                                this.team_WHITE = scoreboardManager.getMainScoreboard().getTeam("team_WHITE");
                            }
                            this.team_WHITE.setColor(ChatColor.WHITE);
                            team_WHITE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "YELLOW":
                            try {
                                this.team_YELLOW = scoreboardManager.getMainScoreboard().registerNewTeam("team_YELLOW");
                            } catch (IllegalArgumentException er) {
                                this.team_YELLOW = scoreboardManager.getMainScoreboard().getTeam("team_YELLOW");
                            }
                            this.team_YELLOW.setColor(ChatColor.YELLOW);
                            team_YELLOW.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                    }
                }
            }

        }
    }




