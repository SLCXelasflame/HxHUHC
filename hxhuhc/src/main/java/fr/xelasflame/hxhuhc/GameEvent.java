package fr.xelasflame.hxhuhc;


import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitRunnable;


public class GameEvent implements Listener {



    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.sendMessage("Bienvenue sur le Hunter X Hunter UHC");
        TimerGame.updateScoreboard();
    }


    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        Start.sendTitle(e.getEntity(), "ton aventure s'arrete ici", "",10, 30, 10);
        e.getEntity().setGameMode(GameMode.SPECTATOR);

}}



