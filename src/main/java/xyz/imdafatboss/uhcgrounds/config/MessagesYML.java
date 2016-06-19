package xyz.imdafatboss.uhcgrounds.config;

import xyz.imdafatboss.uhcgrounds.Home;
import xyz.imdafatboss.uhcgrounds.utils.Msg;

public class MessagesYML {

    public enum Language{

        PREFIX, SAVED_KIT, HASNT_PLAYED, DOESNT_EXIST, ENDERPEARL_CD, ALREADY_INGAME, KICKED,
        JOINED_LOBBY, SET_LOBBY, GAME_STARTED, SET_SPAWN, YOU_WON, PLAYER_LEFT, PLAYER_DIED, TOTAL_LEFT, GRACE

    }

    Language language;

    Home plugin;
    public MessagesYML(Home instance, Language l){

        this.plugin = instance;
        this.language = l;

    }
    FileManager fm;

    public String get(){

        fm = new FileManager(plugin);
        FileManager.Config cfg = fm.getConfig("messages.yml");
        switch (language){

            case PREFIX:

                return Msg.translate(cfg.get().getString("prefix"));

            case SAVED_KIT:

                return Msg.translate(cfg.get().getString("saved-kit"));

            case HASNT_PLAYED:

                return Msg.translate(cfg.get().getString("player-hasnt-played"));

            case DOESNT_EXIST:

                return Msg.translate(cfg.get().getString("player-not-exist"));

            case ENDERPEARL_CD:

                return Msg.translate(cfg.get().getString("enderpearl-cooldown-msg"));

            case ALREADY_INGAME:

                return Msg.translate(cfg.get().getString("already-in-game"));

            case KICKED:

                return Msg.translate(cfg.get().getString("kicked-higher-rank"));

            case JOINED_LOBBY:

                return Msg.translate(cfg.get().getString("joined-game-lobby"));

            case SET_LOBBY:

                return Msg.translate(cfg.get().getString("you-set-lobby"));

            case GAME_STARTED:

                return Msg.translate(cfg.get().getString("game-started"));

            case SET_SPAWN:

                return Msg.translate(cfg.get().getString("you-set-spawn"));

            case YOU_WON:

                return Msg.translate(cfg.get().getString("you-won"));

            case PLAYER_LEFT:

                return Msg.translate(cfg.get().getString("player-left"));

            case PLAYER_DIED:

                return Msg.translate(cfg.get().getString("player-death"));

            case TOTAL_LEFT:

                return Msg.translate(cfg.get().getString("total-left"));

            case GRACE:

                return Msg.translate(cfg.get().getString("currently-grace"));

        }

        return null;

    }

}
