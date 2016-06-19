package xyz.imdafatboss.uhcgrounds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.imdafatboss.uhcgrounds.cmd.mgmt.CommandManager;
import xyz.imdafatboss.uhcgrounds.config.DataYML;
import xyz.imdafatboss.uhcgrounds.config.FileManager;
import xyz.imdafatboss.uhcgrounds.listeners.Events;

public class Home extends JavaPlugin implements Listener{

    FileManager fm;
    CommandManager cmd;
    Events evt;

    @Override
    public void onEnable(){

        fm = new FileManager(this);
        cmd = new CommandManager(this);
        evt = new Events(this);
        getLogger().info("Created by imdafatboss");

        fm.getConfig("config.yml").saveDefaultConfig();
        fm.getConfig("data.yml").saveDefaultConfig();
        fm.getConfig("messages.yml").saveDefaultConfig();

        for(Player p : Bukkit.getOnlinePlayers()){

            if(!new DataYML(this, p).exists(p.getUniqueId().toString())){

                new DataYML(this, p).newPlayer();

            }

        }

        cmd.registerCommands(this);
        getCommand("savekit").setExecutor(cmd);
        getCommand("stats").setExecutor(cmd);

        evt.registerListeners();

    }

}
