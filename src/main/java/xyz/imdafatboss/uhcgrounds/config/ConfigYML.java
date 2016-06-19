package xyz.imdafatboss.uhcgrounds.config;

import xyz.imdafatboss.uhcgrounds.Home;

import java.util.List;

public class ConfigYML {

    public enum Value{

        MAX_PLAYERS, MIN_PLAYERS, SCATTER_RADIUS, SCATTER_DISTANCE, WIN_COMMANDS, REGEN, GRACE, ENDERPEARL

    }

    Home plugin;
    Value val;
    public ConfigYML(Home instance, Value v){

        this.plugin = instance;
        this.val = v;

    }
    FileManager fm;

    public int getInt(){

        fm = new FileManager(plugin);
        if(fm.getConfig("config.yml") != null){

            FileManager.Config cfg = fm.getConfig("config.yml");
            switch (val){

                case MAX_PLAYERS:

                    return cfg.get().getInt("max-players");

                case MIN_PLAYERS:

                    return cfg.get().getInt("min-players");

                case SCATTER_RADIUS:

                    return cfg.get().getInt("scatter.radius");

                case SCATTER_DISTANCE:

                    return cfg.get().getInt("scatter.distance");

                case GRACE:

                    return cfg.get().getInt("grace");

                case ENDERPEARL:

                    return cfg.get().getInt("enderpearl-sec");

                default:

                    return 0;

            }

        }

        return 0;

    }

    public boolean getBoolean(){

        fm = new FileManager(plugin);
        if(fm.getConfig("config.yml") != null){

            FileManager.Config cfg = fm.getConfig("config.yml");
            switch (val){

                case REGEN:

                    return cfg.get().getBoolean("regen");

                default:

                    return false;

            }

        }

        return false;

    }

    public List<String> getStringList(){

        fm = new FileManager(plugin);
        if(fm.getConfig("config.yml") != null){

            FileManager.Config cfg = fm.getConfig("config.yml");
            switch (val){

                case WIN_COMMANDS:

                    return cfg.get().getStringList("win-commands");

                default:

                    return null;

            }

        }

        return null;

    }

}
