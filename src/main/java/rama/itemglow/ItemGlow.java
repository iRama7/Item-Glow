package rama.itemglow;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.inventivetalent.glow.GlowAPI;

public final class ItemGlow extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ItemDropEvent(this), this);
        Bukkit.getLogger().severe("[ItemGlow] Cargando eventos...");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
