package com.github.BismuthMod.blocks;

import com.github.BismuthMod.init.ModTileEntityTypes;
import com.github.BismuthMod.tileentity.CrucibleTileEntity;
import com.github.BismuthMod.util.ModItemHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.stream.Stream;

public class CrucibleBlock extends Block {

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    public static final BooleanProperty LIT = BooleanProperty.create("lit");

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(6, 3, 10, 10, 4, 11), Block.makeCuboidShape(5, 3, 6, 11, 4, 10),
            Block.makeCuboidShape(6, 3, 5, 10, 4, 6), Block.makeCuboidShape(10, 4, 10, 11, 10, 11),
            Block.makeCuboidShape(10, 4, 5, 11, 10, 6), Block.makeCuboidShape(5, 4, 10, 6, 10, 11),
            Block.makeCuboidShape(5, 4, 5, 6, 10, 6), Block.makeCuboidShape(6, 4, 11, 10, 10, 12),
            Block.makeCuboidShape(6, 4, 4, 10, 10, 5), Block.makeCuboidShape(4, 4, 6, 5, 10, 10),
            Block.makeCuboidShape(11, 4, 6, 12, 10, 10), Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
            Block.makeCuboidShape(15, 1, 0, 16, 0, 16), Block.makeCuboidShape(1, 1, 15, 15, 0, 16),
            Block.makeCuboidShape(10, 1, 0, 15, 0, 1), Block.makeCuboidShape(0, 1, 0, 1, 4, 16),
            Block.makeCuboidShape(15, 4, 2, 16, 6, 14), Block.makeCuboidShape(0, 4, 2, 1, 6, 14),
            Block.makeCuboidShape(15, 6, 6, 16, 16, 10), Block.makeCuboidShape(0, 6, 6, 1, 16, 10),
            Block.makeCuboidShape(1, 13, 7, 15, 15, 9), Block.makeCuboidShape(6, 1, 0, 10, 3, 1),
            Block.makeCuboidShape(1, 1, 0, 6, 4, 1), Block.makeCuboidShape(6, 2, -1, 10, 3, 0),
            Block.makeCuboidShape(9, 3, -1, 10, 4, 1), Block.makeCuboidShape(6, 3, -1, 7, 4, 1),
            Block.makeCuboidShape(12, 5, 7, 13, 13, 9), Block.makeCuboidShape(3, 5, 7, 4, 13, 9)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(5, 3, 6, 6, 4, 10), Block.makeCuboidShape(6, 3, 5, 10, 4, 11),
            Block.makeCuboidShape(10, 3, 6, 11, 4, 10), Block.makeCuboidShape(5, 4, 10, 6, 10, 11),
            Block.makeCuboidShape(10, 4, 10, 11, 10, 11), Block.makeCuboidShape(5, 4, 5, 6, 10, 6),
            Block.makeCuboidShape(10, 4, 5, 11, 10, 6), Block.makeCuboidShape(4, 4, 6, 5, 10, 10),
            Block.makeCuboidShape(11, 4, 6, 12, 10, 10), Block.makeCuboidShape(6, 4, 4, 10, 10, 5),
            Block.makeCuboidShape(6, 4, 11, 10, 10, 12), Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
            Block.makeCuboidShape(0, 1, 15, 16, 0, 16), Block.makeCuboidShape(0, 1, 1, 1, 0, 15),
            Block.makeCuboidShape(15, 1, 10, 16, 0, 15), Block.makeCuboidShape(0, 1, 0, 16, 4, 1),
            Block.makeCuboidShape(2, 4, 15, 14, 6, 16), Block.makeCuboidShape(2, 4, 0, 14, 6, 1),
            Block.makeCuboidShape(6, 6, 15, 10, 16, 16), Block.makeCuboidShape(6, 6, 0, 10, 16, 1),
            Block.makeCuboidShape(7, 13, 1, 9, 15, 15), Block.makeCuboidShape(15, 1, 6, 16, 3, 10),
            Block.makeCuboidShape(15, 1, 1, 16, 4, 6), Block.makeCuboidShape(16, 2, 6, 17, 3, 10),
            Block.makeCuboidShape(15, 3, 9, 17, 4, 10), Block.makeCuboidShape(15, 3, 6, 17, 4, 7),
            Block.makeCuboidShape(7, 5, 12, 9, 13, 13), Block.makeCuboidShape(7, 5, 3, 9, 13, 4)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(6, 3, 5, 10, 4, 6), Block.makeCuboidShape(5, 3, 6, 11, 4, 10),
            Block.makeCuboidShape(6, 3, 10, 10, 4, 11), Block.makeCuboidShape(5, 4, 5, 6, 10, 6),
            Block.makeCuboidShape(5, 4, 10, 6, 10, 11), Block.makeCuboidShape(10, 4, 5, 11, 10, 6),
            Block.makeCuboidShape(10, 4, 10, 11, 10, 11), Block.makeCuboidShape(6, 4, 4, 10, 10, 5),
            Block.makeCuboidShape(6, 4, 11, 10, 10, 12), Block.makeCuboidShape(11, 4, 6, 12, 10, 10),
            Block.makeCuboidShape(4, 4, 6, 5, 10, 10), Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
            Block.makeCuboidShape(0, 1, 0, 1, 0, 16), Block.makeCuboidShape(1, 1, 0, 15, 0, 1),
            Block.makeCuboidShape(1, 1, 15, 6, 0, 16), Block.makeCuboidShape(15, 1, 0, 16, 4, 16),
            Block.makeCuboidShape(0, 4, 2, 1, 6, 14), Block.makeCuboidShape(15, 4, 2, 16, 6, 14),
            Block.makeCuboidShape(0, 6, 6, 1, 16, 10), Block.makeCuboidShape(15, 6, 6, 16, 16, 10),
            Block.makeCuboidShape(1, 13, 7, 15, 15, 9), Block.makeCuboidShape(6, 1, 15, 10, 3, 16),
            Block.makeCuboidShape(10, 1, 15, 15, 4, 16), Block.makeCuboidShape(6, 2, 16, 10, 3, 17),
            Block.makeCuboidShape(6, 3, 15, 7, 4, 17), Block.makeCuboidShape(9, 3, 15, 10, 4, 17),
            Block.makeCuboidShape(3, 5, 7, 4, 13, 9), Block.makeCuboidShape(12, 5, 7, 13, 13, 9)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();
    ;

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(10, 3, 6, 11, 4, 10), Block.makeCuboidShape(6, 3, 5, 10, 4, 11),
            Block.makeCuboidShape(5, 3, 6, 6, 4, 10), Block.makeCuboidShape(10, 4, 5, 11, 10, 6),
            Block.makeCuboidShape(5, 4, 5, 6, 10, 6), Block.makeCuboidShape(10, 4, 10, 11, 10, 11),
            Block.makeCuboidShape(5, 4, 10, 6, 10, 11), Block.makeCuboidShape(11, 4, 6, 12, 10, 10),
            Block.makeCuboidShape(4, 4, 6, 5, 10, 10), Block.makeCuboidShape(6, 4, 11, 10, 10, 12),
            Block.makeCuboidShape(6, 4, 4, 10, 10, 5), Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
            Block.makeCuboidShape(0, 1, 0, 16, 0, 1), Block.makeCuboidShape(15, 1, 1, 16, 0, 15),
            Block.makeCuboidShape(0, 1, 1, 1, 0, 6), Block.makeCuboidShape(0, 1, 15, 16, 4, 16),
            Block.makeCuboidShape(2, 4, 0, 14, 6, 1), Block.makeCuboidShape(2, 4, 15, 14, 6, 16),
            Block.makeCuboidShape(6, 6, 0, 10, 16, 1), Block.makeCuboidShape(6, 6, 15, 10, 16, 16),
            Block.makeCuboidShape(7, 13, 1, 9, 15, 15), Block.makeCuboidShape(0, 1, 6, 1, 3, 10),
            Block.makeCuboidShape(0, 1, 10, 1, 4, 15), Block.makeCuboidShape(-1, 2, 6, 0, 3, 10),
            Block.makeCuboidShape(-1, 3, 6, 1, 4, 7), Block.makeCuboidShape(-1, 3, 9, 1, 4, 10),
            Block.makeCuboidShape(7, 5, 3, 9, 13, 4), Block.makeCuboidShape(7, 5, 12, 9, 13, 13)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    public CrucibleBlock() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE));
                //.setRequiresTool());
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    public CrucibleBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(LIT, false));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntityTypes.CRUCIBLE.get().create();
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(FACING, LIT);
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public int getLightValue(BlockState state) {
        return state.get(LIT) ? super.getLightValue(state) : 0;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        if (stack.hasDisplayName()) {
            TileEntity tile = worldIn.getTileEntity(pos);
            if (tile instanceof CrucibleTileEntity) {
                ((CrucibleTileEntity) tile).setCustomName(stack.getDisplayName());
            }
        }
    }

    @Override
    public boolean hasComparatorInputOverride(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
        return Container.calcRedstone(worldIn.getTileEntity(pos));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (stateIn.get(LIT)) {
            double d0 = (double) pos.getX() + 0.5D;
            double d1 = (double) pos.getY();
            double d2 = (double) pos.getZ() + 0.5D;
            if (rand.nextDouble() < 0.1D) {
                worldIn.playSound(d0, d1, d2, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F,
                        false);
            }

            Direction direction = stateIn.get(FACING);
            Direction.Axis direction$axis = direction.getAxis();
            double d4 = rand.nextDouble() * 0.6D - 0.3D;
            double d5 = direction$axis == Direction.Axis.X ? (double) direction.getXOffset() * 0.52D : d4;
            double d6 = rand.nextDouble() * 6.0D / 16.0D;
            double d7 = direction$axis == Direction.Axis.Z ? (double) direction.getZOffset() * 0.52D : d4;
            worldIn.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
            worldIn.addParticle(ParticleTypes.FLAME, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
                                             Hand handIn, BlockRayTraceResult hit) {
        if (worldIn != null && !worldIn.isRemote) {
            TileEntity tile = worldIn.getTileEntity(pos);
            if (tile instanceof CrucibleTileEntity) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tile, pos);
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        TileEntity tile = worldIn.getTileEntity(pos);
        if (tile instanceof CrucibleTileEntity && state.getBlock() != newState.getBlock()) {
            CrucibleTileEntity furnace = (CrucibleTileEntity) tile;
            ((ModItemHandler) furnace.getInventory()).toNonNullList().forEach(item -> {
                ItemEntity itemEntity = new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), item);
                worldIn.addEntity(itemEntity);
            });
        }

        if (state.hasTileEntity() && state.getBlock() != newState.getBlock()) {
            worldIn.removeTileEntity(pos);
        }
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.6f;
    }

}
