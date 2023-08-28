package rama.itemglow;

import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Team;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public final class ItemGlow extends JavaPlugin {

    FileConfiguration config = this.getConfig();
    private static ItemGlow instance;
    public static Boolean glowed = false;
    public static Boolean mmoHook;
    public static boolean nbtHook;



    private File languageFile;
    private FileConfiguration language;
    static ScoreboardManager scoreboardManager;


    @Override
    public void onEnable() {
        instance = this;
        scoreboardManager = new ScoreboardManager();
        new UpdateChecker(this, 99981).getVersion(version -> {
            if (this.getDescription().getVersion().equals(version)) {
                sendLog("&eYou are using the latest version.");
            } else {
                sendLog("&eThere is a new update available!");
                sendLog("&eYour current version: "+"&c"+instance.getDescription().getVersion());
                sendLog("&eLatest version: "+"&a"+version);
            }
        });

        sendLog("&eRegistering listeners...");
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ItemDropEvent(this), this);
        pm.registerEvents(new PlayerJoinEvent(), this);

        config.options().copyDefaults(true);
        saveDefaultConfig();
        sendLog("&eRegistering commands...");
        TabExecutor tabExecutor = new Commands(this);
        this.getCommand("irg").setExecutor(tabExecutor);
        this.getCommand("irg").setTabCompleter(tabExecutor);
        sendLog("&eRegistering color teams...");
        scoreboardManager.registerTeams();
        int pluginId = 14779;
        Metrics metrics = new Metrics(this, pluginId);
        checkHooks();
        this.reloadConfig();
        try {
            createLanguageFile();
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDisable() {
        scoreboardManager.unregisterTeams();
    }

    public static ItemGlow getInstance() {
        return instance;
    }

    public FileConfiguration getLanguage(){
        return this.language;
    }

    public void createLanguageFile() throws IOException, InvalidConfigurationException {
        languageFile = new File(getDataFolder(), "language.yml");
        if(!languageFile.exists()){
            languageFile.getParentFile().mkdirs();
            saveResource("language.yml", false);
        }
        language = new YamlConfiguration();
        language.load(languageFile);
    }

    public static void sendLog(String message) {
        String prefix = ChatColor.translateAlternateColorCodes('&', "&c[&3ItemRarityGlow&c] ");
        Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', message));
    }

    public void addGlow(Entity entity, ItemStack item, Material M, String N, String L, Boolean hasMaterial, Boolean hasName, Boolean hasLore, String glow_color, Boolean low_priority){
        String flashy_color = null;
        if(glow_color.contains("FLASHY")){
            //separate the string between "-"
            String[] split = glow_color.split("-");
            flashy_color = split[1];
            glow_color = "FLASHY";
        }
        Boolean matchMaterial = item.getType().equals(M);
        Boolean matchName = item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', N));

        Boolean matchLore = false;

        if(hasLore && item.getItemMeta().getLore() != null) {
            List<String> lore = item.getItemMeta().getLore();
            if(L.contains("\n")){
                String[] split = L.split(" \n ");
                for(String s : split){
                    if(lore.contains(ChatColor.translateAlternateColorCodes('&', s))){
                        matchLore = true;
                    }else{
                        matchLore = false;
                        break;
                    }
                }
            }else {
                matchLore = item.getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', L));
            }
        }


        if(hasMaterial){
            if(hasName){
                if(hasLore){
                    if(item.getItemMeta().getLore() != null) {
                        if (matchMaterial && matchName && matchLore) {
                            switch (glow_color) {
                                case "AQUA":
                                    scoreboardManager.team_AQUA.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "BLACK":
                                    scoreboardManager.team_BLACK.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "BLUE":
                                    scoreboardManager.team_BLUE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_AQUA":
                                    scoreboardManager.team_DARK_AQUA.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_BLUE":
                                    scoreboardManager.team_DARK_BLUE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_GRAY":
                                    scoreboardManager.team_DARK_GRAY.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_GREEN":
                                    scoreboardManager.team_DARK_GREEN.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_PURPLE":
                                    scoreboardManager.team_DARK_PURPLE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_RED":
                                    scoreboardManager.team_DARK_RED.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GOLD":
                                    scoreboardManager.team_GOLD.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GRAY":
                                    scoreboardManager.team_GRAY.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GREEN":
                                    scoreboardManager.team_GREEN.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "RED":
                                    scoreboardManager.team_RED.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "WHITE":
                                    scoreboardManager.team_WHITE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "YELLOW":
                                    scoreboardManager.team_YELLOW.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "RAINBOW":
                                    setRainbow(entity);
                                    break;
                                case "FLASHY":
                                    if(flashy_color == null){
                                        flashy_color = "WHITE";
                                    }
                                    setFlashy(entity, flashy_color);
                                    break;
                            }
                            if(!low_priority){
                                glowed = true;
                            }
                        }
                    }
                }else{
                    if(matchMaterial && matchName){
                        switch (glow_color) {
                            case "AQUA":
                                scoreboardManager.team_AQUA.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "BLACK":
                                scoreboardManager.team_BLACK.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "BLUE":
                                scoreboardManager.team_BLUE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_AQUA":
                                scoreboardManager.team_DARK_AQUA.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_BLUE":
                                scoreboardManager.team_DARK_BLUE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_GRAY":
                                scoreboardManager.team_DARK_GRAY.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_GREEN":
                                scoreboardManager.team_DARK_GREEN.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_PURPLE":
                                scoreboardManager.team_DARK_PURPLE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_RED":
                                scoreboardManager.team_DARK_RED.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "GOLD":
                                scoreboardManager.team_GOLD.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "GRAY":
                                scoreboardManager.team_GRAY.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "GREEN":
                                scoreboardManager.team_GREEN.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "RED":
                                scoreboardManager.team_RED.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "WHITE":
                                scoreboardManager.team_WHITE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "YELLOW":
                                scoreboardManager.team_YELLOW.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "RAINBOW":
                                setRainbow(entity);
                                break;
                            case "FLASHY":
                                if(flashy_color == null){
                                    flashy_color = "WHITE";
                                }
                                setFlashy(entity, flashy_color);
                                break;
                        }
                        if(!low_priority){
                            glowed = true;
                        }
                    }
                }
            }else{
                if(hasLore){
                    if(item.getItemMeta().getLore() != null) {
                        if (matchLore) {
                            switch (glow_color) {
                                case "AQUA":
                                    scoreboardManager.team_AQUA.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "BLACK":
                                    scoreboardManager.team_BLACK.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "BLUE":
                                    scoreboardManager.team_BLUE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_AQUA":
                                    scoreboardManager.team_DARK_AQUA.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_BLUE":
                                    scoreboardManager.team_DARK_BLUE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_GRAY":
                                    scoreboardManager.team_DARK_GRAY.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_GREEN":
                                    scoreboardManager.team_DARK_GREEN.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_PURPLE":
                                    scoreboardManager.team_DARK_PURPLE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_RED":
                                    scoreboardManager.team_DARK_RED.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GOLD":
                                    scoreboardManager.team_GOLD.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GRAY":
                                    scoreboardManager.team_GRAY.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GREEN":
                                    scoreboardManager.team_GREEN.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "RED":
                                    scoreboardManager.team_RED.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "WHITE":
                                    scoreboardManager.team_WHITE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "YELLOW":
                                    scoreboardManager.team_YELLOW.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "RAINBOW":
                                    setRainbow(entity);
                                    break;
                                case "FLASHY":
                                    if(flashy_color == null){
                                        flashy_color = "WHITE";
                                    }
                                    setFlashy(entity, flashy_color);
                                    break;
                            }
                            if(!low_priority){
                                glowed = true;
                            }
                        }
                    }
                }else{
                    if(matchMaterial) {
                        switch (glow_color) {
                            case "AQUA":
                                scoreboardManager.team_AQUA.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "BLACK":
                                scoreboardManager.team_BLACK.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "BLUE":
                                scoreboardManager.team_BLUE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_AQUA":
                                scoreboardManager.team_DARK_AQUA.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_BLUE":
                                scoreboardManager.team_DARK_BLUE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_GRAY":
                                scoreboardManager.team_DARK_GRAY.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_GREEN":
                                scoreboardManager.team_DARK_GREEN.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_PURPLE":
                                scoreboardManager.team_DARK_PURPLE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_RED":
                                scoreboardManager.team_DARK_RED.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "GOLD":
                                scoreboardManager.team_GOLD.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "GRAY":
                                scoreboardManager.team_GRAY.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "GREEN":
                                scoreboardManager.team_GREEN.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "RED":
                                scoreboardManager.team_RED.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "WHITE":
                                scoreboardManager.team_WHITE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "YELLOW":
                                scoreboardManager.team_YELLOW.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "RAINBOW":
                                setRainbow(entity);
                                break;
                            case "FLASHY":
                                if(flashy_color == null){
                                    flashy_color = "WHITE";
                                }
                                setFlashy(entity, flashy_color);
                                break;
                        }
                        if(!low_priority){
                            glowed = true;
                        }
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
                                    scoreboardManager.team_AQUA.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "BLACK":
                                    scoreboardManager.team_BLACK.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "BLUE":
                                    scoreboardManager.team_BLUE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_AQUA":
                                    scoreboardManager.team_DARK_AQUA.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_BLUE":
                                    scoreboardManager.team_DARK_BLUE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_GRAY":
                                    scoreboardManager.team_DARK_GRAY.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_GREEN":
                                    scoreboardManager.team_DARK_GREEN.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_PURPLE":
                                    scoreboardManager.team_DARK_PURPLE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_RED":
                                    scoreboardManager.team_DARK_RED.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GOLD":
                                    scoreboardManager.team_GOLD.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GRAY":
                                    scoreboardManager.team_GRAY.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GREEN":
                                    scoreboardManager.team_GREEN.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "RED":
                                    scoreboardManager.team_RED.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "WHITE":
                                    scoreboardManager.team_WHITE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "YELLOW":
                                    scoreboardManager.team_YELLOW.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "RAINBOW":
                                    setRainbow(entity);
                                    break;
                                case "FLASHY":
                                    if(flashy_color == null){
                                        flashy_color = "WHITE";
                                    }
                                    setFlashy(entity, flashy_color);
                                    break;
                            }
                            if(!low_priority){
                                glowed = true;
                            }
                        }
                    }
                }else{
                    if(matchName) {
                        switch (glow_color) {
                            case "AQUA":
                                scoreboardManager.team_AQUA.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "BLACK":
                                scoreboardManager.team_BLACK.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "BLUE":
                                scoreboardManager.team_BLUE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_AQUA":
                                scoreboardManager.team_DARK_AQUA.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_BLUE":
                                scoreboardManager.team_DARK_BLUE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_GRAY":
                                scoreboardManager.team_DARK_GRAY.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_GREEN":
                                scoreboardManager.team_DARK_GREEN.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_PURPLE":
                                scoreboardManager.team_DARK_PURPLE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "DARK_RED":
                                scoreboardManager.team_DARK_RED.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "GOLD":
                                scoreboardManager.team_GOLD.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "GRAY":
                                scoreboardManager.team_GRAY.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "GREEN":
                                scoreboardManager.team_GREEN.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "RED":
                                scoreboardManager.team_RED.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "WHITE":
                                scoreboardManager.team_WHITE.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "YELLOW":
                                scoreboardManager.team_YELLOW.addEntry(entity.getUniqueId().toString());
                                entity.setGlowing(true);
                                break;
                            case "RAINBOW":
                                setRainbow(entity);
                                break;
                            case "FLASHY":
                                if(flashy_color == null){
                                    flashy_color = "WHITE";
                                }
                                setFlashy(entity, flashy_color);
                                break;
                        }
                        if(!low_priority){
                            glowed = true;
                        }
                    }
                }
            }else{
                if(hasLore){
                    if(item.getItemMeta().getLore() != null) {
                        if (matchLore) {
                            switch (glow_color) {
                                case "AQUA":
                                    scoreboardManager.team_AQUA.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "BLACK":
                                    scoreboardManager.team_BLACK.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "BLUE":
                                    scoreboardManager.team_BLUE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_AQUA":
                                    scoreboardManager.team_DARK_AQUA.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_BLUE":
                                    scoreboardManager.team_DARK_BLUE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_GRAY":
                                    scoreboardManager.team_DARK_GRAY.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_GREEN":
                                    scoreboardManager.team_DARK_GREEN.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_PURPLE":
                                    scoreboardManager.team_DARK_PURPLE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_RED":
                                    scoreboardManager.team_DARK_RED.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GOLD":
                                    scoreboardManager.team_GOLD.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GRAY":
                                    scoreboardManager.team_GRAY.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GREEN":
                                    scoreboardManager.team_GREEN.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "RED":
                                    scoreboardManager.team_RED.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "WHITE":
                                    scoreboardManager.team_WHITE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "YELLOW":
                                    scoreboardManager.team_YELLOW.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "RAINBOW":
                                    setRainbow(entity);
                                    break;
                                case "FLASHY":
                                    if(flashy_color == null){
                                        flashy_color = "WHITE";
                                    }
                                    setFlashy(entity, flashy_color);
                                    break;
                            }
                            if(!low_priority){
                                glowed = true;
                            }
                        }
                    }
                }else{
                    switch (glow_color) {
                                case "AQUA":
                                    scoreboardManager.team_AQUA.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "BLACK":
                                    scoreboardManager.team_BLACK.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "BLUE":
                                    scoreboardManager.team_BLUE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_AQUA":
                                    scoreboardManager.team_DARK_AQUA.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_BLUE":
                                    scoreboardManager.team_DARK_BLUE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_GRAY":
                                    scoreboardManager.team_DARK_GRAY.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_GREEN":
                                    scoreboardManager.team_DARK_GREEN.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_PURPLE":
                                    scoreboardManager.team_DARK_PURPLE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "DARK_RED":
                                    scoreboardManager.team_DARK_RED.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GOLD":
                                    scoreboardManager.team_GOLD.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GRAY":
                                    scoreboardManager.team_GRAY.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "GREEN":
                                    scoreboardManager.team_GREEN.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "RED":
                                    scoreboardManager.team_RED.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "WHITE":
                                    scoreboardManager.team_WHITE.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "YELLOW":
                                    scoreboardManager.team_YELLOW.addEntry(entity.getUniqueId().toString());
                                    entity.setGlowing(true);
                                    break;
                                case "RAINBOW":
                                    setRainbow(entity);
                                    break;
                                case "FLASHY":
                                    if(flashy_color == null){
                                        flashy_color = "WHITE";
                                    }
                                    setFlashy(entity, flashy_color);
                                    break;
                            }
                    if(!low_priority){
                        glowed = true;
                    }
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

    public void checkHooks(){
        if(Bukkit.getPluginManager().getPlugin("MythicLib") == null){
            sendLog("MythicLib not found, disabling MMOItems hook.");
            mmoHook = false;
        }else{
            sendLog("&aEnabling MMOItems hook.");
            mmoHook = true;
        }
        if(Bukkit.getPluginManager().getPlugin("NBTAPI") == null){
            sendLog("item-nbt-api not found, disabling custom NBTTags support.");
            nbtHook = false;
        }else{
            sendLog("&aEnabling custom NBTTags support.");
            nbtHook = true;
        }
    }
    public void addDirectGLow(Entity entity, String glow_color){

        String flashy_color = null;
        if(glow_color.contains("FLASHY")){
            //separate the string between "-"
            String[] split = glow_color.split("-");
            flashy_color = split[1];
            glow_color = "FLASHY";
        }

        switch (glow_color) {
            case "AQUA":
                scoreboardManager.team_AQUA.addEntry(entity.getUniqueId().toString());
                entity.setGlowing(true);
                break;
            case "BLACK":
                scoreboardManager.team_BLACK.addEntry(entity.getUniqueId().toString());
                entity.setGlowing(true);
                break;
            case "BLUE":
                scoreboardManager.team_BLUE.addEntry(entity.getUniqueId().toString());
                entity.setGlowing(true);
                break;
            case "DARK_AQUA":
                scoreboardManager.team_DARK_AQUA.addEntry(entity.getUniqueId().toString());
                entity.setGlowing(true);
                break;
            case "DARK_BLUE":
                scoreboardManager.team_DARK_BLUE.addEntry(entity.getUniqueId().toString());
                entity.setGlowing(true);
                break;
            case "DARK_GRAY":
                scoreboardManager.team_DARK_GRAY.addEntry(entity.getUniqueId().toString());
                entity.setGlowing(true);
                break;
            case "DARK_GREEN":
                scoreboardManager.team_DARK_GREEN.addEntry(entity.getUniqueId().toString());
                entity.setGlowing(true);
                break;
            case "DARK_PURPLE":
                scoreboardManager.team_DARK_PURPLE.addEntry(entity.getUniqueId().toString());
                entity.setGlowing(true);
                break;
            case "DARK_RED":
                scoreboardManager.team_DARK_RED.addEntry(entity.getUniqueId().toString());
                entity.setGlowing(true);
                break;
            case "GOLD":
                scoreboardManager.team_GOLD.addEntry(entity.getUniqueId().toString());
                entity.setGlowing(true);
                break;
            case "GRAY":
                scoreboardManager.team_GRAY.addEntry(entity.getUniqueId().toString());
                entity.setGlowing(true);
                break;
            case "GREEN":
                scoreboardManager.team_GREEN.addEntry(entity.getUniqueId().toString());
                entity.setGlowing(true);
                break;
            case "RED":
                scoreboardManager.team_RED.addEntry(entity.getUniqueId().toString());
                entity.setGlowing(true);
                break;
            case "WHITE":
                scoreboardManager.team_WHITE.addEntry(entity.getUniqueId().toString());
                entity.setGlowing(true);
                break;
            case "YELLOW":
                scoreboardManager.team_YELLOW.addEntry(entity.getUniqueId().toString());
                entity.setGlowing(true);
                break;
            case "RAINBOW":
                setRainbow(entity);
                break;
            case "FLASHY":
                if(flashy_color == null){
                    flashy_color = "WHITE";
                }
                setFlashy(entity, flashy_color);
                break;
        }
    }

    public void setRainbow(Entity e){
        List<Team> teams = new ArrayList<>();
        teams.add(scoreboardManager.team_AQUA);
        teams.add(scoreboardManager.team_BLUE);
        teams.add(scoreboardManager.team_DARK_AQUA);
        teams.add(scoreboardManager.team_DARK_BLUE);
        teams.add(scoreboardManager.team_DARK_GREEN);
        teams.add(scoreboardManager.team_DARK_PURPLE);
        teams.add(scoreboardManager.team_DARK_RED);
        teams.add(scoreboardManager.team_GOLD);
        teams.add(scoreboardManager.team_GREEN);
        teams.add(scoreboardManager.team_RED);
        teams.add(scoreboardManager.team_YELLOW);
        e.setGlowing(true);
        Random random = new Random();
        int interval = this.getConfig().getInt("rainbow-interval");
        Bukkit.getScheduler().runTaskTimerAsynchronously(instance, new Runnable() {
            @Override
            public void run() {
                int i = random.nextInt(0, teams.size()-1);
                if(teams.get(i).hasEntry(e.getUniqueId().toString())){
                    i = random.nextInt(0, teams.size()-1);
                }
                teams.get(i).addEntry(e.getUniqueId().toString());
                e.setGlowing(true);
            }
        }, 0, interval);
    }

    public void setFlashy(Entity e, String color){
        int interval = this.getConfig().getInt("flashy-interval");
        String team_name = "team_" + color;
        Team team = scoreboardManager.getTeam(team_name);
        team.addEntry(e.getUniqueId().toString());
        Bukkit.getScheduler().runTaskTimerAsynchronously(instance, new Runnable() {
            @Override
            public void run() {
                if(e.isGlowing()){
                    if(team.hasEntry(e.getUniqueId().toString())){
                        team.removeEntry(e.getUniqueId().toString());
                    }
                    e.setGlowing(false);
                }else{
                    if(!team.hasEntry(e.getUniqueId().toString())) {
                        team.addEntry(e.getUniqueId().toString());
                        e.setGlowing(true);
                    }
                }
            }
        }, 0, interval);
    }

}
