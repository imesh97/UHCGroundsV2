package xyz.imdafatboss.uhcgrounds.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import xyz.imdafatboss.uhcgrounds.Home;
import xyz.imdafatboss.uhcgrounds.config.DataYML;
import xyz.imdafatboss.uhcgrounds.config.GamesYML;

public class StatsEvents implements Listener {

    Home plugin;

    public StatsEvents(Home instance) {

        this.plugin = instance;

    }

    @EventHandler
    public void onPlayerKill(PlayerDeathEvent e) {

        Player p = e.getEntity().getKiller();
        DataYML data = new DataYML(plugin, p);

        if (data.isInGame()) {

            GamesYML game = new GamesYML(plugin, data.getGame());
            if (game.on()) {

                data.setKills(data.getKills() + 1);

            }

        }

    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {

        Player p = e.getEntity();
        DataYML data = new DataYML(plugin, p);

        if (data.isInGame()) {

            GamesYML game = new GamesYML(plugin, data.getGame());
            if (game.on()) {

                data.setDeaths(data.getDeaths() + 1);

            }

        }

    }

    @EventHandler
    public void onPlayerWin(PlayerDeathEvent e) {

        Player p = e.getEntity().getKiller();
        final DataYML data = new DataYML(plugin, p);

        if (data.isInGame()) {

            final GamesYML game = new GamesYML(plugin, data.getGame());
            if (game.on()) {

                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

                    @Override
                    public void run() {

                        if (game.getSize() == 1) {

                            data.setWins(data.getWins() + 1);

                        }

                    }

                }, 40L);

            }

        }

    }

}