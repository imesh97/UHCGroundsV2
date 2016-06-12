package xyz.imdafatboss.uhcgrounds.config;

import xyz.imdafatboss.uhcgrounds.Home;
import xyz.imdafatboss.uhcgrounds.utils.Msg;

import java.util.List;

public class StatsGuiYML {

    public enum GuiValue{

        TITLE, KILLS_NAME, KILLS_ITEM, KILLS_SLOT, KILLS_LORE,
        WINS_NAME, WINS_ITEM, WINS_SLOT, WINS_LORE,
        DEATHS_NAME, DEATHS_ITEM, DEATHS_SLOT, DEATHS_LORE

    }

    Home plugin;
    GuiValue val;
    public StatsGuiYML(Home instance, GuiValue v){

        this.plugin = instance;
        this.val = v;

    }
    FileManager fm;

    public String getString(){

        fm = new FileManager(plugin);
        if(fm.getConfig("statsgui.yml") != null){

            FileManager.Config cfg = fm.getConfig("statsgui.yml");
            switch (val){

                case TITLE:

                    return Msg.translate(cfg.get().getString("title"));

                case KILLS_NAME:

                    return Msg.translate(cfg.get().getString("kills.name"));

                case WINS_NAME:

                    return Msg.translate(cfg.get().getString("wins.name"));

                case DEATHS_NAME:

                    return Msg.translate(cfg.get().getString("deaths.name"));

                default:

                    return null;

            }

        }

        return null;

    }

    public int getInt(){

        fm = new FileManager(plugin);
        if(fm.getConfig("statsgui.yml") != null){

            FileManager.Config cfg = fm.getConfig("statsgui.yml");
            switch (val){

                case KILLS_ITEM:

                    return cfg.get().getInt("kills.item");

                case KILLS_SLOT:

                    return cfg.get().getInt("kills.slot");

                case WINS_ITEM:

                    return cfg.get().getInt("wins.item");

                case WINS_SLOT:

                    return cfg.get().getInt("wins.slot");

                case DEATHS_ITEM:

                    return cfg.get().getInt("deaths.item");

                case DEATHS_SLOT:

                    return cfg.get().getInt("deaths.slot");

                default:

                    return 0;

            }

        }

        return 0;

    }

    public List<String> getStringList(){

        fm = new FileManager(plugin);
        if(fm.getConfig("statsgui.yml") != null){

            FileManager.Config cfg = fm.getConfig("statsgui.yml");
            switch (val){

                case KILLS_LORE:

                    return cfg.get().getStringList("kills.lore");

                case WINS_LORE:

                    return cfg.get().getStringList("wins.lore");

                case DEATHS_LORE:

                    return cfg.get().getStringList("deaths.lore");

                default:

                    return null;

            }

        }

        return null;

    }

}
