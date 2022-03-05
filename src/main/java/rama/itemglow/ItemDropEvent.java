package rama.itemglow;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;

import static rama.itemglow.RegisterTeams.*;

public class ItemDropEvent implements Listener {

    private ItemGlow plugin;
    public ItemDropEvent(ItemGlow plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void itemDropEvent (ItemSpawnEvent e) {

        for (String string : plugin.getConfig().getConfigurationSection("Items").getKeys(false)) {


            Material material = Material.getMaterial(plugin.getConfig().getString("Items."+string+".item-material"));

            String item_name = plugin.getConfig().getString("Items." + string + ".item-name");
            String glow_color = plugin.getConfig().getString("Items." + string + ".glow-color");

            if(plugin.getConfig().getString("Items."+string+".item-material").equalsIgnoreCase("any") && !item_name.equalsIgnoreCase("any")){
                if (e.getEntity().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', item_name))) {
                    switch (glow_color) {
                        case "AQUA":
                            team_AQUA.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "BLACK":
                            team_BLACK.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "BLUE":
                            team_BLUE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_AQUA":
                            team_DARK_AQUA.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_BLUE":
                            team_DARK_BLUE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_GRAY":
                            team_DARK_GRAY.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_GREEN":
                            team_DARK_GREEN.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_PURPLE":
                            team_DARK_PURPLE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_RED":
                            team_DARK_RED.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "GOLD":
                            team_GOLD.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "GRAY":
                            team_GRAY.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "GREEN":
                            team_GREEN.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "LIGHT_PURPLE":
                            //team_LIGHT_PURPLE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "RED":
                            team_RED.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "WHITE":
                            team_WHITE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "YELLOW":
                            team_YELLOW.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                    }
                }
            }else if(plugin.getConfig().getString("Items."+string+".item-material").equalsIgnoreCase("any")){
                if (e.getEntity().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', item_name))) {
                    switch (glow_color) {
                        case "AQUA":
                            team_AQUA.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "BLACK":
                            team_BLACK.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "BLUE":
                            team_BLUE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_AQUA":
                            team_DARK_AQUA.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_BLUE":
                            team_DARK_BLUE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_GRAY":
                            team_DARK_GRAY.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_GREEN":
                            team_DARK_GREEN.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_PURPLE":
                            team_DARK_PURPLE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_RED":
                            team_DARK_RED.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "GOLD":
                            team_GOLD.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "GRAY":
                            team_GRAY.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "GREEN":
                            team_GREEN.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "LIGHT_PURPLE":
                            //team_LIGHT_PURPLE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "RED":
                            team_RED.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "WHITE":
                            team_WHITE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "YELLOW":
                            team_YELLOW.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                    }
                }else if(item_name.equalsIgnoreCase("any")){
                    switch (glow_color) {
                        case "AQUA":
                            team_AQUA.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "BLACK":
                            team_BLACK.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "BLUE":
                            team_BLUE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_AQUA":
                            team_DARK_AQUA.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_BLUE":
                            team_DARK_BLUE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_GRAY":
                            team_DARK_GRAY.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_GREEN":
                            team_DARK_GREEN.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_PURPLE":
                            team_DARK_PURPLE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_RED":
                            team_DARK_RED.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "GOLD":
                            team_GOLD.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "GRAY":
                            team_GRAY.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "GREEN":
                            team_GREEN.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "LIGHT_PURPLE":
                            //team_LIGHT_PURPLE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "RED":
                            team_RED.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "WHITE":
                            team_WHITE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "YELLOW":
                            team_YELLOW.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                    }
                }
            }else{
                if(e.getEntity().getItemStack().getType().equals(material)){
                    switch (glow_color) {
                        case "AQUA":
                            team_AQUA.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "BLACK":
                            team_BLACK.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "BLUE":
                            team_BLUE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_AQUA":
                            team_DARK_AQUA.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_BLUE":
                            team_DARK_BLUE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_GRAY":
                            team_DARK_GRAY.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_GREEN":
                            team_DARK_GREEN.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_PURPLE":
                            team_DARK_PURPLE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "DARK_RED":
                            team_DARK_RED.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "GOLD":
                            team_GOLD.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "GRAY":
                            team_GRAY.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "GREEN":
                            team_GREEN.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "LIGHT_PURPLE":
                            //team_LIGHT_PURPLE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "RED":
                            team_RED.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "WHITE":
                            team_WHITE.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                        case "YELLOW":
                            team_YELLOW.addEntry(e.getEntity().getUniqueId().toString());
                            e.getEntity().setGlowing(true);
                            break;
                    }
                }
            }
        }

        }
    }




