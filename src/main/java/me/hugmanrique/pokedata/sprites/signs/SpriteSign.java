package me.hugmanrique.pokedata.sprites.signs;

import lombok.Getter;
import me.hugmanrique.pokedata.roms.ROM;
import me.hugmanrique.pokedata.sprites.Sprite;

/**
 * @author Hugmanrique
 * @since 02/05/2017
 */
@Getter
public class SpriteSign extends Sprite {
    // TODO Check if some of these bytes are words values
    private byte b2;
    private byte b4;
    private byte b5;
    private byte b6;
    private byte b7;
    private byte b8;
    private long scriptPtr;

    public SpriteSign(ROM rom) {
        x = rom.readByte();
        b2 = rom.readByte();
        y = rom.readByte();
        b4 = rom.readByte();
        b5 = rom.readByte();
        b6 = rom.readByte();
        b7 = rom.readByte();
        b8 = rom.readByte();
        scriptPtr = rom.getPointer();
    }

    @Override
    public int getSize() {
        return 12;
    }
}
