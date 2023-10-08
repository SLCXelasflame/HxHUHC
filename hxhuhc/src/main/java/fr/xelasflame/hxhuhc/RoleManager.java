package fr.xelasflame.hxhuhc;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class RoleManager {

    public  static File file = new File(Main.getPlugin(Main.class).getDataFolder(), "roles.yml");
    public static YamlConfiguration roleinfo = YamlConfiguration.loadConfiguration(file);


    public  static File file2 = new File(Main.getPlugin(Main.class).getDataFolder(), "playersinfo.yml");
    public static YamlConfiguration info = YamlConfiguration.loadConfiguration(file2);

    public static void setRole(Player player, String role){
        info.set(player.getName() + ".role", role);
        try {
            info.save(file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setTeam(player, roleinfo.getString(role + ".team"));
    }

    public static void setTeam(Player player, String team){
        info.set(player.getName() + ".team", team);
        try {
            info.save(file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getRole(Player player){
        return info.getString(player.getName() + ".role") ;
    }

    public static String getTeam(Player player){
        return info.getString(player.getName() + ".team") ;
    }


    public static String getdescription(Player player){
        String role = getRole(player);
        return roleinfo.getString(role + ".description");
    }
}
