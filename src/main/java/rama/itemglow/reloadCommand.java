package rama.itemglow;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class reloadCommand implements CommandExecutor {

    private ItemGlow plugin;
    public reloadCommand(ItemGlow plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args[0].equalsIgnoreCase("reload") && sender.hasPermission("irg.admin")){
            plugin.reloadConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3&lITEMRARITYGLOW &cYou have successfully reloaded the plugin."));
        }
        return false;
    }
}
