package me.hugmanrique.pokedata.utils;

import me.hugmanrique.pokedata.roms.Game;
import me.hugmanrique.pokedata.roms.ROM;

/**
 * @author Hugmanrique
 * @since 28/05/2017
 */
public class ROMUtils {
    public static boolean isGame(ROM rom, Game... games) {
        for (Game game : games) {
            if (rom.getGame() == game) {
                return true;
            }
        }

        return false;
    }
}
