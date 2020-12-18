package klaxon.items;

import klaxon.init.SoundInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.util.SoundCategory;


public class LoudItem extends Item {

    public LoudItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        worldIn.playSound(playerIn, playerIn.serverPosX, playerIn.serverPosY, playerIn.serverPosZ, SoundInit.KLAXON.get(), SoundCategory.PLAYERS, 1f, 1f);

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
