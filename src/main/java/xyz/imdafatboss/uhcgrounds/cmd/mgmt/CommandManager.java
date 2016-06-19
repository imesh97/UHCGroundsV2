package xyz.imdafatboss.uhcgrounds.cmd.mgmt;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.imdafatboss.uhcgrounds.Home;
import xyz.imdafatboss.uhcgrounds.cmd.*;
import xyz.imdafatboss.uhcgrounds.config.ConfigYML;
import xyz.imdafatboss.uhcgrounds.config.MessagesYML;
import xyz.imdafatboss.uhcgrounds.utils.Msg;

import java.util.*;

public class CommandManager implements CommandExecutor {

    Home plugin;
    public CommandManager(Home instance){

        this.plugin = instance;

    }

    private List<CommandFactory> commands = new ArrayList<CommandFactory>();

    public void registerCommand(CommandFactory cmd) {

        commands.add(cmd);

    }

    public void registerCommands(Home jp){

        registerCommand(new SaveKitCmd(jp));
        registerCommand(new StatsGuiCmd(jp));
        registerCommand(new SetLobbyCmd(jp));
        registerCommand(new EnderpearlCdCmd(jp));
        registerCommand(new SetSpawnCmd(jp));

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        for (CommandFactory cmds : commands) {

            if (cmds.getName().equalsIgnoreCase(cmd.getName())){

                if(sender instanceof Player) {

                    if(cmds.getPermission() != null) {

                        if (sender.hasPermission(cmds.getPermission())) {

                            cmds.execute(sender, args);

                        }

                        else{

                            String prefix = new MessagesYML(plugin, MessagesYML.Language.PREFIX).get();
                            String noPerm = Msg.translate("&cYou do not have permission to execute this command.");

                            sender.sendMessage(prefix + " " + noPerm);

                        }

                    }

                    else{

                        cmds.execute(sender, args);

                    }

                }

                else{

                    if(cmds.allowsConsole()){

                        cmds.execute(sender, args);

                    }

                }

            }

        }

        return false;

    }

}