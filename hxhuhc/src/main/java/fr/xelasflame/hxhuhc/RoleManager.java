package fr.xelasflame.hxhuhc;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static java.util.logging.Logger.getLogger;

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
        return roleinfo.getString("roles." + role+ ".description");
    }

    public static void shuffleArray(ArrayList<String> role) {
        int n = role.size();
        Random random = new Random();

        for (int i = n - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            String temp = role.get(i);
            role.set(i,role.get(j));
            role.set(j, temp);
        }
    }

    public static void setRoleAll(){
        ConfigurationSection roleSection = roleinfo.getConfigurationSection("roles");
        ArrayList<String> roleNames = new ArrayList<>(roleSection.getKeys(false));
        if (roleNames.size() < Bukkit.getOnlinePlayers().size()) {
            Bukkit.broadcastMessage("Il y a trop de joueurs dans la partie");
            return;
        }
        shuffleArray(roleNames);
        int i = 0;
        for (Player player : Bukkit.getOnlinePlayers()
                ) {
                String description = roleSection.getString(roleNames.get(i) +".description");
                String camp = roleSection.getString(roleNames.get(i) +".team");

                player.sendMessage(roleNames.get(i));
                player.sendMessage(description);
                player.sendMessage(camp);
                setRole(player, roleNames.get(i));
                setTeam(player, roleSection.getString(roleNames.get(i) + ".camp"));
                i++;
        }}}

