package fr.xelasflame.hxhuhc;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class InGameCommands implements CommandExecutor {

        @Override
        public boolean onCommand(CommandSender sender, Command command, String index, String[] label) {
            if( sender instanceof Player){
                Player player = ((Player) sender).getPlayer();
                    if (index.equalsIgnoreCase("hxh")){
                        if(label[0].equalsIgnoreCase("role")){
                            RoleManager.setRole(player, "test");
                            player.sendMessage(RoleManager.getdescription(player));
                        }
                        else {
                        if (label.length != 2){
                            player.sendMessage("La commande est incomplète");
                            return false;
                        }
                        Player player1 = Bukkit.getPlayer(label[1]);
                        if (player1 == null){
                            player.sendMessage("Le joueur " + label[1] + " n existe pas");
                            return false;
                        }
                        else if(label[0].equalsIgnoreCase("sauver")){
                            player1.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 10*20, 1, true, false));
                            player1.sendMessage("On dit pas merci surtout hein!!! Bandes d'ingrats");
                            player1.sendMessage("Le joueur " + label[1] + " viens d'être sauver... encore une fois.");

                        } else if (label[0].equalsIgnoreCase("son")){
                            player.sendMessage("Le joueur fait parti du camp :" + RoleManager.getTeam(player1));
                            player1.sendMessage("Vous entendez murmurer un son dans votre oreille");}

                        else if (label[0].equalsIgnoreCase("sonate")){
                            player.sendMessage("Le joueur " + label[1] + " est touché par la malédiction de santan");
                            player1.setMaxHealth(12.0);
                        }
                        else if (label[0].equalsIgnoreCase("mensonge")){
                            player.sendMessage("Le joueur possède le role :" + RoleManager.getRole(player1));
                            player1.sendMessage("Vous sentez une présence au sein de vos pensées");

                        }
                    }}

                else {
                    player.sendMessage("Vous ne pouvez pas executer cette commande");
                }
            }
            return false;
        }
}
