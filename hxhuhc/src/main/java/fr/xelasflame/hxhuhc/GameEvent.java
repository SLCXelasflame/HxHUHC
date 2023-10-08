package fr.xelasflame.hxhuhc;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;


public class GameEvent implements Listener {


    public static boolean kaito = false;
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.sendMessage("Bienvenue sur le Hunter X Hunter UHC");
        TimerGame.updateScoreboard();
    }



    @EventHandler
    public void findDeath(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player p = (Player) event.getEntity();
            if(event.getDamage() >= p.getHealth()) {
                Location loc = p.getLocation();
                event.setCancelled(true);
                p.setHealth(p.getMaxHealth());
                if (RoleManager.getRole(p).equalsIgnoreCase("Role1") && !kaito){
                    kaito = true;
                    p.teleport(GameManager.generateRandomLocation());
                    p.sendMessage("Pfiou encore eu de la chance");
                }
                else {
                    Bukkit.broadcastMessage(ChatColor.GREEN + p.getDisplayName() + " est mort il etait " + RoleManager.getRole(p));
                    Start.sendTitle(p, "ton aventure s'arrete ici", "",10, 30, 10);
                    p.setGameMode(GameMode.SPECTATOR);
                    for (ItemStack item: p.getInventory()
                         ) {
                        Bukkit.getWorld("world").dropItem(loc, item);
                    }
                    Start.dead(p);
                }
            }
        }
    }}



