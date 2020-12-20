package klaxon;

import klaxon.init.BlockInit;
import klaxon.init.ItemInit;
import klaxon.init.SoundInit;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("klaxon")
public class Klaxon
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    //Set the mod id so I don't have to remember it
    public static String MOD_ID = "klaxon";

    //Main class, main method, the entry point to the mod
    public Klaxon() {
        //An event bus that gets events?
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //Set a listener for when this mod sets up and does client stuff
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        SoundInit.SOUNDS.register(modEventBus); //register sounds
        ItemInit.ITEMS.register(modEventBus); //register items
        BlockInit.BLOCKS.register(modEventBus);//register blocks

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event) {}

    private void doClientStuff(final FMLClientSetupEvent event) {}


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {}

}
