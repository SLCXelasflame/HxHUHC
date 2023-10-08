package fr.xelasflame.hxhuhc;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {

        @Override
        public void onEnable() {
            getLogger().info("Le plugin hunter x hunter uhc a ete active !");
            Bukkit.getWorld("world").getWorldBorder().setSize(4096);
            getCommand("host").setExecutor(new ManagerCommands());
            getCommand("hxh").setExecutor(new InGameCommands());
            this.getServer().getPluginManager().registerEvents(new ItemEvent(), this);
            this.getServer().getPluginManager().registerEvents(new GameEvent(), this);
            ItemManager.init();
            TimerGame.loadobjective();
            if (!new File(getDataFolder(), "roles.yml").exists()) {
                saveResource("roles.yml", false);
                getLogger().info("Le fichier roles.yml a été copié depuis les ressources.");
            }


        }

        @Override
        public void onDisable() {
            getLogger().info("Le plugin hunter x hunter uhc a ete desactive!");


        }
    }
