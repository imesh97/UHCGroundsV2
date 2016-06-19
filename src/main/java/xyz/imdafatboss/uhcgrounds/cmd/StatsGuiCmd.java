package xyz.imdafatboss.uhcgrounds.cmd;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.imdafatboss.uhcgrounds.Home;
import xyz.imdafatboss.uhcgrounds.cmd.mgmt.CommandFactory;
import xyz.imdafatboss.uhcgrounds.config.MessagesYML;
import xyz.imdafatboss.uhcgrounds.gui.StatsGUI;

public class StatsGuiCmd extends CommandFactory{

    Home plugin;
    public StatsGuiCmd(Home instance){

        super("stats", false);
        this.plugin = instance;

    }
    StatsGUI gui;

    @Override
    public void execute(CommandSender sender, String[] args){

        gui = new StatsGUI(plugin);
        Player p = (Player) sender;
        if(args.length == 0){

            p.openInventory(gui.statsGUI(p));

        }

        else if(args.length >= 1){

            String a1 = args[0];
            Player p1 = Bukkit.getPlayer(a1);

            if(p1 != null){

                p.openInventory(gui.statsGUI(p1));
                return;

            }

            else{

                OfflinePlayer tar = Bukkit.getOfflinePlayer(a1);

                if(tar != null){

                    p.openInventory(gui.offlineStatsGUI(tar.getUniqueId().toString()));
                    return;

                }

                else{

                    String s = new MessagesYML(plugin, MessagesYML.Language.DOESNT_EXIST).get();
                    String prefix = new MessagesYML(plugin, MessagesYML.Language.PREFIX).get();

                    p.sendMessage(prefix + " " + s);
                    return;

                }

            }

        }

    }

}
