package xyz.imdafatboss.uhcgrounds.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import xyz.imdafatboss.uhcgrounds.Home;
import xyz.imdafatboss.uhcgrounds.config.ConfigYML;
import xyz.imdafatboss.uhcgrounds.config.DataYML;
import xyz.imdafatboss.uhcgrounds.config.MessagesYML;
import xyz.imdafatboss.uhcgrounds.utils.TimeUtils;

public class EnderpearlEvents implements Listener{

    Home plugin;
    public EnderpearlEvents(Home instance){

        this.plugin = instance;

    }

    @EventHandler
    public void onEnderpearl(PlayerTeleportEvent e){

        if(e.getCause() != PlayerTeleportEvent.TeleportCause.ENDER_PEARL){

            return;

        }

        Player p = e.getPlayer();
        if(new DataYML(plugin, p).isInGame()){

            if(new DataYML(plugin, p).canEnderpearl()){

                long now = System.currentTimeMillis();
                int sec = new ConfigYML(plugin, ConfigYML.Value.ENDERPEARL).getInt();
                long t = sec * 1000L;
                long time = now + t;

                new DataYML(plugin, p).setEnderpearlCooldown(time);

            }

            else{

                long cd = new DataYML(plugin, p).getEnderpearlCooldown();

                String time = TimeUtils.get(cd);
                String prefix = new MessagesYML(plugin, MessagesYML.Language.PREFIX).get();
                String oldLeft = new MessagesYML(plugin, MessagesYML.Language.ENDERPEARL_CD).get();

                String timeLeft = oldLeft.replaceAll("%time%", time);

                p.sendMessage(prefix + " " + timeLeft);
                p.getInventory().addItem(new ItemStack(Material.ENDER_PEARL));

            }

        }

    }

}
