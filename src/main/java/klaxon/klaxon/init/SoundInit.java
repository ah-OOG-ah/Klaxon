package klaxon.klaxon.init;

import klaxon.klaxon.Klaxon;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundInit {

    //Make a sound deferred registry
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Klaxon.MOD_ID);

    //Add hand klaxon sound
    public static final RegistryObject<SoundEvent> HAND_KLAXON = SOUNDS.register("item.hand_klaxon",
            () -> new SoundEvent(new ResourceLocation(Klaxon.MOD_ID, "item.hand_klaxon")));

    //Add klaxon block sound
    public static final RegistryObject<SoundEvent> KLAXON_BLOCK = SOUNDS.register("block.klaxon_block",
            () -> new SoundEvent(new ResourceLocation(Klaxon.MOD_ID, "block.klaxon_block")));

}
