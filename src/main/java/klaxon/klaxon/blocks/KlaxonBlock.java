package klaxon.klaxon.blocks;

import klaxon.klaxon.init.SoundInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;

import javax.annotation.Nullable;

//Custom class for the block
public class KlaxonBlock extends Block {

    //Declare any properties we wanna add later
    static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    //Constructor
    public KlaxonBlock() {

        //Add properties (regular, not blockstate)
        super(Properties.of(Material.WOOD)
                .sound(SoundType.WOOD)
                .strength(0.8f, 6f)
        );

        //Set the default blockstate
        this.registerDefaultState(
                this.stateDefinition.any()//empty state container
                        .setValue(POWERED, false)//add the above-defined property with default value false
        );
    }

    //Override the default (empty) block state properties
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        //Add the POWERED property (now keeps track of powered status)
        builder.add(POWERED);
    }

    //If a neighbor changes, things may be afoot
    @Override
    public void neighborChanged(BlockState state, Level levelIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {

        //Make a new blockState as with current block power info
        BlockState newBlockState = state.setValue(POWERED, levelIn.hasNeighborSignal(pos));

        //If it is different (the current state is old)
        if(newBlockState != state) {

            //Check if the world is server (only update on the logical server)
            if(!levelIn.isClientSide) {//true client, false server

                //Set the block state
                levelIn.setBlock(pos, newBlockState, 3);

                //If it is powered
                if (newBlockState.getValue(POWERED)) {

                    //Play a sound too
                    levelIn.playSound(null, pos, SoundInit.KLAXON_BLOCK.get(), SoundSource.BLOCKS, 2.0f, 1.0f);

                }
            }
        }
    }
}
