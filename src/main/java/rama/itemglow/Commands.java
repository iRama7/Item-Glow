package rama.itemglow;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static rama.itemglow.ItemGlow.*;

public class Commands implements TabExecutor {

    private ItemGlow plugin;
    public Commands(ItemGlow plugin) {
        this.plugin = plugin;
    }
    Boolean isEnabled;




    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        FileConfiguration language = plugin.getLanguage();

        //language definitions
        String prefix = language.getString("prefix");
        List<String> use = language.getStringList("use");
        String reload_message = language.getString("reload");
        String args_message = language.getString("args");
        String already_defined_message = language.getString("already-defined");
        String holding_air_message = language.getString("holding-air");
        String non_existent_color_message = language.getString("non-existent-color");
        String toggle_off_message = language.getString("toggle-off");
        String toggle_on_message = language.getString("toggle-on");
        //language definitions

        if(!(sender instanceof Player)){
            if(args[0].equalsIgnoreCase("reload")) {
                plugin.reloadConfig();
                plugin.reloadConfig();
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', prefix+reload_message));
            }
        }else {
            Player p = (Player) sender;
            if (args.length == 0) {

                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix));
                for(String line : use){
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
                }
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix));
            } else if (args[0].equalsIgnoreCase("reload") && sender.hasPermission("irg.admin")) {
                plugin.reloadConfig();
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix+reload_message));
            } else if (args[0].equals("addGlowRule") && sender.hasPermission("irg.admin")) {
                if (args.length != 3) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', args_message));
                } else {
                    String config_name = args[1];
                    if (plugin.getConfig().isSet("Items." + config_name)) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', already_defined_message));
                    } else {
                        ItemStack itemInHand = p.getInventory().getItemInMainHand();
                        Material materialInHand = p.getInventory().getItemInMainHand().getType();
                        if (materialInHand == Material.AIR) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', holding_air_message));
                        } else {
                            String material_name = materialInHand.name();
                            String item_displayname = "any";
                            String item_lore = null;
                            if (itemInHand.getItemMeta().hasDisplayName()) {
                                item_displayname = itemInHand.getItemMeta().getDisplayName();
                            }
                            if (itemInHand.getItemMeta().hasLore()) {
                                List<String> itemlore = itemInHand.getItemMeta().getLore();
                                item_lore = itemlore.get(itemlore.size() - 1);
                            }
                            String glow_color = args[2];
                            ArrayList<String> glow_colors = new ArrayList<String>();
                            glow_colors.add("AQUA");
                            glow_colors.add("BLACK");
                            glow_colors.add("BLUE");
                            glow_colors.add("DARK_AQUA");
                            glow_colors.add("DARK_BLUE");
                            glow_colors.add("DARK_GRAY");
                            glow_colors.add("DARK_GREEN");
                            glow_colors.add("DARK_PURPLE");
                            glow_colors.add("DARK_RED");
                            glow_colors.add("GOLD");
                            glow_colors.add("GRAY");
                            glow_colors.add("GREEN");
                            glow_colors.add("RED");
                            glow_colors.add("WHITE");
                            glow_colors.add("YELLOW");
                            glow_colors.add("FLASHY-AQUA");
                            glow_colors.add("FLASHY-BLACK");
                            glow_colors.add("FLASHY-BLUE");
                            glow_colors.add("FLASHY-DARK_AQUA");
                            glow_colors.add("FLASHY-DARK_BLUE");
                            glow_colors.add("FLASHY-DARK_GRAY");
                            glow_colors.add("FLASHY-DARK_GREEN");
                            glow_colors.add("FLASHY-DARK_PURPLE");
                            glow_colors.add("FLASHY-DARK_RED");
                            glow_colors.add("FLASHY-GOLD");
                            glow_colors.add("FLASHY-GRAY");
                            glow_colors.add("FLASHY-GREEN");
                            glow_colors.add("FLASHY-RED");
                            glow_colors.add("FLASHY-WHITE");
                            glow_colors.add("FLASHY-YELLOW");
                            glow_colors.add("RAINBOW");
                            if (!glow_colors.contains(glow_color)) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', non_existent_color_message).replaceAll("%glow_color%", glow_color));
                            } else {
                                sender.sendMessage(createItem(config_name, material_name, item_displayname, item_lore, glow_color));
                            }
                        }

                    }
                }
            }else if(args[0].equals("toggle") && sender.hasPermission("irg.admin")){
                isEnabled = plugin.getConfig().getBoolean("Enabled");

                if(isEnabled){
                    plugin.getConfig().set("Enabled",false);
                    plugin.saveConfig();
                    plugin.reloadConfig();
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix+toggle_off_message));

                }else{
                    plugin.getConfig().set("Enabled",true);
                    plugin.saveConfig();
                    plugin.reloadConfig();
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix+toggle_on_message));
                }
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();
        List<String> commands = new ArrayList<>();
        if(args.length == 1){
            if(sender.hasPermission("irg.admin")){
                commands.add("reload");
                commands.add("addGlowRule");
                commands.add("toggle");
                StringUtil.copyPartialMatches(args[0], commands, completions);
            }
            Collections.sort(completions);
            return completions;
        }else if(args.length == 2 && args[0].equals("addGlowRule")){
            commands.add("<config-name>");
            StringUtil.copyPartialMatches(args[1], commands, completions);
            Collections.sort(completions);
            return completions;
        }else if(args.length == 3 && args[0].equals("addGlowRule")){
            commands.add("AQUA");
            commands.add("BLACK");
            commands.add("BLUE");
            commands.add("DARK_AQUA");
            commands.add("DARK_BLUE");
            commands.add("DARK_GRAY");
            commands.add("DARK_GREEN");
            commands.add("DARK_PURPLE");
            commands.add("DARK_RED");
            commands.add("GOLD");
            commands.add("GRAY");
            commands.add("GREEN");
            commands.add("RED");
            commands.add("WHITE");
            commands.add("YELLOW");
            commands.add("FLASHY-AQUA");
            commands.add("FLASHY-BLACK");
            commands.add("FLASHY-BLUE");
            commands.add("FLASHY-DARK_AQUA");
            commands.add("FLASHY-DARK_BLUE");
            commands.add("FLASHY-DARK_GRAY");
            commands.add("FLASHY-DARK_GREEN");
            commands.add("FLASHY-DARK_PURPLE");
            commands.add("FLASHY-DARK_RED");
            commands.add("FLASHY-GOLD");
            commands.add("FLASHY-GRAY");
            commands.add("FLASHY-GREEN");
            commands.add("FLASHY-RED");
            commands.add("FLASHY-WHITE");
            commands.add("FLASHY-YELLOW");
            commands.add("RAINBOW");
            StringUtil.copyPartialMatches(args[2], commands, completions);
            Collections.sort(completions);
            return completions;
        }
        return completions;
    }

}
