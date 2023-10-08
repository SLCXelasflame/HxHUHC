package fr.xelasflame.hxhuhc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;

public class TimerGame {

    public static boolean end = false;
    public static int secondsRemaining;

    public static int globaltimer;
    public static int actuday;

    public static Scoreboard scoreboard = TeamScoreboard.displayScoreboard();
    public static Objective objective = scoreboard.registerNewObjective(ChatColor.GREEN + "HxH UHC", "dummy");
    public static Team timer = scoreboard.registerNewTeam("timer");

    public static Team jours = scoreboard.registerNewTeam("jours");


    public static void loadobjective(){
        timer.addEntry("Temps : ");
        jours.addEntry("Jours ");
        objective.getScore("Temps : ").setScore(0);
        objective.getScore("Jours ").setScore(1);
        objective.setDisplayName(ChatColor.GREEN +"HxH UHC");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        jours.setSuffix(actuday +"");
        secondsRemaining = 60*2;
        actuday = 1;
        globaltimer = 0;


    }




    public static void start() {
        loadobjective();
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!end || actuday == 1) {
                    if (globaltimer == 10){
                        for (Player player: Bukkit.getOnlinePlayers()) {
                            player.setHealth(20.0);
                        }
                    } else if (globaltimer == 10*60) {
                        Bukkit.broadcastMessage("Pvp et annonce des roles dans 10 min");
                        
                    } else if (globaltimer == 20*60){
                        for (Player player: Bukkit.getOnlinePlayers()) {
                            player.setHealth(20.0);
                            Bukkit.getWorld("world").setPVP(true);
                        }
                        RoleManager.setRoleAll();
                    }
                    if (secondsRemaining > 0) {
                        updateScoreboard();
                        secondsRemaining--;
                        globaltimer++;
                    } else {
                        secondsRemaining = 1200;
                        updateScoreboard();
                        actuday ++;
                        jours.setSuffix(actuday +"");
                    }
                }
                else {
                    Bukkit.broadcastMessage("La game est terminee, victoire des " + Start.getWinner());
                    cancel();
                }
            }
        }.runTaskTimer(Main.getPlugin(Main.class), 0L, 20L);
    }

    public static void updateScoreboard() {


        int minutes =globaltimer  / 60;
        int remainingSeconds = globaltimer % 60;

        String formattedTime = String.format("%02d:%02d", minutes, remainingSeconds);
        timer.setSuffix(formattedTime);
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.setScoreboard(scoreboard);
        }
    }


}



