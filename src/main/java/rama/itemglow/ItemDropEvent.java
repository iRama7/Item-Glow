package rama.itemglow;

import de.tr7zw.nbtapi.NBTItem;
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
        Boolean isEnabled = plugin.getConfig().getBoolean("Enabled");
        if(!isEnabled){
            return;
        }

        if(mmoHook){
            io.lumine.mythic.lib.api.item.NBTItem nbtItem = io.lumine.mythic.lib.api.item.NBTItem.get(e.getEntity().getItemStack());
            if(nbtItem.hasType()){
                if(nbtItem.hasTag("Glow")){
                    addDirectGLow(e.getEntity(), nbtItem.getString("Glow"));
                }
            }else if(nbtHook){
                NBTItem nbti = new NBTItem(e.getEntity().getItemStack());
                if(nbti.hasKey("Glow")) {
                    addDirectGLow(e.getEntity(), nbtItem.getString("Glow"));
                }
            }
        }
        if(nbtHook){
            NBTItem nbti = new NBTItem(e.getEntity().getItemStack());
            if(nbti.hasKey("Glow")) {
                addDirectGLow(e.getEntity(), nbti.getString("Glow"));
            }
        }
        if(glowed = true){
            return;
        }

        Boolean isEnabled = plugin.getConfig().getBoolean("Enabled");
        if(!isEnabled){
            return;
        }

        for (String string : plugin.getConfig().getConfigurationSection("Items").getKeys(false)) {

            String item_name = plugin.getConfig().getString("Items." + string + ".item-name");
            String glow_color = plugin.getConfig().getString("Items." + string + ".glow-color");
            String material_id = plugin.getConfig().getString("Items." + string + ".item-material");
            String item_lore = plugin.getConfig().getString("Items." + string + ".item-lore");
            Boolean low_priority = false;
            if(plugin.getConfig().isSet("Items."+string+".low-priority")){
               low_priority = plugin.getConfig().getBoolean("Items."+string+".low-priority");
            }


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
            if (item_lore != null) {
                hasLore = true;

            }
            if(!glowed) {
                addGlow(e.getEntity(), e.getEntity().getItemStack(), M, item_name, item_lore, hasMaterial, hasName, hasLore, glow_color, low_priority);
            }


        }
        glowed = false;
    }
}