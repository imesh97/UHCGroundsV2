package xyz.imdafatboss.uhcgrounds.utils;

public class TimeUtils {

    public static String get(long time) {

        long left = time - System.currentTimeMillis();
        int seconds = (int) (left / 1000L) % 60;
        int minutes = (int) (left / 60000L % 60L);
        int hours = (int) (left / 3600000L % 24L);
        int days = (int) (left / 86400000L);
        if (days > 1)
            return days + "d " + hours + "h " + minutes + "m " + seconds + "s";
        if (hours > 1)
            return hours + "h " + minutes + "m " + seconds + "s";
        if (minutes > 1) {
            return minutes + "m " + seconds + "s";
        }
        return seconds + "s";

    }

}
