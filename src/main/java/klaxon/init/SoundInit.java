package klaxon.init;

import klaxon.Klaxon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {

    public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS,
            Klaxon.MOD_ID);

    public static final RegistryObject<SoundEvent> KLAXON = SOUNDS.register("item.hand_klaxon",
            () -> new SoundEvent(new ResourceLocation(Klaxon.MOD_ID, "item.hand_klaxon")));


}
