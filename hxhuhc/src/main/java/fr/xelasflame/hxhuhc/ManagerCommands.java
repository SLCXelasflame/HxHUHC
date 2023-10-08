package fr.xelasflame.hxhuhc;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ManagerCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String index, String[] strings) {
        if( sender instanceof Player){
            Player player = ((Player) sender).getPlayer();
            if (player.isOp()){
                if (index.equalsIgnoreCase("host") && strings[0].equalsIgnoreCase("start")){
                    startCountdown();
                }
            }
            else {
                player.sendMessage("Vous ne pouvez pas executer cette commande ou la commande est erronee");
            }
        }
        return false;
    }



    private void startCountdown() {

        new BukkitRunnable() {
            int count = 6;

            @Override
            public void run() {
                if (count == 6){
                    Start.sendTitleToAllPlayers("La game va bientôt se lancée", "", 10, 30, 10);
                    count --;
                }
                else if (count > 0) {
                    Start.sendTitleToAllPlayers( String.valueOf(count),"", 10, 30, 10);
                    count--;
                } else {
                    Start.sendTitleToAllPlayers("Bonne gamme a tous","" , 10, 30, 10);
                    TimerGame.secondsRemaining = 3600;
                    TimerGame.start();
                    GameManager.gamestart();
                    cancel();
                }
            }
        }.runTaskTimer(Main.getPlugin(Main.class), 0L, 20L);

    }

}


