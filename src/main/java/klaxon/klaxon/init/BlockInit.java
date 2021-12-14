package klaxon.klaxon.init;

import klaxon.klaxon.Klaxon;
import klaxon.klaxon.blocks.KlaxonBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

//Subscribe to events?
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {

    //block registry
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Klaxon.MOD_ID);

    //initiate klaxon
    public static final RegistryObject<Block> KLAXON_BLOCK = BLOCKS.register("klaxon_block",
            () -> new KlaxonBlock());

    //Subscribe to more events?
    @SubscribeEvent
    public static void onRegisterItems (final RegistryEvent.Register<Item> event) {
        //Make a temporary item registry
        final IForgeRegistry<Item> registry = event.getRegistry();

        //For every block, get the block (not registryobject) and turn it to a blockItem, then register that
        BLOCKS.getEntries().stream().map(RegistryObject::get).forEach( (block) -> {
            final Item.Properties properties = new Item.Properties().tab(ItemInit.ModCreativeModeTab.instance);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });

    }

}
