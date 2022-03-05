package rama.itemglow;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ItemGlow extends JavaPlugin {

    FileConfiguration config = this.getConfig();
    private static ItemGlow instance;

    @Override
    public void onEnable() {
        instance = this;

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ItemDropEvent(this), this);
        Bukkit.getLogger().severe("[ItemGlow] Cargando eventos...");

        config.options().copyDefaults(true);
        saveDefaultConfig();

        this.getCommand("itemglow").setExecutor(new reloadCommand(this));
        Bukkit.getLogger().severe("[ItemGlow] Cargando comandos...");

        RegisterTeams.registerTeams();
        Bukkit.getLogger().severe("[ItemGlow] Registrando teams...");

        this.reloadConfig();
    }

    @Override
    public void onDisable() {
    }

    public static ItemGlow getInstance() {
        return instance;
    }
}
