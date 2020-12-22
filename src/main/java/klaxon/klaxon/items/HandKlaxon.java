package klaxon.klaxon.items;

import klaxon.klaxon.init.ItemInit;
import klaxon.klaxon.init.SoundInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.util.SoundCategory;


public class HandKlaxon extends Item {

    public HandKlaxon() {
        super(new Item.Properties()
                .group(ItemInit.ModItemGroup.instance)
                .maxStackSize(1)
        );
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        System.out.println("soundy");
        System.out.println(SoundInit.HAND_KLAXON.get());
        worldIn.playSound(playerIn, playerIn.serverPosX, playerIn.serverPosY, playerIn.serverPosZ, SoundInit.HAND_KLAXON.get(), SoundCategory.PLAYERS, 1f, 1f);

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
