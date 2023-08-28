package rama.itemglow;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import static rama.itemglow.ItemGlow.getInstance;

public class ScoreboardManager {

    private static final org.bukkit.scoreboard.ScoreboardManager scoreboardManager = getInstance().getServer().getScoreboardManager();
    private static final Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
    public Team team_AQUA;
    public Team team_BLACK;
    public Team team_BLUE;
    public Team team_DARK_AQUA;
    public Team team_DARK_BLUE;
    public Team team_DARK_GRAY;
    public Team team_DARK_GREEN;
    public Team team_DARK_PURPLE;
    public Team team_GOLD;
    public Team team_GRAY;
    public Team team_GREEN;
    public Team team_RED;
    public Team team_WHITE;
    public Team team_YELLOW;
    public Team team_DARK_RED;

    public void registerTeams(){
        try {
            team_BLACK = scoreboard.registerNewTeam("team_BLACK");
        } catch (IllegalArgumentException er) {
            team_BLACK = scoreboard.getTeam("team_BLACK");
        }
        team_BLACK.setColor(ChatColor.BLACK);

        try {
            team_BLUE = scoreboard.registerNewTeam("team_BLUE");
        } catch (IllegalArgumentException er) {
            team_BLUE = scoreboard.getTeam("team_BLUE");
        }
        team_BLUE.setColor(ChatColor.BLUE);

        try {
            team_DARK_AQUA = scoreboard.registerNewTeam("team_DARK_AQUA");
        } catch (IllegalArgumentException er) {
            team_DARK_AQUA = scoreboard.getTeam("team_DARK_AQUA");
        }
        team_DARK_AQUA.setColor(ChatColor.DARK_AQUA);

        try {
            team_DARK_BLUE = scoreboard.registerNewTeam("team_DARK_BLUE");
        } catch (IllegalArgumentException er) {
            team_DARK_BLUE = scoreboard.getTeam("team_DARK_BLUE");
        }
        team_DARK_BLUE.setColor(ChatColor.DARK_BLUE);

        try {
            team_DARK_GRAY = scoreboard.registerNewTeam("team_DARK_GRAY");
        } catch (IllegalArgumentException er) {
            team_DARK_GRAY = scoreboard.getTeam("team_DARK_GRAY");
        }
        team_DARK_GRAY.setColor(ChatColor.DARK_GRAY);

        try {
            team_DARK_GREEN = scoreboard.registerNewTeam("team_DARK_GREEN");
        } catch (IllegalArgumentException er) {
            team_DARK_GREEN = scoreboard.getTeam("team_DARK_GREEN");
        }
        team_DARK_GREEN.setColor(ChatColor.DARK_GREEN);

        try {
            team_DARK_PURPLE = scoreboard.registerNewTeam("team_DARK_PURPLE");
        } catch (IllegalArgumentException er) {
            team_DARK_PURPLE = scoreboard.getTeam("team_DARK_PURPLE");
        }
        team_DARK_PURPLE.setColor(ChatColor.DARK_PURPLE);

        try {
            team_DARK_RED = scoreboard.registerNewTeam("team_DARK_RED");
        } catch (IllegalArgumentException er) {
            team_DARK_RED = scoreboard.getTeam("team_DARK_RED");
        }
        team_DARK_RED.setColor(ChatColor.DARK_RED);

        try {
            team_GOLD = scoreboard.registerNewTeam("team_GOLD");
        } catch (IllegalArgumentException er) {
            team_GOLD = scoreboard.getTeam("team_GOLD");
        }
        team_GOLD.setColor(ChatColor.GOLD);

        try {
            team_GRAY = scoreboard.registerNewTeam("team_GRAY");
        } catch (IllegalArgumentException er) {
            team_GRAY = scoreboard.getTeam("team_GRAY");
        }
        team_GRAY.setColor(ChatColor.GRAY);

        try {
            team_GREEN = scoreboard.registerNewTeam("team_GREEN");
        } catch (IllegalArgumentException er) {
            team_GREEN = scoreboard.getTeam("team_GREEN");
        }
        team_GREEN.setColor(ChatColor.GREEN);

        try {
            team_RED = scoreboard.registerNewTeam("team_RED");
        } catch (IllegalArgumentException er) {
            team_RED = scoreboard.getTeam("team_RED");
        }
        team_RED.setColor(ChatColor.RED);

        try {
            team_WHITE = scoreboard.registerNewTeam("team_WHITE");
        } catch (IllegalArgumentException er) {
            team_WHITE = scoreboard.getTeam("team_WHITE");
        }
        team_WHITE.setColor(ChatColor.WHITE);

        try {
            team_YELLOW = scoreboard.registerNewTeam("team_YELLOW");
        } catch (IllegalArgumentException er) {
            team_YELLOW = scoreboard.getTeam("team_YELLOW");
        }
        team_YELLOW.setColor(ChatColor.YELLOW);
    }

    public Team getTeam(String name){
        return scoreboard.getTeam(name);
    }

    public void addPlayer(Player p ){
        p.setScoreboard(scoreboard);
    }

    public void unregisterTeams(){
        team_AQUA.unregister();
        team_BLACK.unregister();
        team_BLUE.unregister();
        team_DARK_AQUA.unregister();
        team_DARK_BLUE.unregister();
        team_DARK_GRAY.unregister();
        team_DARK_GREEN.unregister();
        team_DARK_PURPLE.unregister();
        team_DARK_RED.unregister();
        team_GOLD.unregister();
        team_GRAY.unregister();
        team_GREEN.unregister();
        team_RED.unregister();
        team_WHITE.unregister();
        team_YELLOW.unregister();
    }

}
