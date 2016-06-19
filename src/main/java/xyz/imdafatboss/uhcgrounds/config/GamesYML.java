package xyz.imdafatboss.uhcgrounds.config;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import xyz.imdafatboss.uhcgrounds.Home;
import xyz.imdafatboss.uhcgrounds.utils.Debugger;
import xyz.imdafatboss.uhcgrounds.utils.WorldManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GamesYML {

    Home plugin;
    int id;
    String path;
    public GamesYML(Home instance, int id){

        this.plugin = instance;
        this.id = id;
        this.path = "games." + id;

    }
    FileManager fm;

    public boolean cfgExists(){

        fm = new FileManager(plugin);
        return fm.getConfig("games.yml") != null;

    }

    public boolean exists(String id){

        fm = new FileManager(plugin);
        if(fm.getConfig("games.yml").get().isConfigurationSection("games." + id)){

            return true;

        }

        return false;

    }

    public FileManager.Config cfg(){

        fm = new FileManager(plugin);
        return fm.getConfig("games.yml");

    }

    public void newGame(){

        setOn(false);
        setWorld("temp" + this.id);

    }

    public int getID(){

        return this.id;

    }

    public boolean on(){

        return cfg().get().getBoolean(path + ".on");

    }

    public void setOn(boolean b){

        cfg().get().set(path + ".on", b);
        cfg().save();

    }

    public String getWorld(){

        return cfg().get().getString(path + ".world");

    }

    public World world(){

        return Bukkit.getWorld(getWorld());

    }

    public void setWorld(String s){

        cfg().get().set(path + ".world", s);
        cfg().save();

    }

    public void makeWorld(String s){

        Bukkit.createWorld(new WorldCreator(s));
        Debugger.debug("Made world " + s);

        World source = Bukkit.getWorld("template");
        File sourceFolder = source.getWorldFolder();
        File targetFolder = new File(Bukkit.getWorldContainer(), s);

        WorldManager.copyWorld(sourceFolder, targetFolder);
        Debugger.debug("Copied worlds.");

    }

    public List<Player> getPlayers(){

        List<Player> l = new ArrayList<Player>();

        if(exists(this.getID() + "")) {

            for (String s : cfg().get().getStringList(path + ".players")) {

                Player p = Bukkit.getPlayer(s);
                l.add(p);

            }

        }

        else{

            return null;

        }

        return l;

    }

    public int getSize(){

        return getPlayers().size();

    }

    public int getFirst(){

        return cfg().get().getInt(path + ".first");

    }

    public void setFirst(){

        cfg().get().set(path + ".first", getSize());
        cfg().save();

    }

    public boolean canStart(){

        int min = new ConfigYML(plugin, ConfigYML.Value.MIN_PLAYERS).getInt();
        return min <= getSize();

    }

}
