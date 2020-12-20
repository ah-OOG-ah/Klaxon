package klaxon.blocks;

import klaxon.init.SoundInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class KlaxonBlock extends Block {

    static final BooleanProperty POWERED = BlockStateProperties.POWERED;


    public KlaxonBlock() {

        super(Block.Properties.create(Material.WOOD)
                .sound(SoundType.WOOD)
                .hardnessAndResistance( 0.8f, 6f)
                .harvestLevel(0)
                .harvestTool(ToolType.AXE)
        );

        this.setDefaultState(
            this.stateContainer.getBaseState()
                    .with(POWERED, false)
        );

    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
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

        BlockState newBlockState = state.with(POWERED, worldIn.isBlockPowered(pos));
        System.out.println("\nclear\nclear\nclear\nclear\nclear");
        System.out.println(newBlockState);
        System.out.println(state);
        System.out.println("\nclear\nclear\nclear\nclear\nclear");

        if(newBlockState != state) {
            if(worldIn.isRemote()) {
                worldIn.setBlockState(pos, newBlockState);
            }
            if (newBlockState.get(POWERED)) {
                worldIn.playSound(null, pos, SoundInit.KLAXON.get(), SoundCategory.BLOCKS, 1.0f, 1.0f);
            }
        }

    }
}
