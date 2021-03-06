package me.hugmanrique.pokedata.type;

import lombok.Getter;
import me.hugmanrique.pokedata.loaders.ROMData;
import me.hugmanrique.pokedata.roms.ROM;

/**
 * http://bulbapedia.bulbagarden.net/wiki/Type_chart_data_structure_in_Generation_III
 * @author Hugmanrique
 * @since 29/05/2017
 */
@Getter
public class TypeBaseStats {
    private static final int SIZE = 112;
    public static TypeBaseStats[] BASE_STATS;

    private Type attacking;
    private Type defending;
    private byte effectiveness;

    private TypeBaseStats(byte attacking, byte defending, byte effectiveness) {
        this.attacking = Type.byId(attacking);
        this.defending = Type.byId(defending);
        this.effectiveness = effectiveness;
    }

    /**
     * Loads the type chart. Normally effective attacks, such
     * as Fighting on Poison are not listed in the table.
     */
    public static void load(ROM rom, ROMData data) {
        BASE_STATS = new TypeBaseStats[SIZE];

        rom.seek(data.getPokedexTypeTable());

        for (int i = 0; i < SIZE; i++) {
            TypeBaseStats stats = new TypeBaseStats(
                rom.readByte(),
                rom.readByte(),
                rom.readByte()
            );

            BASE_STATS[i] = stats;
        }
    }
}
