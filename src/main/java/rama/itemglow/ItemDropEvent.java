package rama.itemglow;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;

import java.util.List;

import static rama.itemglow.ItemGlow.*;

public class ItemDropEvent implements Listener {

    private ItemGlow plugin;

    public ItemDropEvent(ItemGlow plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void itemDropEvent(ItemSpawnEvent e) {

        for (String string : plugin.getConfig().getConfigurationSection("Items").getKeys(false)) {

            String item_name = plugin.getConfig().getString("Items." + string + ".item-name");
            String glow_color = plugin.getConfig().getString("Items." + string + ".glow-color");
            String material_id = plugin.getConfig().getString("Items." + string + ".item-material");
            List<String> item_lore = plugin.getConfig().getStringList("Items." + string + ".item-lore");

            Boolean hasMaterial = false;
            Boolean hasName = false;
            Boolean hasLore = false;
            Material M = null;

            assert material_id != null;
            if (!material_id.equalsIgnoreCase("any")) {
                hasMaterial = true;
                M = Material.getMaterial(material_id);
            }
            assert item_name != null;
            if (!item_name.equalsIgnoreCase("any")) {
                hasName = true;
            }
            if (!item_lore.isEmpty()) {
                hasLore = true;
            }
            if(!glowed) {
                addGlow(e.getEntity(), e.getEntity().getItemStack(), M, item_name, item_lore, hasMaterial, hasName, hasLore, glow_color);
            }


        }
        glowed = false;
    }
}