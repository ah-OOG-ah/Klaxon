package klaxon.klaxon.init;

import klaxon.klaxon.Klaxon;
import klaxon.klaxon.blocks.KlaxonBlock;
import klaxon.klaxon.items.HandKlaxon;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Klaxon.MOD_ID);

    //initiate motor
    public static final RegistryObject<Item> MOTOR = ITEMS.register("motor",
        () -> new Item(new Item.Properties().group(ModItemGroup.instance)));

    //initiate hornbox
    public static final RegistryObject<Item> HORNBOX = ITEMS.register("hornbox",
            () -> new Item(new Item.Properties().group(ModItemGroup.instance)));

    //initiate cogwheel
    public static final RegistryObject<Item> COGWHEEL = ITEMS.register("cogwheel",
            () -> new Item(new Item.Properties().group(ModItemGroup.instance)));

    //initiate iron bar
    public static final RegistryObject<Item> IRON_BAR = ITEMS.register("iron_bar",
            () -> new Item(new Item.Properties().group(ModItemGroup.instance)));

    //initiate klaxon
    public static final RegistryObject<Item> HAND_KLAXON = ITEMS.register("hand_klaxon",
            () -> new HandKlaxon());

    public static class ModItemGroup extends ItemGroup {

        public static final ModItemGroup instance = new ModItemGroup(ItemGroup.GROUPS.length, "klaxon");

        private ModItemGroup(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack createIcon() {

            return new ItemStack(BlockInit.KLAXON_block.get());

        }
    }

}
