package fr.xelasflame.hxhuhc;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import java.util.HashMap;

public class ItemEvent implements Listener {
    public static HashMap<ItemStack, Integer> cooldown = new HashMap<>();

    @EventHandler
    public void onClick(PlayerInteractEvent event){
        ItemStack item = event.getItem();
        if (item != null){
         if (item.getType().equals(Material.NETHER_STAR)) {
            event.getPlayer().sendMessage("ça fonctionne");
        }
    }}
}
