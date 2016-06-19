package xyz.imdafatboss.uhcgrounds.cmd;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.imdafatboss.uhcgrounds.Home;
import xyz.imdafatboss.uhcgrounds.cmd.mgmt.CommandFactory;
import xyz.imdafatboss.uhcgrounds.config.DataYML;
import xyz.imdafatboss.uhcgrounds.config.MessagesYML;
import xyz.imdafatboss.uhcgrounds.utils.Locations;

public class SetLobbyCmd extends CommandFactory{

    Home plugin;
    public SetLobbyCmd(Home instance){

        super("setlobby", "eximus.uhcgrounds.setlobby", false);
        this.plugin = instance;

    }

    @Override
    public void execute(CommandSender sender, String[] args){

        Player p = (Player) sender;
        Location loc = p.getLocation();
        String s = Locations.locationToString(loc);

        new DataYML(plugin, p).cfg().set("lobby", s);
        new DataYML(plugin, p).cfg().save();

        String prefix = new MessagesYML(plugin, MessagesYML.Language.PREFIX).get();
        String setLobby = new MessagesYML(plugin, MessagesYML.Language.SET_LOBBY).get();

        p.sendMessage(prefix + " " + setLobby);

    }

}
