package xyz.imdafatboss.uhcgrounds.config;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import xyz.imdafatboss.uhcgrounds.Home;
import xyz.imdafatboss.uhcgrounds.utils.Inventories;

public class KitYML {

    public enum KitValue{

        INVENTORY, ARMOR

    }

    Home plugin;
    KitValue val;
    public KitYML(Home instance, KitValue v){

        this.plugin = instance;
        this.val = v;

    }
    FileManager fm;

    public Inventory getInv(){

        fm = new FileManager(plugin);
        if(fm.getConfig("kit.yml") != null){

            FileManager.Config cfg = fm.getConfig("kit.yml");
            switch (val){

                case INVENTORY:

                    return Inventories.getInv(cfg.get().getString("inv"));

                default:

                    return null;

            }

        }

        return null;

    }

    public ItemStack[] getArmor(){

        fm = new FileManager(plugin);
        if(fm.getConfig("kit.yml") != null){

            FileManager.Config cfg = fm.getConfig("kit.yml");
            switch (val){

                case ARMOR:

                    return Inventories.getArmor(cfg.get().getString("armor"));

                default:

                    return null;

            }

        }

        return null;

    }

    public void setInv(String inv){

        fm = new FileManager(plugin);
        if(fm.getConfig("kit.yml") != null){

            FileManager.Config cfg = fm.getConfig("kit.yml");

            cfg.get().set("inv", inv);
            cfg.save();

        }

    }

    public void setArmor(String inv){

        fm = new FileManager(plugin);
        if(fm.getConfig("kit.yml") != null){

            FileManager.Config cfg = fm.getConfig("kit.yml");

            cfg.get().set("armor", inv);
            cfg.save();

        }

    }

}
