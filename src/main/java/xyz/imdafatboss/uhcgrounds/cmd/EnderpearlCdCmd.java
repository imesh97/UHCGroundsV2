package xyz.imdafatboss.uhcgrounds.cmd;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.imdafatboss.uhcgrounds.Home;
import xyz.imdafatboss.uhcgrounds.cmd.mgmt.CommandFactory;
import xyz.imdafatboss.uhcgrounds.config.DataYML;
import xyz.imdafatboss.uhcgrounds.config.MessagesYML;
import xyz.imdafatboss.uhcgrounds.utils.TimeUtils;

public class EnderpearlCdCmd extends CommandFactory{

    Home plugin;
    public EnderpearlCdCmd(Home instance){

        super("epearl", false);
        this.plugin = instance;

    }

    @Override
    public void execute(CommandSender sender, String[] args){

        Player p = (Player) sender;
        long cd = new DataYML(plugin, p).getEnderpearlCooldown();

        if(!new DataYML(plugin, p).canEnderpearl()){

            String time = TimeUtils.get(cd);
            String prefix = new MessagesYML(plugin, MessagesYML.Language.PREFIX).get();
            String oldLeft = new MessagesYML(plugin, MessagesYML.Language.ENDERPEARL_CD).get();

            String timeLeft = oldLeft.replaceAll("%time%", time);

            p.sendMessage(prefix + " " + timeLeft);

        }

    }

}
