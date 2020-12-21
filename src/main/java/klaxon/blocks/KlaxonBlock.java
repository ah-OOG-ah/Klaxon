package klaxon.blocks;

import klaxon.init.SoundInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

//Custom class for the block
public class KlaxonBlock extends Block {

    //Declare any properties we wanna add later
    static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    //Constructor
    public KlaxonBlock() {

        //Add properties (regular, not blockstate)
        super(Block.Properties.create(Material.WOOD)
                .sound(SoundType.WOOD)
                .hardnessAndResistance(0.8f, 6f)
                .harvestLevel(0)
                .harvestTool(ToolType.AXE)
        );

        //Set the default blockstate
        this.setDefaultState(
                this.stateContainer.getBaseState()//empty state container
                        .with(POWERED, false)//add the above-defined property with default value false
        );

    }

    //Override the default (empty) block state properties
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {

        //Add the POWERED property (now keeps track of powered status)
        builder.add(POWERED);

    }

    //Automatically return false to reduce number of calls
    @Override
    public boolean canConnectRedstone(BlockState state, IBlockReader world, BlockPos pos, @Nullable Direction side) {
        return false;
    }

    //If a neighbor changes, things may be afoot
    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {

        //Make a new blockState as with current block power info
        BlockState newBlockState = state.with(POWERED, worldIn.isBlockPowered(pos));

        //If it is different (the current state is old)
        if(newBlockState != state) {

            //Check if the world is server (only update on the logical server)
            if(!worldIn.isRemote()) {//true client, false server

                //Set the block state
                worldIn.setBlockState(pos, newBlockState);

                //If it is powered
                if (newBlockState.get(POWERED)) {

                    //Play a sound too
                    worldIn.playSound(null, pos, SoundInit.KLAXON.get(), SoundCategory.BLOCKS, 1.0f, 1.0f);

                }

            }

        }

    }

}
