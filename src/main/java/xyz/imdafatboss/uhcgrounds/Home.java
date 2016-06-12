package xyz.imdafatboss.uhcgrounds;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.imdafatboss.uhcgrounds.config.FileManager;

public class Home extends JavaPlugin implements Listener{

    FileManager fm;

    @Override
    public void onEnable(){

        fm = new FileManager(this);
        getLogger().info("Created by imdafatboss");

        fm.getConfig("config.yml").saveDefaultConfig();
        fm.getConfig("data.yml").saveDefaultConfig();
        fm.getConfig("messages.yml").saveDefaultConfig();

    }

}
