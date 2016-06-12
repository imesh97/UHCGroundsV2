package xyz.imdafatboss.uhcgrounds.utils;

import org.apache.commons.lang.StringEscapeUtils;
import org.bukkit.ChatColor;

public class Msg {

    public static String translate(String s){

        String s1 = StringEscapeUtils.unescapeJava(s);
        return ChatColor.translateAlternateColorCodes('&', s1);

    }

}
