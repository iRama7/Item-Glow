package rama.itemglow;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ItemGlow extends JavaPlugin {

    FileConfiguration config = this.getConfig();

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ItemDropEvent(this), this);
        Bukkit.getLogger().severe("[ItemGlow] Cargando eventos...");

        config.options().copyDefaults(true);
        saveDefaultConfig();

        this.getCommand("itemglow").setExecutor(new reloadCommand(this));
        Bukkit.getLogger().severe("[ItemGlow] Cargando comandos...");
    }

    @Override
    public void onDisable() {
    }
}
