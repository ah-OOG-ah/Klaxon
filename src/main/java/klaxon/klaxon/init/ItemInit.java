package klaxon.klaxon.init;

import klaxon.klaxon.Klaxon;
import klaxon.klaxon.blocks.KlaxonBlock;
import klaxon.klaxon.items.HandKlaxon;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Klaxon.MOD_ID);//DeferredRegister<Item>.create(ForgeRegistries.ITEMS, Klaxon.MOD_ID);

    //initiate motor
    public static final RegistryObject<Item> MOTOR = ITEMS.register("motor",
        () -> new Item(new Item.Properties().tab(ModCreativeModeTab.instance)));

    //initiate hornbox
    public static final RegistryObject<Item> HORNBOX = ITEMS.register("hornbox",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.instance)));

    //initiate cogwheel
    public static final RegistryObject<Item> COGWHEEL = ITEMS.register("cogwheel",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.instance)));

    //initiate iron bar
    public static final RegistryObject<Item> IRON_BAR = ITEMS.register("iron_bar",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.instance)));

    //initiate klaxon
    public static final RegistryObject<Item> HAND_KLAXON = ITEMS.register("hand_klaxon",
            () -> new HandKlaxon());

    //Create an ItemGroup
    public static class ModCreativeModeTab extends CreativeModeTab {

        public static final ModCreativeModeTab instance = new ModCreativeModeTab(CreativeModeTab.getGroupCountSafe(), "klaxon");

        private ModCreativeModeTab(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack makeIcon() {

            return new ItemStack(BlockInit.KLAXON_BLOCK.get());
        }
    }

}
