package klaxon.init;

import klaxon.Klaxon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {

    //Make a sound deferred registry
    public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS,
            Klaxon.MOD_ID);

    //Add hand klaxon sound
    public static final RegistryObject<SoundEvent> HAND_KLAXON = SOUNDS.register("item.hand_klaxon",
            () -> new SoundEvent(new ResourceLocation(Klaxon.MOD_ID, "item.hand_klaxon")));

    //Add klaxon block sound
    public static final RegistryObject<SoundEvent> KLAXON_BLOCK = SOUNDS.register("block.klaxon_block",
            () -> new SoundEvent(new ResourceLocation(Klaxon.MOD_ID, "block.klaxon_block")));


}
