package darkorg.sereneseasonsphc2trees;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(SereneSeasonsPHC2Trees.MOD_ID)

public class SereneSeasonsPHC2Trees {
    public static final String MOD_ID = "sereneseasonsphc2trees";

    public SereneSeasonsPHC2Trees() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
