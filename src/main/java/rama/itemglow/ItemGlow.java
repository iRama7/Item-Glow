package rama.itemglow;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

import static rama.itemglow.RegisterTeams.*;

public final class ItemGlow extends JavaPlugin {

    FileConfiguration config = this.getConfig();
    private static ItemGlow instance;
    public static Boolean glowed = false;

    @Override
    public void onEnable() {
        instance = this;

        sendLog("&eRegistering listeners...");
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ItemDropEvent(this), this);

        config.options().copyDefaults(true);
        saveDefaultConfig();

        sendLog("&eRegistering commands...");
        this.getCommand("irg").setExecutor(new reloadCommand(this));

        sendLog("&eRegistering color teams...");
        RegisterTeams.registerTeams();

        this.reloadConfig();
    }

    @Override
    public void onDisable() {
    }

    public static ItemGlow getInstance() {
        return instance;
    }

    public static void sendLog(String message){
        String prefix = ChatColor.translateAlternateColorCodes('&', "&c[&3ItemRarityGlow&c] ");
        Bukkit.getConsoleSender().sendMessage(prefix+ChatColor.translateAlternateColorCodes('&', message));
    }

    //true true true
    //true true false

    //true false true
    //true false false

    //false false false
    //false false true

    //false true false
    //false true true
    public static void addGlow(Entity entity, ItemStack item, Material M, String N, List<String> L, Boolean hasMaterial, Boolean hasName, Boolean hasLore, String glow_color){
        if(hasMaterial){
            if(hasName){
                if(hasLore){
                    if(item.getItemMeta().getLore() != null) {
                        if (item.getType().equals(M) && item.getItemMeta().getDisplayName().equalsIgnoreCase(N) && item.getItemMeta().getLore().equals(L)) {
                            switch (glow_color) {
                                case "AQUA":
                                    team_AQUA.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "BLACK":
                                    team_BLACK.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "BLUE":
                                    team_BLUE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_AQUA":
                                    team_DARK_AQUA.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_BLUE":
                                    team_DARK_BLUE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_GRAY":
                                    team_DARK_GRAY.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_GREEN":
                                    team_DARK_GREEN.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_PURPLE":
                                    team_DARK_PURPLE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_RED":
                                    team_DARK_RED.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GOLD":
                                    team_GOLD.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GRAY":
                                    team_GRAY.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GREEN":
                                    team_GREEN.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "RED":
                                    team_RED.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "WHITE":
                                    team_WHITE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "YELLOW":
                                    team_YELLOW.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                            }
                            glowed = true;
                        }
                    }
                }else{
                    if(item.getType().equals(M) && item.getItemMeta().getDisplayName().equalsIgnoreCase(N)) {
                        switch (glow_color) {
                            case "AQUA":
                                team_AQUA.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "BLACK":
                                team_BLACK.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "BLUE":
                                team_BLUE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_AQUA":
                                team_DARK_AQUA.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_BLUE":
                                team_DARK_BLUE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_GRAY":
                                team_DARK_GRAY.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_GREEN":
                                team_DARK_GREEN.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_PURPLE":
                                team_DARK_PURPLE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_RED":
                                team_DARK_RED.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "GOLD":
                                team_GOLD.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "GRAY":
                                team_GRAY.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "GREEN":
                                team_GREEN.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "RED":
                                team_RED.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "WHITE":
                                team_WHITE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "YELLOW":
                                team_YELLOW.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                        }
                        glowed = true;
                    }
                }
            }else{
                if(hasLore){
                    if(item.getItemMeta().getLore() != null) {
                        if (item.getType().equals(M) && item.getItemMeta().getLore().equals(L)) {
                            switch (glow_color) {
                                case "AQUA":
                                    team_AQUA.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "BLACK":
                                    team_BLACK.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "BLUE":
                                    team_BLUE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_AQUA":
                                    team_DARK_AQUA.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_BLUE":
                                    team_DARK_BLUE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_GRAY":
                                    team_DARK_GRAY.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_GREEN":
                                    team_DARK_GREEN.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_PURPLE":
                                    team_DARK_PURPLE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_RED":
                                    team_DARK_RED.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GOLD":
                                    team_GOLD.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GRAY":
                                    team_GRAY.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GREEN":
                                    team_GREEN.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "RED":
                                    team_RED.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "WHITE":
                                    team_WHITE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "YELLOW":
                                    team_YELLOW.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                            }
                            glowed = true;
                        }
                    }
                }else{
                    if(item.getType().equals(M)) {
                        switch (glow_color) {
                            case "AQUA":
                                team_AQUA.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "BLACK":
                                team_BLACK.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "BLUE":
                                team_BLUE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_AQUA":
                                team_DARK_AQUA.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_BLUE":
                                team_DARK_BLUE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_GRAY":
                                team_DARK_GRAY.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_GREEN":
                                team_DARK_GREEN.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_PURPLE":
                                team_DARK_PURPLE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_RED":
                                team_DARK_RED.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "GOLD":
                                team_GOLD.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "GRAY":
                                team_GRAY.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "GREEN":
                                team_GREEN.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "RED":
                                team_RED.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "WHITE":
                                team_WHITE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "YELLOW":
                                team_YELLOW.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                        }
                        glowed = true;
                    }
                }
            }
        }else{
            if(hasName){
                if(hasLore){
                    if(item.getItemMeta().getLore() != null) {
                        if (item.getItemMeta().getLore().equals(L) && item.getItemMeta().getDisplayName().equalsIgnoreCase(N)) {
                            switch (glow_color) {
                                case "AQUA":
                                    team_AQUA.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "BLACK":
                                    team_BLACK.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "BLUE":
                                    team_BLUE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_AQUA":
                                    team_DARK_AQUA.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_BLUE":
                                    team_DARK_BLUE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_GRAY":
                                    team_DARK_GRAY.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_GREEN":
                                    team_DARK_GREEN.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_PURPLE":
                                    team_DARK_PURPLE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_RED":
                                    team_DARK_RED.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GOLD":
                                    team_GOLD.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GRAY":
                                    team_GRAY.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GREEN":
                                    team_GREEN.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "RED":
                                    team_RED.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "WHITE":
                                    team_WHITE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "YELLOW":
                                    team_YELLOW.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                            }
                            glowed = true;
                        }
                    }
                }else{
                    if(item.getItemMeta().getDisplayName().equalsIgnoreCase(N)) {
                        switch (glow_color) {
                            case "AQUA":
                                team_AQUA.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "BLACK":
                                team_BLACK.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "BLUE":
                                team_BLUE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_AQUA":
                                team_DARK_AQUA.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_BLUE":
                                team_DARK_BLUE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_GRAY":
                                team_DARK_GRAY.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_GREEN":
                                team_DARK_GREEN.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_PURPLE":
                                team_DARK_PURPLE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_RED":
                                team_DARK_RED.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "GOLD":
                                team_GOLD.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "GRAY":
                                team_GRAY.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "GREEN":
                                team_GREEN.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "RED":
                                team_RED.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "WHITE":
                                team_WHITE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "YELLOW":
                                team_YELLOW.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                        }
                        glowed = true;
                    }
                }
            }else{
                if(hasLore){
                    if(item.getItemMeta().getLore() != null) {
                        if (item.getItemMeta().getLore().equals(L)) {
                            switch (glow_color) {
                                case "AQUA":
                                    team_AQUA.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "BLACK":
                                    team_BLACK.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "BLUE":
                                    team_BLUE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_AQUA":
                                    team_DARK_AQUA.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_BLUE":
                                    team_DARK_BLUE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_GRAY":
                                    team_DARK_GRAY.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_GREEN":
                                    team_DARK_GREEN.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_PURPLE":
                                    team_DARK_PURPLE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_RED":
                                    team_DARK_RED.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GOLD":
                                    team_GOLD.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GRAY":
                                    team_GRAY.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GREEN":
                                    team_GREEN.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "RED":
                                    team_RED.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "WHITE":
                                    team_WHITE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "YELLOW":
                                    team_YELLOW.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                            }
                            glowed = true;
                        }
                    }
                }else{
                    switch (glow_color) {
                                case "AQUA":
                                    team_AQUA.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "BLACK":
                                    team_BLACK.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "BLUE":
                                    team_BLUE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_AQUA":
                                    team_DARK_AQUA.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_BLUE":
                                    team_DARK_BLUE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_GRAY":
                                    team_DARK_GRAY.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_GREEN":
                                    team_DARK_GREEN.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_PURPLE":
                                    team_DARK_PURPLE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_RED":
                                    team_DARK_RED.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GOLD":
                                    team_GOLD.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GRAY":
                                    team_GRAY.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GREEN":
                                    team_GREEN.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "RED":
                                    team_RED.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "WHITE":
                                    team_WHITE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "YELLOW":
                                    team_YELLOW.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                            }
                    glowed = true;
                }
            }
        }
    }
}
