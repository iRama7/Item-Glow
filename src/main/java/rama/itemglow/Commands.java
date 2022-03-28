package rama.itemglow;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static rama.itemglow.ItemGlow.createItem;

public class Commands implements TabExecutor {

    private ItemGlow plugin;
    public Commands(ItemGlow plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(args.length == 0){
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3&lITEMRARITYGLOW &cUse /irg reload to reload the config!."));
        }else if(args[0].equalsIgnoreCase("reload") && sender.hasPermission("irg.admin")){
            plugin.reloadConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3&lITEMRARITYGLOW &cYou have successfully reloaded the plugin."));
        }else if(args[0].equals("addGlowRule") && sender.hasPermission("irg.admin")){
            if(args.length != 3){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cERROR &eIncorrect number of arguments."));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&ePlease use &3/irg addGlowRule &7<config-name> <glow-color>"));
            }else{
                String config_name = args[1];
                if(plugin.getConfig().isSet("Items."+config_name)){
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cERROR &eThis item is already defined in config."));
                }else{
                    ItemStack itemInHand = p.getInventory().getItemInMainHand();
                    Material materialInHand = p.getInventory().getItemInMainHand().getType();
                    if(materialInHand == Material.AIR){
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cERROR &eYou are not holding any item!"));
                    }else{
                        String material_name = materialInHand.name();
                        String item_displayname = "any";
                        String item_lore = null;
                        if(itemInHand.getItemMeta().hasDisplayName()) {
                            item_displayname = itemInHand.getItemMeta().getDisplayName();
                        }
                        if(itemInHand.getItemMeta().hasLore()){
                            List<String> itemlore = itemInHand.getItemMeta().getLore();
                            item_lore = itemlore.get(itemlore.size()-1);
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
                        if (!glow_colors.contains(glow_color)) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cERROR &eThis glow color does not exist! (" + "&c" + glow_color + "&e)"));
                        }else{
                            sender.sendMessage(createItem(config_name, material_name, item_displayname, item_lore, glow_color));
                        }
                    }

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
                commands.add("addGlowRule <config-name> <glow-color>");
                StringUtil.copyPartialMatches(args[0], commands, completions);
            }
            Collections.sort(completions);
            return completions;
        }
        return completions;
    }
}
