package xyz.imdafatboss.uhcgrounds.cmd;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import xyz.imdafatboss.uhcgrounds.Home;
import xyz.imdafatboss.uhcgrounds.cmd.mgmt.CommandFactory;
import xyz.imdafatboss.uhcgrounds.config.KitYML;
import xyz.imdafatboss.uhcgrounds.config.MessagesYML;
import xyz.imdafatboss.uhcgrounds.utils.Inventories;

public class SaveKitCmd extends CommandFactory{

    Home plugin;
    public SaveKitCmd(Home instance){

        super("savekit", "eximus.uhcgrounds.savekit", false);
        this.plugin = instance;

    }

    @Override
    public void execute(CommandSender sender, String[] args){

        Player p = (Player) sender;
        Inventory inv = p.getInventory();
        ItemStack[] armor = p.getInventory().getArmorContents();

        String prefix = new MessagesYML(plugin, MessagesYML.Language.PREFIX).get();
        String savedKit = new MessagesYML(plugin, MessagesYML.Language.SAVED_KIT).get();

        String newInv = Inventories.halfInv(inv);
        String newArmor = Inventories.armorInv(armor);

        new KitYML(plugin, KitYML.KitValue.INVENTORY).setInv(newInv);
        new KitYML(plugin, KitYML.KitValue.ARMOR).setArmor(newArmor);

        p.sendMessage(prefix + " " + savedKit);

    }

}
