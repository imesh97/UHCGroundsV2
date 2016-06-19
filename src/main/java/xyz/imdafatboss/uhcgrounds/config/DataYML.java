package xyz.imdafatboss.uhcgrounds.config;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import xyz.imdafatboss.uhcgrounds.Home;
import xyz.imdafatboss.uhcgrounds.utils.Locations;

public class DataYML {

    Home plugin;
    Player p;
    String uuid;
    String path;
    public DataYML(Home instance, Player player){

        this.plugin = instance;
        this.p = player;
        this.uuid = player.getUniqueId().toString();
        this.path = "players." + uuid + ".";

    }
    public DataYML(Home instance, String u){

        this.plugin = instance;
        this.uuid = u;
        this.path = "players." + uuid + ".";

    }
    FileManager fm;

    public boolean cfgExists(){

        fm = new FileManager(plugin);
        return fm.getConfig("data.yml") != null;

    }

    public boolean exists(String uuid){

        fm = new FileManager(plugin);
        if(fm.getConfig("data.yml").get().isConfigurationSection("players." + uuid)){

            return true;

        }

        return false;

    }

    public FileManager.Config cfg(){

        fm = new FileManager(plugin);
        return fm.getConfig("data.yml");

    }

    public void newPlayer(){

        setKills(0);
        setWins(0);
        setDeaths(0);
        setEnderpearlCooldown(System.currentTimeMillis());
        notInGame();

        cfg().save();

    }

    public Player getPlayer(){

        return this.p;

    }

    public int getKills(){

        return cfg().get().getInt(path + "kills");

    }

    public void setKills(int i){

        cfg().get().set(path + "kills", i);
        cfg().save();

    }

    public int getWins(){

        return cfg().get().getInt(path + "wins");

    }

    public void setWins(int i){

        cfg().get().set(path + "wins", i);
        cfg().save();

    }

    public int getDeaths(){

        return cfg().get().getInt(path + "deaths");

    }

    public void setDeaths(int i){

        cfg().get().set(path + "deaths", i);
        cfg().save();

    }

    public long getEnderpearlCooldown(){

        return cfg().get().getLong(path + "enderpearl");

    }

    public void setEnderpearlCooldown(long time){

        cfg().get().set(path + "enderpearl", time);
        cfg().save();

    }

    public boolean canEnderpearl(){

        return System.currentTimeMillis() > getEnderpearlCooldown();

    }

    public int getGame(){

        return cfg().get().getInt(path + "game");

    }

    public void setGame(int i){

        cfg().get().set(path + "game", i);
        cfg().save();

    }

    public boolean isInGame(){

        return cfg().get().getConfigurationSection(path + "game") != null;

    }

    public void notInGame(){

        cfg().get().set(path + "game", null);
        cfg().save();

    }

    public void sendToLobby(){

        String l = cfg().get().getString("lobby");
        Location loc = Locations.stringToLocation(l);

        getPlayer().teleport(loc);

    }

    public void sendToSpawn(){

        String l = cfg().get().getString("spawn");
        Location loc = Locations.stringToLocation(l);

        getPlayer().teleport(loc);

    }

}
