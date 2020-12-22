package klaxon.klaxon.init;

import klaxon.klaxon.Klaxon;
import klaxon.klaxon.blocks.KlaxonBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

//Subscribe to events?
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {

    //block registry
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Klaxon.MOD_ID);
    //initiate klaxon
    public static final RegistryObject<Block> KLAXON_block = BLOCKS.register("klaxon_block",
            () -> new KlaxonBlock());

    //Subscribe to more events?
    @SubscribeEvent
    public static void onRegisterItems (final RegistryEvent.Register<Item> event) {
        //Make a temporary item registry
        final IForgeRegistry<Item> registry = event.getRegistry();

        //For every block, get the block (not registryobject) and turn it to a blockItem, then register that
        BLOCKS.getEntries().stream().map(RegistryObject::get).forEach( (block) -> {
            final Item.Properties properties = new Item.Properties().group(ItemInit.ModItemGroup.instance);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });

    }

}
