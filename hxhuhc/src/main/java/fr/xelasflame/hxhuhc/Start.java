package fr.xelasflame.hxhuhc;

import com.sun.org.apache.bcel.internal.generic.BIPUSH;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.ObjectUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.util.io.BukkitObjectInputStream;

import javax.management.relation.Role;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Start {

    public static ArrayList<Player> game = new ArrayList<>();
    public  static File file = new File(Main.getPlugin(Main.class).getDataFolder(), "playersinfo.yml");
    public static YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
    public static String winner;


    public static void sendTitle(Player player, String title, String subTitle, int fadeIn, int stay, int fadeOut) {
        String command = "title " + player.getName() + " title " + "{\"text\":\"" + title + "\"}";

        player.getServer().dispatchCommand(player.getServer().getConsoleSender(), command);
    }


        public static void sendTitleToAllPlayers(String title, String subtitle, int fadeIn, int stay, int fadeOut) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                sendTitle(player, title, subtitle, fadeIn, stay, fadeOut);
            }
        }


    public static ArrayList<Player> teamplayer(String team){
    ArrayList<Player> playerlist = new ArrayList<>();
    for (Player player : Bukkit.getOnlinePlayers()) {
        if (config.contains(player.getName())) {
            if (config.get(player.getName()).equals(team)) {
                playerlist.add(player);
            }
        }
    }
    return playerlist;
}

public static void setTabGame(){
    for (Player player : Bukkit.getOnlinePlayers()) {
        if (player.getGameMode().equals(GameMode.SURVIVAL)){
            game.add(player);
        }
    }
}
public static void  dead(Player player){
    game.remove(player);
    String camp = null;
    for (Player vivant : game) {
        if (camp == null){
            camp = RoleManager.getTeam(vivant);
        }
        else if(!camp.equalsIgnoreCase(RoleManager.getTeam(vivant))){
            TimerGame.end = false;
        }
    }
    TimerGame.end = true;
    }

public static String getWinner(){
        return winner;
}
}

