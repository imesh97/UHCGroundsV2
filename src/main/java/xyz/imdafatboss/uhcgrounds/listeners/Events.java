package xyz.imdafatboss.uhcgrounds.listeners;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import xyz.imdafatboss.uhcgrounds.Home;

public class Events {

    Home plugin;
    public Events(Home instance){

        this.plugin = instance;

    }

    public void registerListeners(){

        PluginManager pm = Bukkit.getServer().getPluginManager();

        pm.registerEvents(new FirstJoinEvent(plugin), plugin);
        pm.registerEvents(new GoldenHeadEvents(plugin), plugin);
        pm.registerEvents(new EnderpearlEvents(plugin), plugin);

    }

}
