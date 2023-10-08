package fr.xelasflame.hxhuhc;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import java.util.HashMap;

public class ItemEvent implements Listener {
    public static HashMap<ItemStack, Integer> cooldown = new HashMap<>();

}
