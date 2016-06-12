package xyz.imdafatboss.uhcgrounds.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.imdafatboss.uhcgrounds.Home;
import xyz.imdafatboss.uhcgrounds.config.StatsGuiYML;
import xyz.imdafatboss.uhcgrounds.utils.Msg;

import java.util.ArrayList;
import java.util.List;

public class StatsGUI {

    Home plugin;
    public StatsGUI(Home instance){

        this.plugin = instance;

    }

    public static ItemStack emptyItem(){

        ItemStack ei = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
        ItemMeta eim = ei.getItemMeta();
        eim.setDisplayName(" ");
        ei.setItemMeta(eim);

        return ei;

    }

    public String getTitle(){

        return new StatsGuiYML(plugin, StatsGuiYML.GuiValue.TITLE).getString();

    }

    public ItemStack getKillsItem(){

        String name = new StatsGuiYML(plugin, StatsGuiYML.GuiValue.KILLS_NAME).getString();
        int item = new StatsGuiYML(plugin, StatsGuiYML.GuiValue.KILLS_ITEM).getInt();
        List<String> lore = new StatsGuiYML(plugin, StatsGuiYML.GuiValue.KILLS_LORE).getStringList();
        List<String> newLore = new ArrayList<String>();

        for(String oldLore : lore){

            newLore.add(Msg.translate(oldLore));

        }

        ItemStack is = new ItemStack(item);
        ItemMeta im = is.getItemMeta();

        im.setDisplayName(Msg.translate(name));
        im.setLore(newLore);

        return is;

    }

    public ItemStack getWinsItem(){

        String name = new StatsGuiYML(plugin, StatsGuiYML.GuiValue.WINS_NAME).getString();
        int item = new StatsGuiYML(plugin, StatsGuiYML.GuiValue.WINS_ITEM).getInt();
        List<String> lore = new StatsGuiYML(plugin, StatsGuiYML.GuiValue.WINS_LORE).getStringList();
        List<String> newLore = new ArrayList<String>();

        for(String oldLore : lore){

            newLore.add(Msg.translate(oldLore));

        }

        ItemStack is = new ItemStack(item);
        ItemMeta im = is.getItemMeta();

        im.setDisplayName(Msg.translate(name));
        im.setLore(newLore);

        return is;

    }

    public ItemStack getDeathsItem(){

        String name = new StatsGuiYML(plugin, StatsGuiYML.GuiValue.DEATHS_NAME).getString();
        int item = new StatsGuiYML(plugin, StatsGuiYML.GuiValue.DEATHS_ITEM).getInt();
        List<String> lore = new StatsGuiYML(plugin, StatsGuiYML.GuiValue.DEATHS_LORE).getStringList();
        List<String> newLore = new ArrayList<String>();

        for(String oldLore : lore){

            newLore.add(Msg.translate(oldLore));

        }

        ItemStack is = new ItemStack(item);
        ItemMeta im = is.getItemMeta();

        im.setDisplayName(Msg.translate(name));
        im.setLore(newLore);

        return is;

    }

    public int getKillsSlot(){

        return new StatsGuiYML(plugin, StatsGuiYML.GuiValue.KILLS_SLOT).getInt();

    }

    public int getWinsSlot(){

        return new StatsGuiYML(plugin, StatsGuiYML.GuiValue.WINS_SLOT).getInt();

    }

    public int getDeathsSlot(){

        return new StatsGuiYML(plugin, StatsGuiYML.GuiValue.DEATHS_SLOT).getInt();

    }

    public Inventory statsGUI(Player p){

        Inventory inv = Bukkit.createInventory(null, 27, getTitle());

        // Create the empty slots.
        for(int i = 0; i < inv.getSize(); i++){

            if(inv.getItem(i) == null || inv.getItem(i).getType() == Material.AIR){

                inv.setItem(i, emptyItem());

            }

        }

        return inv;

    }

}
