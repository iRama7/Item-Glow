package rama.itemglow;

import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

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
        TabExecutor tabExecutor = new Commands(this);
        this.getCommand("irg").setExecutor(tabExecutor);
        this.getCommand("irg").setTabCompleter(tabExecutor);

        sendLog("&eRegistering color teams...");
        RegisterTeams.registerTeams();
        int pluginId = 14779;
        Metrics metrics = new Metrics(this, pluginId);


        this.reloadConfig();
    }

    @Override
    public void onDisable() {
    }

    public static ItemGlow getInstance() {
        return instance;
    }

    public static void sendLog(String message) {
        String prefix = ChatColor.translateAlternateColorCodes('&', "&c[&3ItemRarityGlow&c] ");
        Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', message));
    }

    public static void addGlow(Entity entity, ItemStack item, Material M, String N, String L, Boolean hasMaterial, Boolean hasName, Boolean hasLore, String glow_color){
        Boolean matchMaterial = item.getType().equals(M);
        Boolean matchName = item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', N));

        Boolean matchLore = false;

        if(hasLore && item.getItemMeta().getLore() != null) {
            matchLore = item.getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', L));
        }


        if(hasMaterial){
            if(hasName){
                if(hasLore){
                    if(item.getItemMeta().getLore() != null) {
                        if (matchMaterial && matchName && matchLore) {
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
                    if(matchMaterial && matchName){
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
                        if (matchLore) {
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
                    if(matchMaterial) {
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
                        if (matchName && matchLore) {
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
                    if(matchName) {
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
                        if (matchLore) {
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

    public static String createItem(String config_name, String material_name, String item_displayname, String item_lore, String glow_color){
        instance.getConfig().set("Items."+config_name, null);
        instance.getConfig().set("Items."+config_name+".item-material", material_name);
        instance.getConfig().set("Items."+config_name+".item-name", item_displayname);
        instance.getConfig().set("Items."+config_name+".item-lore", item_lore);
        instance.getConfig().set("Items."+config_name+".glow-color", glow_color);
        instance.saveConfig();
        instance.reloadConfig();
        String message = "&3&lITEMRARITYGLOW &aYou have successfully defined a new glow rule in the plugin config.";
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
