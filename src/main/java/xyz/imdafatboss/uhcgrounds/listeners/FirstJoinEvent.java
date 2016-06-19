package xyz.imdafatboss.uhcgrounds.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.imdafatboss.uhcgrounds.Home;
import xyz.imdafatboss.uhcgrounds.config.DataYML;

public class FirstJoinEvent implements Listener{

    Home plugin;
    public FirstJoinEvent(Home instance){

        this.plugin = instance;

    }

    @EventHandler
    public void onFirstJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();
        if(!new DataYML(plugin, p).exists(p.getUniqueId().toString())){

            new DataYML(plugin, p).newPlayer();

        }

    }

}
