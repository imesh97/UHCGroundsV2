package xyz.imdafatboss.uhcgrounds.listeners;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import xyz.imdafatboss.uhcgrounds.Home;
import xyz.imdafatboss.uhcgrounds.utils.GoldenHead;

public class GoldenHeadEvents implements Listener{

    Home plugin;
    public GoldenHeadEvents(Home instance){

        this.plugin = instance;

    }

    @EventHandler
    public void onSpawnGoldenHead(PlayerDeathEvent e){

        Player p = e.getEntity();

        ItemStack is = GoldenHead.getGoldenHead();
        World world = p.getWorld();
        Location loc = p.getLocation();

        world.dropItem(loc, is);

    }

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent e){

        ItemStack is = e.getItem();
        if(GoldenHead.isHead(is)){

            e.setCancelled(true);
            e.getPlayer().getInventory().remove(is);
            GoldenHead.applyHead(e.getPlayer());

        }

    }

}
