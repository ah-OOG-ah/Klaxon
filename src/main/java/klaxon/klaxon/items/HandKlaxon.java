package klaxon.klaxon.items;
//

import klaxon.klaxon.Klaxon;
import klaxon.klaxon.init.ItemInit;
import klaxon.klaxon.init.SoundInit;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

//As per usual, extend Item
public class HandKlaxon extends Item {

    //Put it in the proper tab and set stack size
    public HandKlaxon() {
        super(new Properties()
                .tab(ItemInit.ModCreativeModeTab.instance)
                .stacksTo(1)
        );
    }

    //When used...
    @Override
    public InteractionResultHolder<ItemStack> use(Level levelIn, Player playerIn, InteractionHand handIn) {

        //Make some noise!
        levelIn.playSound(null, playerIn, SoundInit.HAND_KLAXON.get(), SoundSource.PLAYERS, 1f, 1f);

        //Call original item function, so as not to break other code dependent on it
        return super.use(levelIn, playerIn, handIn);
    }
}
